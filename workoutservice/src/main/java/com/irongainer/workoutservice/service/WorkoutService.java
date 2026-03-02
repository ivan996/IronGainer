package com.irongainer.workoutservice.service;

import com.irongainer.workoutservice.entity.Workout;
import com.irongainer.workoutservice.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
}
