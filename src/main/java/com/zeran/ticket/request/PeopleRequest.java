package com.zeran.ticket.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleRequest {
    private Long id;
    @Size(max = 250)
    private String note;
    private Long carId;
    private Long roomId;
    private Boolean isRoomMaster;
}
