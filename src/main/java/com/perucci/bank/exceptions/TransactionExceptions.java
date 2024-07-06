package com.perucci.bank.exceptions;

import com.perucci.bank.domain.user.UserType;

import java.math.BigDecimal;

public class TransactionExceptions extends RuntimeException {
    public TransactionExceptions(String message) {
        super(message);
    }
}
