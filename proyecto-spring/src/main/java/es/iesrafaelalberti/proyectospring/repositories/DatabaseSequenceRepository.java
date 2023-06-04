package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatabaseSequenceRepository  extends MongoRepository<DatabaseSequence, Long> {
}
