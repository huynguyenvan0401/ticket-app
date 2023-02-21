package com.zeran.ticket.controller;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.payload.CarDto;
import com.zeran.ticket.payload.TicketDto;
import com.zeran.ticket.response.CheckinResponse;
import com.zeran.ticket.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
@CrossOrigin
public class CarController {
    private final CarService carService;

    @GetMapping()
    public List<CarDto> getAllCheckins() {
        List<CarDto> cars = carService.getAllCars();
        return cars;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }
}
