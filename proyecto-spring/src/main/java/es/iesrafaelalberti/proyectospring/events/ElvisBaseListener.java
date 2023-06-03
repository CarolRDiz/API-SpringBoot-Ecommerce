package es.iesrafaelalberti.proyectospring.events;

import es.iesrafaelalberti.proyectospring.models.ElvisEntity;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class ElvisBaseListener<T extends ElvisEntity> extends AbstractMongoEventListener<T> {
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    public ElvisBaseListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<T> event) {
/*
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(T.SEQUENCE_NAME));
        }

 */
    }
}
