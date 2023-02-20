package com.zeran.ticket.service;

import com.zeran.ticket.payload.CheckinDto;
import com.zeran.ticket.request.CheckinRequest;

import java.util.List;

public interface CheckinService {
    CheckinDto createCheckin(CheckinRequest checkinRequest);
    List<CheckinDto> getAllCheckins();
    List<CheckinDto> getAllCheckinsForDriver();
    void resetDriveCheckin();
    void resetAllCheckin();
    void deleteByPeopleId(Long id);
}
