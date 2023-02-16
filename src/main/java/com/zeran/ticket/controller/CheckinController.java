package com.zeran.ticket.controller;

import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.request.CheckinRequest;
import com.zeran.ticket.response.CheckinResponse;
import com.zeran.ticket.service.CheckinService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/checkin")
@RequiredArgsConstructor
@CrossOrigin
public class CheckinController {
    private final CheckinService checkinService;

    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<CheckinDto> createCheckin(@RequestBody CheckinRequest checkinRequest) {

        return new ResponseEntity<>(checkinService.createCheckin(checkinRequest), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('DRIVER')")
    @GetMapping()
    public List<CheckinResponse> getAllCheckins() {
        return checkinService.getAllCheckins()
                .stream().map(checkin -> mapper.map(checkin, CheckinResponse.class)).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('DRIVER')")
    @DeleteMapping("/drive")
    public ResponseEntity resetDriveCheckin() {
        checkinService.resetDriveCheckin();
        return ResponseEntity.ok("Delete all checkin of driver");
    }

}
