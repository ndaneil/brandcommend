package junctionx.Brandcommend;

import junctionx.Brandcommend.Entities.CategoryEntity;
import junctionx.Brandcommend.Repos.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryRepoTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void TestFindById() {
        CategoryEntity result = categoryRepository.findById(1).get();
        assertEquals("Telecomm", result.category_name);
    }

    @Test
    public void TestGetAllCategories() {
        List<CategoryEntity> result = (List<CategoryEntity>)categoryRepository.findAll();
        assertEquals(2, result.size());
    }

}
