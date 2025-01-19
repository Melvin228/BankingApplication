package com.melvin.banking.enums;

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
}
