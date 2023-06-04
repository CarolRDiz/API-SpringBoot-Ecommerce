package es.iesrafaelalberti.proyectospring.events;

import es.iesrafaelalberti.proyectospring.models.Lesson;
import es.iesrafaelalberti.proyectospring.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class LessonModelListener extends AbstractMongoEventListener<Lesson> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public LessonModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Lesson> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Lesson.SEQUENCE_NAME));
        }
    }

}