package com.irongainer.userservice.service;

import com.irongainer.userservice.entity.User;
import com.irongainer.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserbyUsername(final String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.GONE,
                        "The user account has been deleted or inactivated"));
    }
}
