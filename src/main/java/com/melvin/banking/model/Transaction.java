package com.melvin.banking.model;

import com.melvin.banking.common.enums.TransactionStatus;
import com.melvin.banking.common.enums.TransactionStatusConverter;
import com.melvin.banking.common.enums.TransactionType;
import com.melvin.banking.common.enums.TransactionTypeConverter;
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
    @JoinColumn(name = "source_acc_id", referencedColumnName = "id", nullable = true)
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "to_acc_id", referencedColumnName = "id", nullable = true)
    private Account toAccount;

    private BigDecimal amount;

    private String remark;
}
