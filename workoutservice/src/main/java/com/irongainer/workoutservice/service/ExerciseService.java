package com.irongainer.workoutservice.service;

import com.irongainer.workoutservice.dto.ExerciseAddRequestDto;
import com.irongainer.workoutservice.entity.Exercise;
import com.irongainer.workoutservice.entity.Video;
import com.irongainer.workoutservice.mapper.ExerciseMapper;
import com.irongainer.workoutservice.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public Exercise addExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
    public List<Exercise> getListOfExercises(List<UUID> uuids) {
        return exerciseRepository.findAllById(uuids);
    }

}
