package com.irongainer.videoservice.controller;

import com.irongainer.videoservice.dto.VideoUploadRequestDto;
import com.irongainer.videoservice.dto.VideoUploadResponseDto;
import com.irongainer.videoservice.service.VideoUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("api/video")
@RequiredArgsConstructor
public class VideoUploadController {

    private final VideoUploadService videoUploadService;

    @PostMapping("/upload")
    public ResponseEntity<VideoUploadResponseDto> uploadFile (VideoUploadRequestDto videoUploadRequestDto) {

        return new ResponseEntity<>(videoUploadService.uploadFile(videoUploadRequestDto), HttpStatus.OK);
    }
}
