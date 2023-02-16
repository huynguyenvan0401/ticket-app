package com.zeran.ticket.controller;

import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.payload.PeopleDto;
import com.zeran.ticket.request.PeopleRequest;
import com.zeran.ticket.response.PeopleResponse;
import com.zeran.ticket.service.CheckinService;
import com.zeran.ticket.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;
    private final ModelMapper mapper;


    @GetMapping()
    public ResponseEntity<List<PeopleResponse>> getAllPeoples() {
        List<PeopleDto> peoples = peopleService.getAllPeoples();
        List<PeopleResponse> peopleResponses = peoples
                .stream()
                .map(people -> mapper.map(people, PeopleResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(peopleResponses);
    }

    @PreAuthorize("hasRole('DRIVER')")
    @GetMapping("/drive")
    public ResponseEntity<List<PeopleResponse>> getPeopleDrive() {
        List<PeopleDto> peoples = peopleService.getAllPeoples();
        List<PeopleResponse> peopleResponses = peoples
                .stream()
                .map(people -> mapper.map(people, PeopleResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(peopleResponses);
    }

    @PreAuthorize("hasRole('DRIVER')")
    @PostMapping("/updateNoteByDriver")
    public ResponseEntity updateNoteByDriver(@RequestBody PeopleRequest peopleRequest) {
        peopleService.updateNoteByDriver(peopleRequest);
        return ResponseEntity.ok("Success update note!");
    }
}
