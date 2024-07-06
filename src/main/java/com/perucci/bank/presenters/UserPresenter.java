package com.perucci.bank.presenters;

import com.perucci.bank.domain.user.User;
import com.perucci.bank.domain.user.UserType;

import java.math.BigDecimal;

public record UserPresenter(Long id, String firstName, String lastName, BigDecimal balance, String email, UserType userType, String cpf) {
    public UserPresenter(User user) {
        this(user.getId(), user.getFistName(), user.getLastName(), user.getBalance(), user.getEmail(), user.getUserType(), user.getCpf());
    }
}
