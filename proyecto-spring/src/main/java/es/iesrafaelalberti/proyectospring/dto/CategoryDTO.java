package es.iesrafaelalberti.proyectospring.dto;

import es.iesrafaelalberti.proyectospring.models.Category;
import es.iesrafaelalberti.proyectospring.models.Course;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private Long id;
    private String name;
    public CategoryDTO(Category category) {
        this.id              = category.getId();
        this.name            = category.getName();
    }
}
