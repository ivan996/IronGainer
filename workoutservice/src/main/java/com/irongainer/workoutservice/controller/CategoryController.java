package com.irongainer.workoutservice.controller;

import com.irongainer.workoutservice.entity.Categories;
import com.irongainer.workoutservice.repository.CategoriesRepository;
import com.irongainer.workoutservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cat")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    //add
    @PostMapping("/add")
    public ResponseEntity<Categories> addCategory(String categoryName){
        return ResponseEntity.ok(categoryService.addCategory(categoryName));
    }

    //addList
    @PostMapping("/addlist")
    public ResponseEntity<List<Categories>> addListOfCategories(List<String> categoriesNames) {
        return ResponseEntity.ok(categoryService.addListOfCategories(categoriesNames));
    }

    //get
    @GetMapping("/{id}")
    public ResponseEntity<Categories> getCategory(@PathVariable UUID id){
        return categoryService.getCategory(id)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound()
                                .build());
    }

    //getall
    @GetMapping("/allcategories")
    public ResponseEntity<List<Categories>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }


}
