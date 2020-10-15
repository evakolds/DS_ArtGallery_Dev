package distributedsystems.gallery.services.exhibition_service;

import distributedsystems.gallery.services.exhibition_service.models.Exhibition;
import distributedsystems.gallery.services.exhibition_service.models.Organiser;
import javassist.NotFoundException;

import java.util.List;

public interface IExhibitionService {
    List<Exhibition> findAll();

    Exhibition save(Exhibition exhibitionForSave);

    Exhibition getById(String id) throws NotFoundException;

    void deleteById(String id) throws NotFoundException;
}