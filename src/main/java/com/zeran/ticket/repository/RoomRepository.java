package com.zeran.ticket.repository;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
