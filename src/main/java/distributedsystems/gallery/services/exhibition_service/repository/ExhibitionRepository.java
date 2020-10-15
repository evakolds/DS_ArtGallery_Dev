package distributedsystems.gallery.services.exhibition_service.repository;

import distributedsystems.gallery.services.exhibition_service.models.Exhibition;
import distributedsystems.gallery.services.exhibition_service.models.Organiser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository extends CrudRepository<Exhibition, String> {
}
