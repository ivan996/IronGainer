package com.irongainer.workoutservice.controller;

import com.irongainer.workoutservice.dto.WorkoutTypeRequestDto;
import com.irongainer.workoutservice.entity.Categories;
import com.irongainer.workoutservice.entity.WorkoutType;
import com.irongainer.workoutservice.service.WorkoutTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/workouttype")
@RequiredArgsConstructor
public class WorkoutTypeController {

    private final WorkoutTypeService workoutTypeService;

    //add
    @PostMapping("/add")
    public ResponseEntity<WorkoutType> addCategory(WorkoutTypeRequestDto workoutTypeRequestDto){
        return ResponseEntity.ok(workoutTypeService.addWorkoutType(workoutTypeRequestDto));
    }

    //addList
    @PostMapping("/addlist")
    public ResponseEntity<List<WorkoutType>> addListOfCategories(List<WorkoutTypeRequestDto> workoutTypeRequestDtos) {
        return ResponseEntity.ok(workoutTypeService.addListOfWorkoutTypes(workoutTypeRequestDtos));
    }

    //get
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutType> getCategory(@PathVariable UUID id){
        return workoutTypeService.getWorkoutType(id)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound()
                                .build());
    }

    //getall
    @GetMapping("/allworkouttypes")
    public ResponseEntity<List<WorkoutType>> getAllCategories() {
        return ResponseEntity.ok(workoutTypeService.getAllWorkoutTypes());
    }
}
