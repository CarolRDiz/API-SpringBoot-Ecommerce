package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.VideoDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;

public interface VideoService extends Serializable {
    String addVideo(String title, MultipartFile file) throws IOException;
    VideoDTO getVideo(String id) throws IllegalStateException, IOException;
}
