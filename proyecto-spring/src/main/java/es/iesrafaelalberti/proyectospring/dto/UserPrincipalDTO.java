package es.iesrafaelalberti.proyectospring.dto;
import es.iesrafaelalberti.proyectospring.models.Cart;
import es.iesrafaelalberti.proyectospring.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Set;


@Setter
@AllArgsConstructor
@NoArgsConstructor @Getter
public class UserPrincipalDTO implements Serializable {
    private String username;
    private String name;
    private String surname;
    private String email;
    private Set<Cart> carts;
    private boolean admin;

}