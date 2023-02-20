package com.zeran.ticket.repository;

import com.zeran.ticket.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {
    Optional<Checkin> findTopByPeopleAndCar(People people, Car car);
    List<Checkin> findAllByCarId(Long carId);
    void deleteAllByCarId(Long carId);
    void deleteAllByPeopleId(Long peopleId);
    Optional<Checkin> findByPeople(People people);
}
