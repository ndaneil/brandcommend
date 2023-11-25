package junctionx.Brandcommend.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "BRAND")
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    public String brand_name;

    @Column(nullable = false)
    public String logo_path;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    CategoryEntity category;

    public BrandEntity(){};

    public BrandEntity(String brand_name, String logo_path, CategoryEntity category) {
        this.brand_name = brand_name;
        this.logo_path = logo_path;
        this.category = category;
    }
}