package com.zeran.ticket.controller;

import com.zeran.ticket.payload.CarDto;
import com.zeran.ticket.response.CheckinResponse;
import com.zeran.ticket.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
