package com.perucci.bank.dtos;

import com.perucci.bank.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;

import java.math.BigDecimal;

public record UserDto(
        @NotBlank
        @NotNull
        @NotEmpty
        String firstName,

        @NotEmpty
        String lastName,

        @Email
        String email,

        UserType userType,

        @NotEmpty
        String password,

        @NotEmpty
        BigDecimal balance,

        @NotNull
        String cpf
) {
}
