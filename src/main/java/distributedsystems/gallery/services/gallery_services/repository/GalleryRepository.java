package distributedsystems.gallery.services.gallery_services.repository;

import distributedsystems.gallery.services.gallery_services.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GalleryRepository extends CrudRepository<Employee, String> {
}
