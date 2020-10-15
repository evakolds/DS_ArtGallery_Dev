package distributedsystems.gallery.services.gallery_services;

import distributedsystems.gallery.services.gallery_services.models.Employee;
import javassist.NotFoundException;

import java.util.List;

public interface IGalleryService {
    List<Employee> findAll();

    Employee save(Employee employeeForSave);

    Employee getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}
