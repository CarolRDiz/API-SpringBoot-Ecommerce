package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.CategoryCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO create (CategoryCreateDTO newCategory);
    List<CategoryDTO> findAll();
}
