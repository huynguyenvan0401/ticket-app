package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Room;
import com.zeran.ticket.payload.RoomDto;
import com.zeran.ticket.repository.RoomRepository;
import com.zeran.ticket.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapper mapper;

    @Override
    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream().map(room -> mapper.map(room, RoomDto.class)).collect(Collectors.toList());
    }
}
