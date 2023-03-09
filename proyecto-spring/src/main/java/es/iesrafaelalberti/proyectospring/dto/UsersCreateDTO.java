package es.iesrafaelalberti.proyectospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersCreateDTO implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String password;
}