package com.study.spring.accountRole.repository;

import com.study.spring.domain.Account;
import com.study.spring.domain.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {

    List<AccountRole> findAccountRoleByAccount(Account account);

    List<AccountRole> findAccountRoleByAccount_LoingId(String loginId);

    void removeAccountRoleByIdIn(List<Long> ids);
}
