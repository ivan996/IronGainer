package com.irongainer.workoutservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class VideoUploadRequestDto {
    private MultipartFile multipartFile;
    private String muscleGroup;
}
