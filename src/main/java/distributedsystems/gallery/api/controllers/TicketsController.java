package distributedsystems.gallery.api.controllers;

import distributedsystems.gallery.api.payloads.GalleryPayload;
import distributedsystems.gallery.GalleryApplication;
import distributedsystems.gallery.api.payloads.TicketPayload;
import distributedsystems.gallery.services.ticket_service.ITicketService;
import distributedsystems.gallery.services.ticket_service.models.Ticket;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@RestController
@RequestMapping("api/tickets")
@RequiredArgsConstructor
public final class TicketsController {
    static final Logger log = LoggerFactory.getLogger(GalleryApplication.class);

    @Autowired
    private ITicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> index() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody TicketPayload payload) {
        Ticket newTicket = new Ticket(payload.getPrice());
        return ResponseEntity.ok(ticketService.save(newTicket));
    }

    @GetMapping("{ticketId}")
    public ResponseEntity<Ticket> show(@PathVariable String ticketId) throws NotFoundException {
        return ResponseEntity.ok(ticketService.getById(ticketId));
    }

    @DeleteMapping("{ticketId}")
    public ResponseEntity<Void> delete(@PathVariable String ticketId) throws NotFoundException {
        ticketService.deleteById(ticketId);
        return ResponseEntity.noContent().build();
    }
}