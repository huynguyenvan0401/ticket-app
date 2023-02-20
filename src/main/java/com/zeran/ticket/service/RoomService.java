package com.zeran.ticket.service;

import com.zeran.ticket.payload.CarDto;
import com.zeran.ticket.payload.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getAllRooms();
}
