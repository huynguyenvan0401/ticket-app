package com.zeran.ticket.controller;

import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.payload.PeopleCheckinDto;
import com.zeran.ticket.payload.PeopleDto;
import com.zeran.ticket.request.PeopleRequest;
import com.zeran.ticket.response.PeopleAccountResponse;
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
@CrossOrigin
public class PeopleController {
    private final PeopleService peopleService;
    private final ModelMapper mapper;
    private final CheckinService checkinService;


    @GetMapping()
    public ResponseEntity<List<PeopleCheckinDto>> getAllPeopleCheckin() {
        List<PeopleCheckinDto> peoples = peopleService.getAllPeopleCheckins();
        return ResponseEntity.ok(peoples);
    }

    @GetMapping("account")
    public ResponseEntity<List<PeopleAccountResponse>> getAllPeopleAccount() {
        List<PeopleDto> peoples = peopleService.getPeopleAccounts();
        List<PeopleAccountResponse> peopleAccounts = peoples.stream()
                .map(peopleDto -> mapper.map(peopleDto, PeopleAccountResponse.class)).collect(Collectors.toList());
        return ResponseEntity.ok(peopleAccounts);
    }

    @PreAuthorize("hasRole('DRIVER')")
    @GetMapping("account/drive")
    public ResponseEntity<List<PeopleAccountResponse>> getAllPeopleAccountByDriver() {
        List<PeopleDto> peoples = peopleService.getPeopleAccountByDriver();
        List<PeopleAccountResponse> peopleAccounts = peoples.stream()
                .map(peopleDto -> mapper.map(peopleDto, PeopleAccountResponse.class)).collect(Collectors.toList());
        return ResponseEntity.ok(peopleAccounts);
    }

    @PreAuthorize("hasRole('DRIVER')")
    @GetMapping("/drive")
    public ResponseEntity<List<PeopleCheckinDto>> getPeopleDrive() {
        List<PeopleCheckinDto> peoples = peopleService.getPeopleCheckinDrive();
        return ResponseEntity.ok(peoples);
    }

    @PreAuthorize("hasRole('DRIVER')")
    @PostMapping("/updateNoteByDriver")
    public ResponseEntity updateNoteByDriver(@RequestBody PeopleRequest peopleRequest) {
        peopleService.updateNoteByDriver(peopleRequest);
        return ResponseEntity.ok("Success update note!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/updatePeopleDrive")
    public ResponseEntity updatePeopleDrive(@RequestBody PeopleRequest peopleRequest) {
        peopleService.updatePeopleDrive(peopleRequest);
        return ResponseEntity.ok("Success update people!");
    }

    @PreAuthorize("hasRole('DRIVER')")
    @PostMapping("/updateCar")
    public ResponseEntity updatePeopleCar(@RequestBody PeopleRequest peopleRequest) {
        peopleService.updatePeopleCar(peopleRequest);
        return ResponseEntity.ok("Success update people!");
    }
}
