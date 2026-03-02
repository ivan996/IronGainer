package com.irongainer.workoutservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkoutTypeRequestDto {

    private String workoutTypeName;
    private String workoutTypeDescription;
}
