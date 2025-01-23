package com.melvin.banking.seeder;

import com.melvin.banking.common.enums.AccountType;
import com.melvin.banking.model.Account;
import com.melvin.banking.model.User;
import com.melvin.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Transactional
public class AccountSeeder implements ApplicationRunner {

    private final AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedAccounts();
    }

    private final void seedAccounts() {
        if (accountRepository.count() == 0) {
            User user1 = new User();
            Account account1 =  new Account();
            Account account4 =  new Account();
            Account account5 =  new Account();
            account1.setAccountNumber("1001871322");
            account1.setBalance(BigDecimal.valueOf(111111110));
            account1.setType(AccountType.SAVINGS);
            account1.setUser(user1);
            account4.setAccountNumber("1001871711");
            account4.setBalance(BigDecimal.valueOf(111111110));
            account4.setType(AccountType.CURRENT);
            account4.setUser(user1);
            account5.setAccountNumber("1221973711");
            account5.setBalance(BigDecimal.valueOf(111111110));
            account5.setType(AccountType.SAVINGS);
            account5.setUser(user1);
            user1.setEmail("tester1@gmail.com");
            user1.setUsername("tester1");
            user1.setPhoneNumber("0187771313");

            User user2 = new User();
            Account account2 = new Account();
            account2.setAccountNumber("1001871323");
            account2.setBalance(BigDecimal.valueOf(111111110));
            account2.setType(AccountType.CREDIT);
            account2.setUser(user2);
            user2.setEmail("tester2@gmail.com");
            user2.setUsername("tester2");
            user2.setPhoneNumber("0187771313");

            User user3 = new User();
            Account account3 = new Account();
            account3.setAccountNumber("1001871345");
            account3.setBalance(BigDecimal.valueOf(111111110));
            account3.setType(AccountType.CURRENT);
            account3.setUser(user3);
            user3.setEmail("tester3@gmail.com");
            user3.setUsername("tester3");
            user3.setPhoneNumber("0187771313");
            accountRepository.saveAll(Arrays.asList(account1, account2, account3, account4, account5));
        }
    }
}
