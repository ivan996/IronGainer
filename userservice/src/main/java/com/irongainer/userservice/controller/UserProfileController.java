package com.irongainer.userservice.controller;

import com.irongainer.userservice.dto.UserProfileDto;
import com.irongainer.userservice.mapper.UserMapper;
import com.irongainer.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(final Authentication authentication) {
        final var user = userService.getUserbyUsername(authentication.getName());

        return ResponseEntity.ok(userMapper.toUserProfileDto(user));
    }
}
