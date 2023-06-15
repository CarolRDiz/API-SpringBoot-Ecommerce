package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.models.Image;
import es.iesrafaelalberti.proyectospring.repositories.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface ImageService {

    String addImage(String title, MultipartFile file) throws IOException;
    void deleteImage(String id);
    Image getImage(String id);
}
