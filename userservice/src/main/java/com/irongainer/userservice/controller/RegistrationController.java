package com.irongainer.userservice.controller;

import com.irongainer.userservice.dto.RegistrationRequestDto;
import com.irongainer.userservice.dto.RegistrationResponseDto;
import com.irongainer.userservice.mapper.UserRegistrationMapper;
import com.irongainer.userservice.service.UserRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;
    private final UserRegistrationMapper userRegistrationMapper;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponseDto> registerUser(@Valid @RequestBody final RegistrationRequestDto registrationDto) {
        final var registerUser = userRegistrationService.registerUser(userRegistrationMapper.toEntity(registrationDto));

        return ResponseEntity.ok(userRegistrationMapper.toRegistationResponseDto(registerUser));
    }
}
