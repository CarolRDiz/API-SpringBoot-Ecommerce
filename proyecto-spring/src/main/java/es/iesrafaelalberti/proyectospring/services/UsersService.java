package es.iesrafaelalberti.proyectospring.services;
import es.iesrafaelalberti.proyectospring.dto.UserPrincipalDTO;
import es.iesrafaelalberti.proyectospring.dto.RegistrationDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersDTO;
import es.iesrafaelalberti.proyectospring.models.Users;

import java.io.Serializable;

public interface UsersService  extends Serializable {
    UsersDTO findById(Long id);
    UserPrincipalDTO getPrincipal(String username);
    void delete(Long id);
    String signUpUser (Users newUser);
}