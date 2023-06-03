package es.iesrafaelalberti.proyectospring.controllers;

import es.iesrafaelalberti.proyectospring.dto.CategoryCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CategoryDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.models.Image;
import es.iesrafaelalberti.proyectospring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/category/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryCreateDTO categoryCreateDTO) {
        return new ResponseEntity<>(
                (categoryService.createCategory(categoryCreateDTO)),
                HttpStatus.OK);
    }
}
