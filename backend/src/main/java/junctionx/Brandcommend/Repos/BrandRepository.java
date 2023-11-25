package junctionx.Brandcommend.Repos;

import junctionx.Brandcommend.Entities.BrandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BrandRepository extends CrudRepository<BrandEntity, Integer> {
    BrandEntity findByIdGreaterThan(Integer id);
    List<BrandEntity> findAllByCategory_Id(Integer category_id);


}
