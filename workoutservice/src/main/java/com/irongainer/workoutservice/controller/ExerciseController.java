package com.irongainer.workoutservice.controller;

import com.irongainer.workoutservice.dto.ExerciseAddRequestDto;
import com.irongainer.workoutservice.dto.ExerciseAddResponseDto;
import com.irongainer.workoutservice.dto.VideoUploadRequestDto;
import com.irongainer.workoutservice.entity.Exercise;
import com.irongainer.workoutservice.entity.Video;
import com.irongainer.workoutservice.mapper.ExerciseMapper;
import com.irongainer.workoutservice.service.ExerciseService;
import com.irongainer.workoutservice.service.VideoServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ExerciseMapper exerciseMapper;
    private final VideoServiceClient videoServiceClient;

    @PostMapping("/add")
    public ResponseEntity<ExerciseAddResponseDto> addExercise(ExerciseAddRequestDto exerciseAddRequestDto) {

        Video video = videoServiceClient.uploadVideo(VideoUploadRequestDto.builder()
                .multipartFile(exerciseAddRequestDto.getMultipartFile())
                .muscleGroup(exerciseAddRequestDto.getMuscleGroup())
                .build());

        Exercise exercise = exerciseService.addExercise(exerciseMapper.toEntity(exerciseAddRequestDto,video));

        return ResponseEntity.ok(exerciseMapper.toAddResponseDto(exercise));
    }


}
