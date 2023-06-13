package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.CategoryCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO create (CategoryCreateDTO newCategory);
}
