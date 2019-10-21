package com.study.spring.account.repository;

import com.study.spring.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByLoginId(String loginId);

    Account findAccountById(Long id);
}
