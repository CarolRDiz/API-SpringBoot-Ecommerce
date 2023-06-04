package es.iesrafaelalberti.proyectospring.services.impl;
import es.iesrafaelalberti.proyectospring.dto.UsersCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.UsersDTO;
import es.iesrafaelalberti.proyectospring.exceptions.NotFoundException;
import es.iesrafaelalberti.proyectospring.models.Users;
import es.iesrafaelalberti.proyectospring.repositories.UsersRepository;
import es.iesrafaelalberti.proyectospring.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRepository usersRepository;
    private ModelMapper mapper = new ModelMapper();
    @Override
    public Users usersCreate(UsersCreateDTO newUser) {
            Users user = this.mapper.map(newUser, Users.class);
            return usersRepository.save(user);
    }
    @Override
    public UsersDTO findById(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if(user.isPresent()) {
            UsersDTO userDTO = this.mapper.map(user, UsersDTO.class);
            return userDTO;
        } else {
            //throw new NotFoundException("User not found");
            return null;
        }
    }
    @Override
    public void delete(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if(user.isPresent()) usersRepository.delete(user.get());
    }
}