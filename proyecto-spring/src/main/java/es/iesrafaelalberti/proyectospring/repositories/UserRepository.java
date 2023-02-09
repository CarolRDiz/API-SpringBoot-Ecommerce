package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface UserRepository extends CrudRepository<User, Long> {

}