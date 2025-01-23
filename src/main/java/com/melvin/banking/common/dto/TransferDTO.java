package com.melvin.banking.common.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransferDTO {
    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
}
