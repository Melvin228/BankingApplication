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

        public static final String INSUFFICIENT_AUTHENTICATION = "User details not found";
        public static final String USER_ALREADY_EXISTS = "User with this email or username already exists.";
        public static final String ACCOUNT_CREATION_FAILED = "Account creation failed. Please try again later.";
        public static final String INVALID_USER_DETAILS = "Invalid user details.";
        public static final String INVALID_ACCOUNT_DETAILS = "Invalid account details.";
        public static final String INVALID_ACCOUNT_NUMBER = "Account Number has to be between 10 to 16 digits.";
        public static final String GENERIC_ERROR = "An unexpected error occurred. Please try again.";
        public static final String INVALID_AMOUNT = "Amount must be greater than zero.";
        public static final String ACCOUNT_NOT_FOUND = "Account Not Found.";
        public static final String INSUFFICIENT_BALANCE = "Insufficient balance for withdrawal.";
        public static final String FROM_ACCOUNT_NOT_FOUND = "From Account Not Found.";
        public static final String TO_ACCOUNT_NOT_FOUND = "To Account Not Found.";
        public static final String CANNOT_TRANSFER_SAME_ACC = "Cannot transfer to the same account.";
    }

    public static class Remark {
        private Remark() {}

        public static final String PERFORMED_WITHDRAWAL = "Performed Withdrawal with amount of %.2f from account %s";
        public static final String PERFORMED_DEPOSIT = "Performed Deposit with amount of %.2f to account %s";
        public static final String PERFORMED_TRANSFER = "Transferred RM %.2f from account %s to account %s.";
    }
}
