package com.melvin.banking.common.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionDTO {
    private Long accountId;
    private BigDecimal amount;
}
