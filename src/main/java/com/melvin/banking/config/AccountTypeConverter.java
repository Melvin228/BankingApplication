package com.melvin.banking.config;

import com.melvin.banking.enums.AccountType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeConverter implements Converter<String, AccountType> {
    @Override
    public AccountType convert(final String source) {
        return AccountType.fromValue(source);
    }
}