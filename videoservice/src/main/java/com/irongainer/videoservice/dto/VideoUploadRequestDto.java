package com.irongainer.videoservice.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class VideoUploadRequestDto {

    private MultipartFile multipartFile;
    private String muscleGroup;
}
