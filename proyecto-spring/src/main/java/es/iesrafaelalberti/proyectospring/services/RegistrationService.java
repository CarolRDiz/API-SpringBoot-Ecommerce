package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.RegistrationDTO;

import java.io.Serializable;

public interface RegistrationService extends Serializable {
    String register (RegistrationDTO newUser);
}
