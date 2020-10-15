package distributedsystems.gallery.services.ticket_service;

import distributedsystems.gallery.services.ticket_service.models.Ticket;
import javassist.NotFoundException;

import java.util.List;

public interface ITicketService {
    List<Ticket> findAll();

    Ticket save(Ticket ticketForSave);

    Ticket getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}