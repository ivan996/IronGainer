package com.irongainer.workoutservice.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class WorkoutRequestDto {

    private String name;
    private String description;
    private UUID workoutTypeId;
    private List<UUID> exerciseIds;
}
