package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;

public interface ChapterService {
    ChapterDTO create(ChapterCreateDTO chapterCreateDTO) ;
}
