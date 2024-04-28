package org.example.hvala.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sub_categories")
public class SubCategory extends BaseEntity {
    private List<Advertisement> advertisements;
    private Category category;
    private String name;

    protected SubCategory() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subCategory", cascade = CascadeType.REMOVE)
    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
