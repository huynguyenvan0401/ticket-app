package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.Code;
import com.zeran.ticket.entity.People;
import com.zeran.ticket.exception.*;
import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.repository.*;
import com.zeran.ticket.request.CheckinRequest;
import com.zeran.ticket.service.CheckinService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckinServiceImpl implements CheckinService {
    private final CheckinRepository checkinRepository;
    private final PeopleRepository peopleRepository;
    private final CodeRepository codeRepository;
    private final UserRepository userRepository;

    private final CarRepository carRepository;

    private final ModelMapper mapper;

    @Override
    public CheckinDto createCheckin(CheckinRequest checkinRequest) {

        Optional<People> people = peopleRepository.findById(checkinRequest.getPeopleId());
        if (!people.isPresent()) {
            throw new BadRequestException("Thành viên không tồn tại!");
        }

        Optional<Car> car = carRepository.findById(checkinRequest.getCarId());
        if (!car.isPresent()) {
            throw new BadRequestException(String.format("Xe không tồn tại, carId: %s", checkinRequest.getCarId().toString()));
        }

        if (!Objects.equals(people.get().getCar().getId(), checkinRequest.getCarId())) {
            throw new BadRequestException(String.format("Checkin nhầm xe, xe của bạn là: %s. Xe bạn đang checkin là: %s",
                    people.get().getCar().getLicensePlate(), car.get().getLicensePlate()));
        }

        Optional<Checkin> existCheckin = checkinRepository.findTopByPeopleAndCar(people.get(), car.get());
        if (existCheckin.isPresent()) {
            throw new BadRequestException(String.format("Bạn đã checkin rồi: %s", people.get().getAccount()));
        }


        var checkin = Checkin.builder()
                .people(people.get())
                .car(car.get())
                .build();

        Optional<Code> code = codeRepository.findByCode(checkinRequest.getCode());
        if (code.isPresent()) {
            checkin.setCode(code.get());
        }
        Checkin createdCheckin = checkinRepository.save(checkin);
        return mapper.map(createdCheckin, CheckinDto.class);
    }

    @Override
    public List<CheckinDto> getAllCheckins() {
        List<Checkin> checkins = checkinRepository.findAll();
        return checkins.stream().map(checkin -> mapper.map(checkin, CheckinDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CheckinDto> getAllCheckinsForDriver() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        List<Checkin> checkins = checkinRepository.findAllByCarId(user.getCar().getId());
        return checkins.stream().map(checkin -> mapper.map(checkin, CheckinDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void resetDriveCheckin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        checkinRepository.deleteAllByCarId(user.getCar().getId());
    }

    @Override
    @Transactional
    public void resetAllCheckin() {
        checkinRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteByPeopleId(Long id) {
        checkinRepository.deleteAllByPeopleId(id);
    }

}
