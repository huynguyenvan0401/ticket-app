package com.zeran.ticket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckinRequest {
    private String code;
    private Long peopleId;
    private Long carId;
}
