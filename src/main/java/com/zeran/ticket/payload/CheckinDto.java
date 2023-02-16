package com.zeran.ticket.payload;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Code;
import com.zeran.ticket.entity.People;
import lombok.Data;

@Data
public class CheckinDto {
    private Long id;
    private Code code;
    private People people;
    private Car car;
}
