package es.iesrafaelalberti.proyectospring.services;
import es.iesrafaelalberti.proyectospring.dto.ValuationCreateDTO;
import es.iesrafaelalberti.proyectospring.models.UserReview;
import es.iesrafaelalberti.proyectospring.repositories.ValuationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ValuationService {
    @Autowired
    ValuationRepository valuationRepository;
    public UserReview valuationCreate(ValuationCreateDTO newValuation) {
        return valuationRepository.save(new UserReview(newValuation));
    }
}