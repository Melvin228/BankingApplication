package com.melvin.banking.controller;

final class ReqMapping {

    private ReqMapping() {
    }

    enum Accounts {
        ;
        static final String BASE_URI = "/accounts";

        static final String BALANCE_INQUIRY = "";

        static final String DEPOSIT = "/deposit";

        static final String WITHDRAWAL = "/withdrawal";

        static final String TRANSFER = "/transfer";

        static final String CREATE_ACCOUNT = "/";
    }

    enum Transaction {
        ;
        static final String BASE_URI = "/transactions";

        static final String TRANSACTION_LISTING = "/{accountId}";
    }

    enum View {
        ;
        static final String LANDING = "/";

        static final String ACCOUNT_CREATION = "/accounts/create";

        static final String SUCCESS = "/success";

        static final String FAIL = "/fail";
    }

    enum HealthCheck {
        ;
        static final String BASE_URI = "/health";
    }
}
