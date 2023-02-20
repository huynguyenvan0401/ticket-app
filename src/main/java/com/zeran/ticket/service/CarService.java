package com.zeran.ticket.service;

import com.zeran.ticket.payload.CarDto;
import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.request.CheckinRequest;

import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();
}
