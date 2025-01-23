package com.melvin.banking.common.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransactionStatusConverter implements AttributeConverter<TransactionStatus, String> {
    @Override
    public String convertToDatabaseColumn(final TransactionStatus transactionStatus) {
        return transactionStatus != null ? transactionStatus.getValue() : null;
    }

    @Override
    public TransactionStatus convertToEntityAttribute(final String s) {
        for (final TransactionStatus type : TransactionStatus.values()) {
            if (type.getValue().equals(s)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + s);
    }
}
