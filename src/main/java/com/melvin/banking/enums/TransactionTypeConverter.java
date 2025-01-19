package com.melvin.banking.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {
    @Override
    public String convertToDatabaseColumn(final TransactionType transactionType) {
        return transactionType != null ? transactionType.getLabel() : null;
    }

    @Override
    public TransactionType convertToEntityAttribute(final String s) {
        for (final TransactionType type : TransactionType.values()) {
            if (type.getLabel().equals(s)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + s);
    }
}
