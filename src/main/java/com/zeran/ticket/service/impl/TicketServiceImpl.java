package com.zeran.ticket.service.impl;

import com.zeran.ticket.entity.Ticket;
import com.zeran.ticket.exception.ResourceNotFoundException;
import com.zeran.ticket.payload.TicketDto;
import com.zeran.ticket.repository.TicketRepository;
import com.zeran.ticket.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    private ModelMapper mapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }

    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = mapToEntity(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);

        TicketDto ticketRes = mapToDTO(savedTicket);

        return ticketRes;
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(ticket -> mapToDTO(ticket)).collect(Collectors.toList());
    }

    @Override
    public TicketDto getTicketById(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", String.valueOf(id)));
        return mapToDTO(ticket);
    }

    @Override
    public TicketDto updateTicket(TicketDto ticketDto, long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", String.valueOf(id)));
        ticket.setTicketNum(ticketDto.getTicketNum());

        Ticket updatedTicket = ticketRepository.save(ticket);

        return mapToDTO(updatedTicket);
    }

    @Override
    public void deleteTicketById(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket", "id", String.valueOf(id)));
        ticketRepository.delete(ticket);
    }

    // Convert Entity to DTO
    private TicketDto mapToDTO(Ticket ticket) {
        TicketDto ticketDto = mapper.map(ticket, TicketDto.class);
        return ticketDto;
    }

    // Convert DTO to Entity
    private Ticket mapToEntity(TicketDto ticketDto) {
        Ticket ticket = mapper.map(ticketDto, Ticket.class);
        return ticket;
    }
}
