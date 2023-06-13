package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.RegistrationDTO;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.services.UsernameValidator;
import es.iesrafaelalberti.proyectospring.services.RegistrationService;
import es.iesrafaelalberti.proyectospring.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    UsernameValidator usernameValidator;
    @Autowired
    private UsersService usersService;

    private ModelMapper mapper = new ModelMapper();
    @Override
    public String register (RegistrationDTO newUser){
        boolean isValidUsername = usernameValidator.test(newUser.getUsername());
        if(!isValidUsername){
            throw new IllegalStateException("username not valid");
        }
        Users user = this.mapper.map(newUser, Users.class);
        return usersService.signUpUser(
                user
        );
    }
}
