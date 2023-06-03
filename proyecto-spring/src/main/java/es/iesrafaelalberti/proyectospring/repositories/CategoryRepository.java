package es.iesrafaelalberti.proyectospring.repositories;

import es.iesrafaelalberti.proyectospring.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CategoryRepository extends MongoRepository<Category, Long>{
}
