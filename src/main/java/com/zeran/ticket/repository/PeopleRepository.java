package com.zeran.ticket.repository;

import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.People;
import com.zeran.ticket.payload.PeopleCheckinDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    List<People> findAllByCarId(Long carId);
}

