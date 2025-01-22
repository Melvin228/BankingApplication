package com.melvin.banking.common.constants;

public class Constants {
    private Constants() {
    }

    public static class ErrorHeader {
        private ErrorHeader() {
        }

        public static final String INVALID_ACCOUNT_DETAILS_HEADER = "Invalid Account Number!";
    }

    public static class ErrorMessage {
        private ErrorMessage() {
        }

        public static final String USER_ALREADY_EXISTS = "User with this email or username already exists.";
        public static final String ACCOUNT_CREATION_FAILED = "Account creation failed. Please try again later.";
        public static final String INVALID_USER_DETAILS = "Invalid user details.";
        public static final String INVALID_ACCOUNT_DETAILS = "Invalid account details.";
        public static final String INVALID_ACCOUNT_NUMBER = "Account Number has to be between 10 to 16 digits.";
        public static final String GENERIC_ERROR = "An unexpected error occurred. Please try again.";
    }
}
