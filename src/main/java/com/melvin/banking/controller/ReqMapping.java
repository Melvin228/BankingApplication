package com.melvin.banking.controller;

final class ReqMapping {

    private ReqMapping() {}

    enum Accounts {
        ;
        static final String BASE_URI = "/accounts";

        static final String DEPOSIT_BY_ACCOUNTID= "/deposit/{accountId}";

        static final String WITHDRAW_BY_ACCOUNTID = "/withdraw/{accountId}";

        static final String CREATE_ACCOUNT = "/";
    }

    enum View {
        ;
        static final String LANDING = "/";

        static final String BALANCE_INQUIRY = "/accounts";

        static final String TRANSACTION_LISTING = "/transactions";

        static final String DEPOSIT = "/deposit";

        static final String WITHDRAWAL = "/withdrawal";

        static final String TRANSFER = "/transfer";

        static final String ACCOUNT_CREATION = "/accounts/create";

        static final String SUCCESS = "/success";

        static final String FAIL = "/fail";
    }

    enum HealthCheck {
        ;
        static final String BASE_URI = "/health";
    }
}
