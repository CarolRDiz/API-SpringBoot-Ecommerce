package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.RegistrationDTO;
import es.iesrafaelalberti.proyectospring.services.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public String register (RegistrationDTO newUser){
        return "works";
    }
}
