package com.zeran.ticket.service;

import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.payload.PeopleCheckinDto;
import com.zeran.ticket.payload.PeopleDto;
import com.zeran.ticket.request.PeopleRequest;
import com.zeran.ticket.response.PeopleCheckinResponse;

import java.util.List;

public interface PeopleService {
    List<PeopleCheckinDto> getAllPeopleCheckins();
    List<PeopleCheckinDto> getPeopleCheckinDrive();
    void updateNoteByDriver(PeopleRequest peopleRequest);
    void updatePeopleDrive(PeopleRequest peopleRequest);
    List<PeopleDto> getPeopleAccounts();
    List<PeopleDto> getPeopleAccountByDriver();
    void updatePeopleCar(PeopleRequest peopleRequest);
}
