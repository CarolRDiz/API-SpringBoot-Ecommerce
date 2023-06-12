package es.iesrafaelalberti.proyectospring.security;

import es.iesrafaelalberti.proyectospring.models.Cart;
import es.iesrafaelalberti.proyectospring.models.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class MyUserPrincipal implements UserDetails {
    private Users user;

    public MyUserPrincipal(Users user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> resultado = new ArrayList<>();
        if(user.isAdmin())
            resultado.add(new SimpleGrantedAuthority("ADMIN"));
        return resultado;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public Long getId() {
        return user.getId();
    }
    public String getName() {
        return user.getName();
    }
    public String getSurname() {
        return user.getSurname();
    }
    public String getEmail() {return user.getEmail();}
    public Set<Cart> getCarts() {return user.getCarts();}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}