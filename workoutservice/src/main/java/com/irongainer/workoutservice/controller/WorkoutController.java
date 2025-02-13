package com.irongainer.workoutservice.controller;

import com.irongainer.workoutservice.dto.WorkoutRequestDto;
import com.irongainer.workoutservice.entity.Workout;
import com.irongainer.workoutservice.mapper.WorkoutMapper;
import com.irongainer.workoutservice.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;
    private final WorkoutMapper workoutMapper;

    @PostMapping("/add")
    public ResponseEntity<Workout> addWorkout(WorkoutRequestDto workoutRequestDto) {
        return ResponseEntity.ok(workoutService
                .addWorkout(workoutMapper
                        .toEntity(workoutRequestDto)));
    }
}
