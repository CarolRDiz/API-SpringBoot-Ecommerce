package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;

import java.util.List;

public interface ChapterService {
    ChapterDTO create(ChapterCreateDTO chapterCreateDTO) ;
    List<ChapterDTO> findAll();
}
