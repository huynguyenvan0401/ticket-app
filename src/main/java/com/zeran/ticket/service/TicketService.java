package com.zeran.ticket.service;

import com.zeran.ticket.payload.TicketDto;

import java.util.List;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);

    List<TicketDto> getAllTickets();

    TicketDto getTicketById(long id);

    TicketDto updateTicket(TicketDto ticketDto, long id);

    void deleteTicketById(long id);
}
