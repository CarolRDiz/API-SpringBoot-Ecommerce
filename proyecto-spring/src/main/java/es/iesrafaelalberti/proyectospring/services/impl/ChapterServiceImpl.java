package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import org.modelmapper.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterRepository chapterRepository;
    @Override
    public ChapterDTO create(ChapterCreateDTO chapterCreateDTO){
        Chapter chapter = new Chapter(chapterCreateDTO);
        Chapter chapterSaved = chapterRepository.save(chapter);
        return new ChapterDTO(chapterSaved);
    }
}
