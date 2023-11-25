package junctionx.Brandcommend.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(nullable = false)
    public String category_name;

    public CategoryEntity() {}

    public CategoryEntity(String category_name) {
        this.category_name = category_name;
    }
}