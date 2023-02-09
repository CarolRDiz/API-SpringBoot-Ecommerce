package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.Prisoner;
import org.springframework.data.repository.CrudRepository;

public interface PrisonerRepository extends CrudRepository<Prisoner, Long> {}