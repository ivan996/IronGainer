package com.irongainer.workoutservice.service;

import com.irongainer.workoutservice.config.VideoConfiguration;
import com.irongainer.workoutservice.dto.VideoUploadRequestDto;
import com.irongainer.workoutservice.entity.Video;
import com.irongainer.workoutservice.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VideoServiceClient {
    
    @Autowired
    private WebClient webClient;
    
    private final VideoConfiguration videoConfiguration;
    private final VideoRepository videoRepository;
    
    public Video uploadVideo(VideoUploadRequestDto videoUploadRequestDto){

        String link = webClient.post()
                .uri(videoConfiguration.getEndpoint())
                .bodyValue(videoUploadRequestDto)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        Video video = new Video();
        video.setMuscleGroup(videoUploadRequestDto.getMuscleGroup());
        video.setLink(link);
        video.setName(videoUploadRequestDto.getMultipartFile().getName());


        return videoRepository.save(video);
    }

}
