package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.AddToCartDTO;
import es.iesrafaelalberti.proyectospring.exceptions.CourseNotExistsException;
import es.iesrafaelalberti.proyectospring.models.Cart;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.repositories.CartRepository;
import es.iesrafaelalberti.proyectospring.repositories.CourseRepository;
import es.iesrafaelalberti.proyectospring.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public void addToCart (AddToCartDTO addToCartDTO) throws CourseNotExistsException{
        Optional<Course> course = courseRepository.findById(addToCartDTO.getCourse_id());
        if(course.isPresent()){
            Cart cart = new Cart();
            cart.setCourse(course.get());
            //cart.setUser();
            cartRepository.save(cart);
        }
        else {
            throw new CourseNotExistsException("Course id is invalid: "+addToCartDTO.getCourse_id());
        }
    };
}
