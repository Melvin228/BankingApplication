package com.melvin.banking.model;

import com.melvin.banking.common.enums.AccountType;
import com.melvin.banking.common.enums.AccountTypeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
@ToString
public class Account extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 15, scale = 2)
    private BigDecimal balance;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Convert(converter = AccountTypeConverter.class)
    private AccountType type;
}
