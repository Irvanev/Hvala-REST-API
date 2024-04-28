package org.example.hvala.models.entities;

import com.github.slugify.Slugify;
import jakarta.persistence.*;

import java.io.IOException;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisements")
public class Advertisement extends BaseEntity {
    private User user;
    private Characteristic characteristic;
    private SubCategory subCategory;
    private String title;
    private String description;
    private int price;
    private boolean isActive;
    private String slug;
    private LocalDateTime created;
    private LocalDateTime modified;

    protected Advertisement() {}

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne(mappedBy = "advertisement", cascade = CascadeType.REMOVE)
    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IOException {
        this.title = title;
        this.slug = new Slugify().slugify(title);
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name= "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Column(name = "modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Column(name = "created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
