package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Image;
import es.iesrafaelalberti.proyectospring.repositories.ImageRepository;
import es.iesrafaelalberti.proyectospring.services.ImageService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepo;

    @Override
    public String addImage(String title, MultipartFile file) throws IOException {
        Image image = new Image(title);
        image.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        image = imageRepo.insert(image);
        return image.getId();
    }
    @Override
    public void deleteImage(String id){
        Optional<Image> image = imageRepo.findById(id);
        if (image.isPresent()){
            imageRepo.delete(image.get());
        }
    }
    @Override
    public Image getImage(String id) {
        return imageRepo.findById(id).get();
    }
}
