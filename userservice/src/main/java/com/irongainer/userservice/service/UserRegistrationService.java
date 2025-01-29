package com.irongainer.userservice.service;

import com.irongainer.userservice.entity.User;
import com.irongainer.userservice.exception.ValidationException;
import com.irongainer.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(User user) {
        final var errors = new HashMap<String, String>();

        if (userRepository.existsByEmail(user.getEmail())){
            errors.put("email", "Email [%s] is already taken".formatted(user.getEmail()));
        }
        if (userRepository.existsByUsername(user.getUsername())){
            errors.put("username", "Username [%s] is already taken".formatted(user.getUsername()));
        }
        if (!errors.isEmpty()){
            throw new ValidationException(CONFLICT, errors);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
