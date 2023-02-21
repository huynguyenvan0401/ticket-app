package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.People;
import com.zeran.ticket.exception.BadRequestException;
import com.zeran.ticket.exception.NotFoundException;
import com.zeran.ticket.exception.UserNotFoundException;
import com.zeran.ticket.payload.PeopleCheckinDto;
import com.zeran.ticket.payload.PeopleDto;
import com.zeran.ticket.repository.*;
import com.zeran.ticket.request.PeopleRequest;
import com.zeran.ticket.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    private final CheckinRepository checkinRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<PeopleCheckinDto> getAllPeopleCheckins() {
        List<People> peoples = peopleRepository.findAll();
        List<Checkin> checkins = checkinRepository.findAll();

        return getPeopleCheckinList(peoples, checkins);
    }

    @Override
    public List<PeopleCheckinDto> getPeopleCheckinDrive() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        List<People> peoples = peopleRepository.findAllByCarId(user.getCar().getId());
        List<Checkin> checkins = checkinRepository.findAllByCarId(user.getCar().getId());

        return getPeopleCheckinList(peoples, checkins);
    }

    @Override
    public void updateNoteByDriver(PeopleRequest peopleRequest) {
        var people = peopleRepository.findById(peopleRequest.getId())
                .orElseThrow(() -> new NotFoundException("People not found!"));

        var car = carRepository.findById(peopleRequest.getCarId())
                .orElseThrow(() -> new NotFoundException("Car not found!"));

        var room = roomRepository.findById(peopleRequest.getRoomId())
                .orElseThrow(() -> new NotFoundException("Room not found!"));

        if (people.getCar().getId() != peopleRequest.getCarId()) {
            Optional<Checkin> checkin = checkinRepository.findByPeople(people);
            if (checkin.isPresent()) {
                checkin.get().setCar(car);
                checkinRepository.save(checkin.get());
            }
        }

        people.setNote(peopleRequest.getNote());
        people.setCar(car);
        people.setRoom(room);
        peopleRepository.save(people);
    }

    @Override
    public void updatePeopleDrive(PeopleRequest peopleRequest) {
        var people = peopleRepository.findById(peopleRequest.getId())
                .orElseThrow(() -> new NotFoundException("People not found!"));

        var car = carRepository.findById(peopleRequest.getCarId())
                .orElseThrow(() -> new NotFoundException("Car not found!"));

        var room = roomRepository.findById(peopleRequest.getRoomId())
                .orElseThrow(() -> new NotFoundException("Room not found!"));

        if (people.getCar().getId() != peopleRequest.getCarId()) {
            Optional<Checkin> checkin = checkinRepository.findByPeople(people);
            if (checkin.isPresent()) {
                checkin.get().setCar(car);
                checkinRepository.save(checkin.get());
            }
        }

        people.setNote(peopleRequest.getNote());
        people.setCar(car);
        people.setRoom(room);
        peopleRepository.save(people);

    }

    @Override
    public List<PeopleDto> getPeopleAccounts() {
        List<People> peoples = peopleRepository.findAll();
        return peoples.stream().map(people -> mapper.map(people, PeopleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PeopleDto> getPeopleAccountByDriver() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

//        change this
        List<People> peoples = peopleRepository.findAccountByDriver(user.getCar().getId());
        return peoples.stream().map(people -> mapper.map(people, PeopleDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updatePeopleCar(PeopleRequest peopleRequest) {
        var people = peopleRepository.findById(peopleRequest.getId())
                .orElseThrow(() -> new BadRequestException("People not found!"));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        people.setCar(user.getCar());

        peopleRepository.save(people);
    }

    private List<PeopleCheckinDto> getPeopleCheckinList(List<People> peoples, List<Checkin> checkins) {
        List<PeopleCheckinDto> peopleCheckins = new ArrayList<>();

        for (People people: peoples) {
            Boolean isChecked = false;
            for (Checkin checkin: checkins) {
                if (checkin.getPeople().getId() == people.getId()) {
                    isChecked = true;
                }
            }
            peopleCheckins.add(PeopleCheckinDto.builder()
                    .id(people.getId())
                    .account(people.getAccount())
                    .carId(people.getCar().getId())
                    .licensePlate(people.getCar().getLicensePlate())
                    .phoneNumber(people.getPhoneNumber())
                    .note(people.getNote())
                    .roomId(people.getRoom().getId())
                    .roomType(people.getRoom().getType())
                    .roomNumber(people.getRoom().getNumber())
                    .isCheckedIn(isChecked)
                    .isRoomMaster(people.getIsRoomMaster())
                    .build());
        }

        return peopleCheckins;
    }
}
