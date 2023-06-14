package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.ChapterCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.ChapterDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Lesson;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.repositories.LessonRepository;
import es.iesrafaelalberti.proyectospring.services.ChapterService;
import es.iesrafaelalberti.proyectospring.services.VideoService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    VideoService videoService;
    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    private GridFsTemplate gridFsTemplate;
    private ModelMapper mapper = new ModelMapper();
    TypeMap<Chapter, ChapterDTO> propertyMapper = this.mapper.createTypeMap(Chapter.class, ChapterDTO.class);

    @Override
    public ChapterDTO createChapter(ChapterCreateDTO newChapter) throws IOException {
        // ModelMapper : Chapter -> ChapterDTO
        Converter<String, String> completeUrl = c -> "/videos/stream/".concat(c.getSource());
        propertyMapper.addMappings(
                mapper -> mapper.using(completeUrl).map(es.iesrafaelalberti.proyectospring.models.Chapter::getVideo_id, ChapterDTO::setUrl)
        );
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getLesson().getId(), ChapterDTO::setLesson_id)
        );
        String video_id = videoService.addVideo( newChapter.getTitle(), newChapter.getVideo());
        Optional<Lesson> lesson = lessonRepository.findById(newChapter.getLesson_id());
        if (lesson.isPresent()){
            Chapter chapter = new Chapter(video_id, newChapter.getTitle(), newChapter.getDuration(), lesson.get());
            Chapter chapterSaved = chapterRepository.save(chapter);
            ChapterDTO chapterDTO = this.mapper.map(chapterSaved, ChapterDTO.class);
            return chapterDTO;
        }
        else{
            throw new NotFoundException("Chapter not found");
        }

    }

    @Override
    public void deleteChapter(Long id) {
        Optional<Chapter> chapter = chapterRepository.findById(id);
        if (chapter.isPresent()) {
            gridFsTemplate.delete(new Query(Criteria.where("_id").is(chapter.get().getVideo_id())));
            chapterRepository.delete(chapter.get());
        } else {
            throw new NotFoundException("Chapter not found");
        }
    }

    @Override
    public List<ChapterDTO> findAll() {
        //TypeMap<Chapter, ChapterDTO> propertyMapper = this.mapper.createTypeMap(Chapter.class, ChapterDTO.class);
        Converter<String, String> completeUrl = c -> "/videos/stream/".concat(c.getSource());
        propertyMapper.addMappings(
                mapper -> mapper.using(completeUrl).map(es.iesrafaelalberti.proyectospring.models.Chapter::getVideo_id, ChapterDTO::setUrl)
        );
        List<Chapter> chapters = chapterRepository.findAll();

        List<ChapterDTO> dtos = chapters
                .stream()
                .map(lesson -> mapper.map(lesson, ChapterDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public ChapterDTO findById(Long id) {
        Converter<String, String> completeUrl = c -> "/videos/stream/".concat(c.getSource());
        propertyMapper.addMappings(
                mapper -> mapper.using(completeUrl).map(es.iesrafaelalberti.proyectospring.models.Chapter::getVideo_id, ChapterDTO::setUrl)
        );
        Optional<Chapter> oChapter = chapterRepository.findById(id);
        if (oChapter.isPresent()) {
            ChapterDTO chapterDTO = this.mapper.map(oChapter.get(), ChapterDTO.class);
            return chapterDTO;
        } else {
            throw new NotFoundException("Chapter not found");
        }
    }
    /*
    @Override
    public ChapterDTO updateLesson(Long id, ChapterUpdateDTO lessonUpdateDTO) throws IOException{

        deleteLesson(id);
        return createLesson(lessonCreateDTO);
    }*/
    /*
    @Override
    public ChapterDTO updateLesson(ChapterCreateDTO lessonCreateDTO) throws IOException{
        Long newLessonId = lessonCreateDTO.getId();
        deleteLesson(newLessonId);
        return createLesson(lessonCreateDTO);
    }
    */

}
