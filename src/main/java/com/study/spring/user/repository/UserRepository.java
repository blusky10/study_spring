package com.study.spring.user.repository;

import com.study.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SDS on 2017-06-10.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
