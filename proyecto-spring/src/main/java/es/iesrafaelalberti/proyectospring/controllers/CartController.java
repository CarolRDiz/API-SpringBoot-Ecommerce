package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.AddToCartDTO;
import es.iesrafaelalberti.proyectospring.repositories.CartRepository;
import es.iesrafaelalberti.proyectospring.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    CartService bo;
    CartRepository repository;

    /*
    @PostMapping("/carts/")
    public ResponseEntity<Object> addToCart(@RequestBody AddToCartDTO addToCartDTO,
                                            @RequestParam("token") String token
    ){

    }
*/
}
