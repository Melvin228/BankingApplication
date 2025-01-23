package com.melvin.banking.common.enums;

import com.melvin.banking.type.ValueEnum;

public enum TransactionStatus implements ValueEnum {
    SUCCESS("S", "Successful Transaction"),
    REJECT("R", "Rejected Transaction"),

    ;

    private final String value;

    private final String label;

    TransactionStatus(final String value, final String label) {
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
