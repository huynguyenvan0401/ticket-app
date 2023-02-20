package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.payload.CarDto;
import com.zeran.ticket.repository.CarRepository;
import com.zeran.ticket.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper mapper;

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(car -> mapper.map(car, CarDto.class)).collect(Collectors.toList());
    }
}
