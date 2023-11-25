package junctionx.Brandcommend.Controllers;

import junctionx.Brandcommend.Entities.BrandEntity;
import junctionx.Brandcommend.Repos.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/brands")
public class BrandController {

    @Autowired
    BrandRepository brandRepository;

    @GetMapping("brands/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BrandEntity> getAllBrands() {
        return (List<BrandEntity>) brandRepository.findAll();
    }

    @PostMapping("brands")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewBrand(@RequestBody BrandEntity new_brand) {
        brandRepository.save(new_brand);
    }

    @DeleteMapping("brands/{brand_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBrand(@PathVariable Integer brand_id) {
        if (!brandRepository.existsById(brand_id)) {
            throw new IllegalArgumentException("Brand with given ID doesn't exist!");
        }
        brandRepository.deleteById(brand_id);
    }

    @GetMapping("brands/{brand_id}")
    @ResponseStatus(HttpStatus.OK)
    public BrandEntity getBrandById(@PathVariable Integer brand_id) {
        if (!brandRepository.existsById(brand_id)) {
            throw new IllegalArgumentException("Brand with given ID doesn't exist!");
        }
        return brandRepository.findById(brand_id).get();
    }

    @GetMapping("brands/all/{category_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<BrandEntity> getAllByCategoryId(@PathVariable Integer category_id) {
        return brandRepository.findAllByCategory_Id(category_id);
    }


}
