package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterRepository chapterRepository;

    private ModelMapper mapper = new ModelMapper();
    @Override
    public ChapterDTO create(ChapterCreateDTO chapterCreateDTO){
        Chapter chapter = new Chapter(chapterCreateDTO);
        Chapter chapterSaved = chapterRepository.save(chapter);
        return new ChapterDTO(chapterSaved);
    }
    @Override
    public List<ChapterDTO> findAll() {
        List<Chapter> chapters = chapterRepository.findAll();
        List<ChapterDTO> dtos = chapters
                .stream()
                .map(chapter -> mapper.map(chapter, ChapterDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public void delete(Long id){
        Optional<Chapter> chapter = chapterRepository.findById(id);
        if(chapter.isPresent()) chapterRepository.delete(chapter.get());
        else{
            throw new NotFoundException("Chapter not found");
        }
    }
}
