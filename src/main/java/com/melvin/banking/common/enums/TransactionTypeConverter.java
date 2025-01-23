package com.melvin.banking.common.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {
    @Override
    public String convertToDatabaseColumn(final TransactionType transactionType) {
        return transactionType != null ? transactionType.getValue() : null;
    }

    @Override
    public TransactionType convertToEntityAttribute(final String s) {
        for (final TransactionType type : TransactionType.values()) {
            if (type.getValue().equals(s)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + s);
    }
}
