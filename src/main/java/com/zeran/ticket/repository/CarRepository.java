package com.zeran.ticket.repository;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Checkin;
import com.zeran.ticket.entity.Code;
import com.zeran.ticket.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
}
