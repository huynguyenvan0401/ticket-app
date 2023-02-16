package com.zeran.ticket.repository;

import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {
    List<People> findAllByCarId(Long carId);
}
