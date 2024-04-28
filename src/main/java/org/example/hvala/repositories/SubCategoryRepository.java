package org.example.hvala.repositories;

import org.example.hvala.models.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, UUID>{
    Optional<SubCategory> findByName(String name);
}
