package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.AddToCartDTO;

public interface CartService {
    void addToCart (AddToCartDTO addToCartDTO);
}
