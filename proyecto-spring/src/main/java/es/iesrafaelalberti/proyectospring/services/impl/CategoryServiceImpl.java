package es.iesrafaelalberti.proyectospring.services.impl;

import es.iesrafaelalberti.proyectospring.dto.CategoryCreateDTO;
import es.iesrafaelalberti.proyectospring.dto.CategoryDTO;
import es.iesrafaelalberti.proyectospring.dto.CourseDTO;
import es.iesrafaelalberti.proyectospring.models.Category;
import es.iesrafaelalberti.proyectospring.models.Course;
import es.iesrafaelalberti.proyectospring.repositories.CategoryRepository;
import es.iesrafaelalberti.proyectospring.repositories.ChapterRepository;
import es.iesrafaelalberti.proyectospring.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<CategoryDTO> findAll(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> dtos = categories
                .stream()
                .map(category -> mapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
}
