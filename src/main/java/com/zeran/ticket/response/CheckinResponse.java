package com.zeran.ticket.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zeran.ticket.entity.Car;
import com.zeran.ticket.entity.Code;
import com.zeran.ticket.entity.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckinResponse {
    private Long id;

    private Code code;

    private People people;

    private Car car;
}
