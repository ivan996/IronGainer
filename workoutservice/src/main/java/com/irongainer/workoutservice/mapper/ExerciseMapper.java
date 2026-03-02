package com.irongainer.workoutservice.mapper;

import com.irongainer.workoutservice.dto.ExerciseAddRequestDto;
import com.irongainer.workoutservice.dto.ExerciseAddResponseDto;
import com.irongainer.workoutservice.entity.Exercise;
import com.irongainer.workoutservice.entity.Video;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExerciseMapper {

    public Exercise toEntity(ExerciseAddRequestDto exerciseAddRequestDto, Video video) {
        Exercise exercise = new Exercise();

        exercise.setName(exerciseAddRequestDto.getName());
        exercise.setDescription(exerciseAddRequestDto.getDescription());
        exercise.setCategories(exerciseAddRequestDto.getCategories());
        exercise.setVideo(video);
        exercise.setMuscleGroup(exerciseAddRequestDto.getMuscleGroup());
        exercise.setNumberOfSets(exerciseAddRequestDto.getNumberOfSets());
        exercise.setNumberOfRepetition(exerciseAddRequestDto.getNumberOfRepetition());

        return exercise;
    }

    public ExerciseAddResponseDto toAddResponseDto(Exercise exercise) {
        return null;
    }

}
