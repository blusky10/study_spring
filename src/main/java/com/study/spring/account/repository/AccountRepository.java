package com.study.spring.account.repository;

import com.study.spring.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SDS on 2017-06-21.
 */
public interface AccountRepository extends JpaRepository<Account, String> {
}
