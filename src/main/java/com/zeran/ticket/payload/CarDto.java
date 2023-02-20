package com.zeran.ticket.payload;

import com.zeran.ticket.entity.Car;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CarDto {
    private Long id;

    private String licensePlate;

    private Long capacity;
}
