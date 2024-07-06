package com.perucci.bank.services;


import com.perucci.bank.domain.user.User;
import com.perucci.bank.domain.user.UserType;
import com.perucci.bank.dtos.UserDto;
import com.perucci.bank.exceptions.TransactionExceptions;
import com.perucci.bank.exceptions.UserExceptions;
import com.perucci.bank.presenters.UserPresenter;
import com.perucci.bank.repositories.IUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) {
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new TransactionExceptions("User type MERCHANT doest have authorization to transfer");
        }

        if(sender.getBalance().compareTo(amount) < 0) {
            throw new TransactionExceptions("Insufficient funds");
        }
    }

//    public void validateUserAlreadyExists(String email, String cpf) {
//        Optional<User> userEmail = this.userRepository.findUserByEmail(email);
//        Optional<User> userCpf = this.userRepository.findUserByCpf(cpf);
//        if ((userEmail.isPresent() && Objects.equals(userEmail.get().getEmail(), email)) || userCpf.isPresent()  && Objects.equals(userCpf.get().getEmail(), cpf)) {
//            throw new UserExceptions("User already exists");
//        }
//    }

    public User findUserById(Long id) {
        return this.userRepository.findUserById(id).orElseThrow(() -> new UserExceptions("User not found"));
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public UserPresenter createUser(UserDto user) {
//        this.validateUserAlreadyExists(user.email(), user.cpf());
        User newUser = new User(user);
        this.saveUser(newUser);

        return new UserPresenter(newUser);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
