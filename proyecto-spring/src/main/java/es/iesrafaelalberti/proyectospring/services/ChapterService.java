package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface ChapterService extends Serializable {
    ChapterDTO findById(Long id);
    ChapterDTO createChapter(ChapterCreateDTO chapterCreateDTO) throws IOException;
    //ChapterDTO updateLesson(Long id, ChapterCreateDTO lessonCreateDTO) throws IOException;
    void deleteChapter(Long id);
    List<ChapterDTO> findAll();
}
