package com.irongainer.videoservice.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.irongainer.videoservice.config.AWSConfig;
import com.irongainer.videoservice.dto.VideoUploadRequestDto;
import com.irongainer.videoservice.dto.VideoUploadResponseDto;
import com.irongainer.videoservice.exception.VideoServiceException;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class VideoUploadService {

    private AmazonS3 s3Client;
    @Autowired
    private AWSConfig awsConfig;

    @PostConstruct
    private void initialize() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(awsConfig.getAccessKey(), awsConfig.getSecretKey());
        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(Regions.EU_NORTH_1)
                .build();
    }

    public VideoUploadResponseDto uploadFile(VideoUploadRequestDto videoUploadRequestDto) {

        VideoUploadResponseDto videoUploadResponseDto = new VideoUploadResponseDto();

        try {
            String filePath = videoUploadRequestDto.getMuscleGroup() + "/" + videoUploadRequestDto.getMultipartFile().getName();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(videoUploadRequestDto.getMultipartFile().getContentType());
            objectMetadata.setContentLength(videoUploadRequestDto.getMultipartFile().getSize());
            s3Client.putObject(awsConfig.getBucketName(), filePath, videoUploadRequestDto.getMultipartFile().getInputStream(), objectMetadata);
            videoUploadResponseDto.setFileParh(filePath);
        } catch (IOException e) {
            log.error("Error occurred ==> {}", e.getMessage());
            throw new VideoServiceException("Error occurred in file upload ==> "+e.getMessage());
        }
        return videoUploadResponseDto;
    }
}
