package com.melvin.banking.model;

import com.melvin.banking.enums.TransactionStatus;
import com.melvin.banking.enums.TransactionStatusConverter;
import com.melvin.banking.enums.TransactionType;
import com.melvin.banking.enums.TransactionTypeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
@ToString
public class Transaction extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = TransactionTypeConverter.class)
    private TransactionType type;

    @Convert(converter = TransactionStatusConverter.class)
    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "source_acc_id", referencedColumnName = "id")
    private Account sourceAccount;  // Corrected the type to Account

    @ManyToOne
    @JoinColumn(name = "to_acc_id", referencedColumnName = "id")
    private Account toAccount;  // Corrected the type to Account

    private BigDecimal amount;

    private String remark;
}
