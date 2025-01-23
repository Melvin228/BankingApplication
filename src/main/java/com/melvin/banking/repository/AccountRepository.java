package com.melvin.banking.repository;

import com.melvin.banking.model.Account;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @EntityGraph(attributePaths = "user")
    List<Account> findAll();
    @EntityGraph(attributePaths = "user")
    List<Account> findByUserId(Long userId);
}
