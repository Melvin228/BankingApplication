package com.melvin.banking.type;

public interface ValueEnum<T> {
    /** Returns the value of the Enum */
    T getValue();

    /** Returns the description of the Enum */
    String getLabel();
}
