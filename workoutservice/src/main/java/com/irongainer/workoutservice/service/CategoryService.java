package com.irongainer.workoutservice.service;

import com.irongainer.workoutservice.entity.Categories;
import com.irongainer.workoutservice.repository.CategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoriesRepository categoriesRepository;

    public Categories addCategory(String categoryName){
        return categoriesRepository.save(createAndReturnCategoryFromName(categoryName));
    }

    public List<Categories> addListOfCategories(List<String> categoriesNames) {
        return categoriesRepository.saveAll(
                categoriesNames.stream()
                        .map(this::createAndReturnCategoryFromName)
                        .collect(Collectors.toList()));
    }

    public Optional<Categories> getCategory(UUID id) {
        return categoriesRepository.findById(id);

    }

    public List<Categories> getAllCategories(){
        return categoriesRepository.findAll();
    }


    private Categories createAndReturnCategoryFromName(String name) {
        Categories cat = new Categories();
        cat.setNameOfCategory(name);
        return cat;
    }
}
