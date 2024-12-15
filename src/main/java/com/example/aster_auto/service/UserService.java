package com.example.aster_auto.service;

import com.example.aster_auto.model.dto.RegistrationRequestDTO;

public interface UserService {
    void save(RegistrationRequestDTO registrationRequest);
}
