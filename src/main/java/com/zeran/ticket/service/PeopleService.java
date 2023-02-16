package com.zeran.ticket.service;

import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.payload.PeopleDto;
import com.zeran.ticket.request.PeopleRequest;

import java.util.List;

public interface PeopleService {
    List<PeopleDto> getAllPeoples();
    List<PeopleDto> getPeopleDrive();
    void updateNoteByDriver(PeopleRequest peopleRequest);
}
