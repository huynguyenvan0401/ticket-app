package com.zeran.ticket.controller;

import com.zeran.ticket.payload.TicketDto;
import com.zeran.ticket.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return new ResponseEntity<>(ticketService.createTicket(ticketDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<TicketDto> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@RequestBody TicketDto ticketDto, @PathVariable(name = "id") long id) {
        TicketDto ticketRes = ticketService.updateTicket(ticketDto, id);

        return new ResponseEntity<>(ticketRes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable(name = "id") long id) {
        ticketService.deleteTicketById(id);

        return new ResponseEntity<>("Ticket entity deleted successfully.", HttpStatus.OK);
    }
}
