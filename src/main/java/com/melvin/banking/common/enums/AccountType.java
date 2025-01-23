package com.melvin.banking.common.enums;

import com.melvin.banking.common.constants.Constants;
import com.melvin.banking.type.ValueEnum;

public enum AccountType implements ValueEnum<String> {
    CURRENT("C", "Current Account"),
    SAVINGS("S", "Saving Account"),
    CREDIT("CR", "Credit Account"),

    ;

    private final String value;

    private final String label;

    AccountType(final String value, final String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    // Static method to convert value to enum
    public static AccountType fromValue(String value) {
        for (AccountType type : values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException(Constants.ErrorMessage.GENERIC_ERROR);
    }
}
