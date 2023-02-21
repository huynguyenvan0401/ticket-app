package com.zeran.ticket.payload;

import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PeopleCheckinDto {
    private Long id;
    private String account;
    private Long carId;
    private String licensePlate;
    private String phoneNumber;
    private String note;
    private Long roomId;
    private String roomType;
    private String roomNumber;
    private Boolean isCheckedIn;
    private Boolean isRoomMaster;
}
