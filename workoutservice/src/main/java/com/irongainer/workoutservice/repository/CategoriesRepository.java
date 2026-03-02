package com.irongainer.workoutservice.repository;

import com.irongainer.workoutservice.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, UUID> {

    Optional<Categories> findByNameOfCategory(String nameOfCategory);

    boolean existsByNameOfCategory(String nameOfCategory);
}
