package com.melvin.banking.common.dto;

import com.melvin.banking.common.enums.AccountType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {
    private String accountNumber;
    private String username;
    private String email;
    private String phoneNumber;
    private AccountType accountType;
}