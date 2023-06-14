package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ChapterService extends Serializable {
    ChapterDTO findById(Long id);
    ChapterDTO createChapter(ChapterCreateDTO chapterCreateDTO) throws IOException;
    //ChapterDTO updateLesson(Long id, ChapterCreateDTO lessonCreateDTO) throws IOException;
    void deleteChapter(Long id);
    List<ChapterDTO> findAll();
    Chapter updateChapterByFields(Long id, Map<String, Object> fields);

    Chapter updateVideo(Long id, MultipartFile file);
}
