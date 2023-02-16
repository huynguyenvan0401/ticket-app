package com.zeran.ticket.response;

import com.zeran.ticket.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PeopleResponse {
    private Long id;
    private String account;
    private Car car;
    private String phoneNumber;
    private String note;
}
