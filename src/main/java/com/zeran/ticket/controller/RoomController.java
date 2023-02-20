package com.zeran.ticket.controller;

import com.zeran.ticket.payload.CarDto;
import com.zeran.ticket.payload.RoomDto;
import com.zeran.ticket.service.CarService;
import com.zeran.ticket.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
@CrossOrigin
public class RoomController {
    private final RoomService roomService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<RoomDto> getAllRooms() {
        List<RoomDto> rooms = roomService.getAllRooms();
        return rooms;
    }
}
