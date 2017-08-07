package com.study.spring.role.service;

import com.study.spring.domain.Role;

public interface RoleService {
    Role get(Long id);

    void update(Long id);
}
