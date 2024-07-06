package com.perucci.bank.repositories;

import com.perucci.bank.domain.user.User;
import com.perucci.bank.presenters.UserPresenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByCpf(String cpf);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
}
