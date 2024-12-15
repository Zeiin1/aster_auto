package com.example.aster_auto.service.impl;

import com.example.aster_auto.exception.UserAlreadyExistsException;
import com.example.aster_auto.model.dto.RegistrationRequestDTO;
import com.example.aster_auto.model.entity.User;
import com.example.aster_auto.repository.UserRepository;
import com.example.aster_auto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void save(RegistrationRequestDTO registrationRequest) {
        if (userRepository.findUserByUsername(registrationRequest.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setRole(registrationRequest.getRole());
        user.setEnabled(true);
        userRepository.save(user);
    }
}
