package es.iesrafaelalberti.proyectospring.services;

import es.iesrafaelalberti.proyectospring.dto.CategoryCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CategoryDTO;
import es.iesrafaelalberti.proyectospring.models.Category;
import es.iesrafaelalberti.proyectospring.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    private ModelMapper mapper = new ModelMapper();

    public CategoryDTO createCategory (CategoryCreateDTO categoryCreateDTO){
        Category category = this.mapper.map(categoryCreateDTO, Category.class);
        Category categorySaved = categoryRepository.insert(category);
        CategoryDTO categoryDTO = this.mapper.map(categorySaved, CategoryDTO.class);
        return categoryDTO;
    }
}
