package com.zeran.ticket.payload;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RoomDto {
    private Long id;

    private String type;

    private String number;
}
