package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.CategoryCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CategoryDTO;
import es.iesrafaelalberti.proyectospring.models.Category;
import es.iesrafaelalberti.proyectospring.repositories.CategoryRepository;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    private ModelMapper mapper = new ModelMapper();

    public CategoryDTO create (CategoryCreateDTO newCategory){
        Optional<Category> oCategory = categoryRepository.findByName(newCategory.getName());
        if(oCategory.isPresent()){
            throw new IllegalStateException("Category's name is used");
        }
        Category category = categoryRepository.save(new Category(newCategory.getName()));
        return this.mapper.map(category, CategoryDTO.class);
    }
}
