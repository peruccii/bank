package com.perucci.bank.domain.user;

import com.perucci.bank.dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fistName;

    private String lastName;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance = BigDecimal.ZERO;;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDto user){
        this.fistName = user.firstName();
        this.lastName = user.lastName();
        this.email = user.email();
        this.password = user.password();
        this.balance = user.balance();
        this.userType = user.userType();
        this.cpf = user.cpf();
    }
}
