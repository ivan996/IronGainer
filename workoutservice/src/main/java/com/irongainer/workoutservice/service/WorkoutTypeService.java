package com.irongainer.workoutservice.service;

import com.irongainer.workoutservice.dto.WorkoutTypeRequestDto;
import com.irongainer.workoutservice.entity.Categories;
import com.irongainer.workoutservice.entity.WorkoutType;
import com.irongainer.workoutservice.repository.WorkoutTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkoutTypeService {

    private final WorkoutTypeRepository workoutTypeRepository;

    public WorkoutType addWorkoutType(WorkoutTypeRequestDto workoutTypeRequestDto){
        return workoutTypeRepository.save(createAndReturnWorkoutTypeFromName(workoutTypeRequestDto));
    }

    public List<WorkoutType> addListOfWorkoutTypes(List<WorkoutTypeRequestDto> workoutTypeRequestDtos) {
        return workoutTypeRepository.saveAll(
                workoutTypeRequestDtos.stream()
                        .map(this::createAndReturnWorkoutTypeFromName)
                        .collect(Collectors.toList()));
    }

    public Optional<WorkoutType> getWorkoutType(UUID id) {
        return workoutTypeRepository.findById(id);

    }

    public List<WorkoutType> getAllWorkoutTypes(){
        return workoutTypeRepository.findAll();
    }


    private WorkoutType createAndReturnWorkoutTypeFromName(WorkoutTypeRequestDto workoutTypeRequestDto) {
        WorkoutType workoutType = new WorkoutType();
        workoutType.setName(workoutTypeRequestDto.getWorkoutTypeName());
        workoutType.setDescription(workoutTypeRequestDto.getWorkoutTypeDescription());
        return workoutType;
    }
}
