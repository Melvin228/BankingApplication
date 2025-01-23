package com.melvin.banking.common.enums;


import com.melvin.banking.type.ValueEnum;

public enum TransactionType implements ValueEnum<String> {
    WITHDRAWAL("wdw", "Withdrawal Transaction"),
    DEPOSIT("dpt", "Deposit Transaction"),
    TRANSFER("trx", "Transfer Transaction"),

    ;

    private final String value;

    private final String label;

    TransactionType(final String value, final String label) {
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
