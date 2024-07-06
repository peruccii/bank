package com.perucci.bank.services;

import com.perucci.bank.domain.transactions.Transaction;
import com.perucci.bank.domain.user.User;
import com.perucci.bank.dtos.TransactionDto;
import com.perucci.bank.repositories.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private ITransactionRepository transactionRepository;

    public Transaction createTransaction(TransactionDto transaction) {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.balance());

        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.balance());
        newTransaction.setReceiver(receiver);
        newTransaction.setSender(sender);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.balance()));
        receiver.setBalance(receiver.getBalance().add(transaction.balance()));

        this.transactionRepository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        return newTransaction;
    }
}
