package es.iesrafaelalberti.proyectospring.services;
import es.iesrafaelalberti.proyectospring.dto.UserPrincipalDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersDTO;
import es.iesrafaelalberti.proyectospring.models.Users;

import java.io.Serializable;

public interface UsersService  extends Serializable {
    Users usersCreate(UsersCreateDTO newUser);
    UsersDTO findById(Long id);
    UserPrincipalDTO getUserPrincipal(Long id);
    void delete(Long id);
}