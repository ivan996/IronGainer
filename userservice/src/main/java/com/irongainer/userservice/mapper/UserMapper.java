package com.irongainer.userservice.mapper;

import com.irongainer.userservice.dto.UserProfileDto;
import com.irongainer.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserProfileDto toUserProfileDto(final User user) {
        return new UserProfileDto(user.getEmail(), user.getUsername());
    }
}
