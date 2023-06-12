package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.LoginRequestDTO;
import es.iesrafaelalberti.proyectospring.dto.UserPrincipalDTO;
import es.iesrafaelalberti.proyectospring.security.MyUserPrincipal;
import es.iesrafaelalberti.proyectospring.services.TokenService;
import es.iesrafaelalberti.proyectospring.services.UsersService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private final UsersService usersService;;
    private ModelMapper mapper = new ModelMapper();
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager, UsersService usersService) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.usersService = usersService;
    }
    @PostMapping("/token")
    public ResponseEntity<Object> token(@RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        ));
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        MyUserPrincipal user = (MyUserPrincipal) authentication.getPrincipal();
        UserPrincipalDTO userDTO = this.mapper.map(user, UserPrincipalDTO.class);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.AUTHORIZATION,
                        token
                )
                .body(userDTO);
    }
    /*
    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return token;
    }
     */
}