package com.irongainer.workoutservice.dto;

import com.irongainer.workoutservice.entity.Categories;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ExerciseAddRequestDto {
    //Exercise part
    private String name;
    private int numberOfSets;
    private int numberOfRepetition;
    private String description;
    private List<Categories> categories;

    //Video part
    private String muscleGroup;
    private MultipartFile multipartFile;
}
