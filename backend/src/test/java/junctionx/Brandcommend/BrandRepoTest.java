package junctionx.Brandcommend;

import junctionx.Brandcommend.Entities.BrandEntity;
import junctionx.Brandcommend.Entities.CategoryEntity;
import junctionx.Brandcommend.Repos.BrandRepository;
import junctionx.Brandcommend.Repos.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BrandRepoTest {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void TestFindAllBrandsByCategory() {
        List<BrandEntity> result = brandRepository.findAllByCategory_Id(1);
        assertEquals(3, result.size());
    }

    @Test
    public void TestShouldSaveThenReturnThenDelete() {
        List<BrandEntity> result = brandRepository.findAllByCategory_Id(1);
        assertEquals(3, result.size());
        Optional<CategoryEntity> myCategory = categoryRepository.findById(1);
        BrandEntity newBrand = new BrandEntity("TestBrand", "tmpPath5", myCategory.get());
        brandRepository.save(newBrand);
        result = brandRepository.findAllByCategory_Id(1);
        assertEquals(4, result.size());
        brandRepository.delete(brandRepository.findByIdGreaterThan(4));
        result = brandRepository.findAllByCategory_Id(1);
        assertEquals(3, result.size());
    }

}
