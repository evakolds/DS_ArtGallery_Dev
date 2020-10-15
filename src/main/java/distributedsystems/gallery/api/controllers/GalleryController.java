package distributedsystems.gallery.api.controllers;

import distributedsystems.gallery.api.payloads.GalleryPayload;
import distributedsystems.gallery.api.payloads.TicketPayload;
import distributedsystems.gallery.GalleryApplication;
import distributedsystems.gallery.services.gallery_services.IGalleryService;
import distributedsystems.gallery.services.gallery_services.models.Employee;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gallery")
@RequiredArgsConstructor
public final class GalleryController {
    static final Logger log = LoggerFactory.getLogger(GalleryApplication.class);

    @Autowired
    private IGalleryService galleryService;

    @GetMapping
    public ResponseEntity<List<Employee>> index() {
        return ResponseEntity.ok(galleryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody GalleryPayload payload) {
        Employee newEmployee = new Employee(payload.getName(), payload.getSurname(), (int) payload.getSalary());
        return ResponseEntity.ok(galleryService.save(newEmployee));
    }

    @GetMapping("{galleryId}")
    public ResponseEntity<Employee> show(@PathVariable String galleryId) throws NotFoundException {
        return ResponseEntity.ok(galleryService.getById(galleryId));
    }

    @DeleteMapping("{galleryId}")
    public ResponseEntity<Void> delete(@PathVariable String galleryId) throws NotFoundException {
        galleryService.deleteById(galleryId);
        return ResponseEntity.noContent().build();
    }
}