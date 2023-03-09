package es.iesrafaelalberti.proyectospring.services;
import es.iesrafaelalberti.proyectospring.dto.CoursePurchaseCreateDTO;
import es.iesrafaelalberti.proyectospring.models.CoursePurchase;
import es.iesrafaelalberti.proyectospring.repositories.CoursePurchaseRepository;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CoursePurchaseService {
    @Autowired
    CoursePurchaseRepository coursePurchaseRepository;
    public CoursePurchase coursePurchaseCreate(CoursePurchaseCreateDTO newCoursePurchase) {
        return coursePurchaseRepository.save(new CoursePurchase(newCoursePurchase));
    }
}