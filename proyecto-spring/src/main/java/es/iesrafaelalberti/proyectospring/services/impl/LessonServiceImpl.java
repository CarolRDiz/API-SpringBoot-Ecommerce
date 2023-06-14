package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.LessonCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonDTO;
import es.iesrafaelalberti.proyectospring.dto.LessonUpdateDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Chapter;
import es.iesrafaelalberti.proyectospring.models.Lesson;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.repositories.LessonRepository;
import es.iesrafaelalberti.proyectospring.services.LessonService;
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
public class LessonServiceImpl implements LessonService {
    @Autowired
    VideoService videoService;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    ChapterRepository chapterRepository;
    @Autowired
    private GridFsTemplate gridFsTemplate;
    private ModelMapper mapper = new ModelMapper();
    TypeMap<Lesson, LessonDTO> propertyMapper = this.mapper.createTypeMap(Lesson.class, LessonDTO.class);

    @Override
    public LessonDTO createLesson(LessonCreateDTO newLesson) throws IOException {
        // ModelMapper : Lesson -> LessonDTO
        Converter<String, String> completeUrl = c -> "/videos/stream/".concat(c.getSource());
        propertyMapper.addMappings(
                mapper -> mapper.using(completeUrl).map(Lesson::getVideo_id, LessonDTO::setUrl)
        );
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getChapter().getId(), LessonDTO::setChapter_id)
        );
        String video_id = videoService.addVideo( newLesson.getTitle(), newLesson.getVideo());
        Optional<Chapter> chapter = chapterRepository.findById(newLesson.getChapter_id());
        if (chapter.isPresent()){
            Lesson lesson = new Lesson(video_id, newLesson.getTitle(), newLesson.getDuration(), chapter.get());
            Lesson lessonSaved = lessonRepository.save(lesson);
            LessonDTO lessonDTO = this.mapper.map(lessonSaved, LessonDTO.class);
            return lessonDTO;
        }
        else{
            throw new NotFoundException("Chapter not found");
        }

    }

    @Override
    public void deleteLesson(Long id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if (lesson.isPresent()) {
            gridFsTemplate.delete(new Query(Criteria.where("_id").is(lesson.get().getVideo_id())));
            lessonRepository.delete(lesson.get());
        } else {
            throw new NotFoundException("Lesson not found");
        }
    }

    @Override
    public List<LessonDTO> findAll() {
        //TypeMap<Lesson, LessonDTO> propertyMapper = this.mapper.createTypeMap(Lesson.class, LessonDTO.class);
        Converter<String, String> completeUrl = c -> "/videos/stream/".concat(c.getSource());
        propertyMapper.addMappings(
                mapper -> mapper.using(completeUrl).map(Lesson::getVideo_id, LessonDTO::setUrl)
        );
        List<Lesson> lessons = lessonRepository.findAll();

        List<LessonDTO> dtos = lessons
                .stream()
                .map(lesson -> mapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
    @Override
    public LessonDTO findById(Long id) {
        Converter<String, String> completeUrl = c -> "/videos/stream/".concat(c.getSource());
        propertyMapper.addMappings(
                mapper -> mapper.using(completeUrl).map(Lesson::getVideo_id, LessonDTO::setUrl)
        );
        Optional<Lesson> oLesson = lessonRepository.findById(id);
        if (oLesson.isPresent()) {
            LessonDTO lessonDTO = this.mapper.map(oLesson.get(), LessonDTO.class);
            return lessonDTO;
        } else {
            throw new NotFoundException("Lesson not found");
        }
    }
    /*
    @Override
    public LessonDTO updateLesson(Long id, LessonUpdateDTO lessonUpdateDTO) throws IOException{

        deleteLesson(id);
        return createLesson(lessonCreateDTO);
    }*/
    /*
    @Override
    public LessonDTO updateLesson(LessonCreateDTO lessonCreateDTO) throws IOException{
        Long newLessonId = lessonCreateDTO.getId();
        deleteLesson(newLessonId);
        return createLesson(lessonCreateDTO);
    }
    */

}
