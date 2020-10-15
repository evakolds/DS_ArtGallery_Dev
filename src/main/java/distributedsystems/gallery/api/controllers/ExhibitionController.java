package distributedsystems.gallery.api.controllers;


import distributedsystems.gallery.api.payloads.ExhibitionPayload;
import distributedsystems.gallery.services.exhibition_service.models.Exhibition;
import distributedsystems.gallery.services.exhibition_service.models.Organiser;
import distributedsystems.gallery.services.exhibition_service.IExhibitionService;
import distributedsystems.gallery.GalleryApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exhibitions")
@RequiredArgsConstructor
public final class ExhibitionController {
    static final Logger log = LoggerFactory.getLogger(GalleryApplication.class);

    @Autowired
    private IExhibitionService exhibitionService;

    @GetMapping
    public ResponseEntity<List<Exhibition>> index() {
        return ResponseEntity.ok(exhibitionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Exhibition> create(@RequestBody ExhibitionPayload payload) {

        Exhibition newExhibition = new Exhibition(payload.getName(),
                payload.getOpen());
        return ResponseEntity.ok(exhibitionService.save(newExhibition));
    }


    @GetMapping("{exhibitionId}")
    public ResponseEntity<Exhibition> show(@PathVariable String exhibitionId) throws NotFoundException {
        return ResponseEntity.ok(exhibitionService.getById(exhibitionId));
    }

    @DeleteMapping("{exhibitionId}")
    public ResponseEntity<Void> delete(@PathVariable String clientId) throws NotFoundException {
        exhibitionService.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}