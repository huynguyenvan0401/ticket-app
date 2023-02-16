package com.zeran.ticket.repository;

import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.Code;
import com.zeran.ticket.entity.People;
import com.zeran.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {
    Optional<Checkin> findTopByPeopleAndCode(People people, Code code);
    List<Checkin> findAllByCarId(Long carId);
    void deleteAllByCarId(Long carId);
}
