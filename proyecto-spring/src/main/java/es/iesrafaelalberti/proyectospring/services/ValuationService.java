package es.iesrafaelalberti.proyectospring.services;
import es.iesrafaelalberti.proyectospring.dto.ValuationCreateDTO;
import es.iesrafaelalberti.proyectospring.models.Valuation;
import es.iesrafaelalberti.proyectospring.repositories.ValuationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ValuationService {
    @Autowired
    ValuationRepository valuationRepository;
    public Valuation valuationCreate(ValuationCreateDTO newValuation) {
        return valuationRepository.save(new Valuation(newValuation));
    }
}