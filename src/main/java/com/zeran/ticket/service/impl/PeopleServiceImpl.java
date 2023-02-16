package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.People;
import com.zeran.ticket.exception.NotFoundException;
import com.zeran.ticket.exception.UserNotFoundException;
import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.payload.PeopleDto;
import com.zeran.ticket.repository.PeopleRepository;
import com.zeran.ticket.repository.UserRepository;
import com.zeran.ticket.request.PeopleRequest;
import com.zeran.ticket.response.PeopleResponse;
import com.zeran.ticket.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    @Override
    public List<PeopleDto> getAllPeoples() {
        List<People> peoples = peopleRepository.findAll();
        return peoples.stream().map(people -> mapper.map(people, PeopleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PeopleDto> getPeopleDrive() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        List<People> peoples = peopleRepository.findAllByCarId(user.getCar().getId());
        return peoples.stream().map(people -> mapper.map(people, PeopleDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updateNoteByDriver(PeopleRequest peopleRequest) {
        var people = peopleRepository.findById(peopleRequest.getId())
                .orElseThrow(() -> new NotFoundException("People not found!"));
        people.setNote(peopleRequest.getNote());
        peopleRepository.save(people);
    }
}
