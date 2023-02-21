package com.zeran.ticket.payload;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Room;
import lombok.Data;

@Data
public class PeopleDto {
    private Long id;
    private String account;
    private Car car;
    private String phoneNumber;
    private String note;
    private Room room;
    private Boolean isRoomMaster;
}
