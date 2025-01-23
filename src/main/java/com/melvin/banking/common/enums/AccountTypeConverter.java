package com.melvin.banking.common.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {
    @Override
    public String convertToDatabaseColumn(final AccountType accountType) {
        return accountType != null ? accountType.getValue() : null;
    }

    @Override
    public AccountType convertToEntityAttribute(final String s) {
        for (final AccountType type : AccountType.values()) {
            if (type.getValue().equals(s)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + s);
    }
}
