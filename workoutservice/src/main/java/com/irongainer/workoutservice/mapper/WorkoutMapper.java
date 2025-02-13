package com.irongainer.workoutservice.mapper;

import com.irongainer.workoutservice.dto.WorkoutRequestDto;
import com.irongainer.workoutservice.entity.Workout;
import com.irongainer.workoutservice.service.ExerciseService;
import com.irongainer.workoutservice.service.WorkoutTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WorkoutMapper {

    private final WorkoutTypeService workoutTypeService;
    private final ExerciseService exerciseService;

    public Workout toEntity(WorkoutRequestDto workoutRequestDto){
        Workout workout = new Workout();
        workout.setName(workoutRequestDto.getName());
        workout.setDescription(workoutRequestDto.getDescription());
        workout.setWorkoutType(workoutTypeService
                .getWorkoutType(workoutRequestDto
                        .getWorkoutTypeId())
                        .orElse(null));
        workout.setExercises(exerciseService.getListOfExercises(workoutRequestDto.getExerciseIds()));
        return workout;
    }
}
