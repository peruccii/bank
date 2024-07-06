package com.perucci.bank.dtos;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal balance, Long senderId, Long receiverId) {
}
