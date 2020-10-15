package distributedsystems.gallery.services.ticket_service.repository;

import distributedsystems.gallery.services.ticket_service.models.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {
}
