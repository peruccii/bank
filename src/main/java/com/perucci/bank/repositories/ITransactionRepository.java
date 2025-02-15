package com.perucci.bank.repositories;

import com.perucci.bank.domain.transactions.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository  extends JpaRepository<Transaction, Long> {}
