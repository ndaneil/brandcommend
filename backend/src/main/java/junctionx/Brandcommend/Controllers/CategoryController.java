package junctionx.Brandcommend.Controllers;


import junctionx.Brandcommend.Entities.CategoryEntity;
import junctionx.Brandcommend.Repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("categories/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryEntity> getAllCategories() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    @GetMapping("categories/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryEntity getCategoryById(@PathVariable Integer category_id) {
        if (!categoryRepository.existsById(category_id)) {
            throw new IllegalArgumentException("Category with given ID doesn't exist!");
        }
        return categoryRepository.findById(category_id).get();
    }

    @PostMapping("categories")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCategory(@RequestBody CategoryEntity category) {
        categoryRepository.save(category);
    }

    @DeleteMapping("categories/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategoryById(@PathVariable Integer category_id) {
        if (!categoryRepository.existsById(category_id)) {
            throw new IllegalArgumentException("Category with given ID doesn't exist!");
        }
        categoryRepository.deleteById(category_id);
    }
}
