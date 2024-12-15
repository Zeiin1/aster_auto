package com.example.aster_auto.model.dto;

import com.example.aster_auto.model.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class RegistrationRequestDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

}
