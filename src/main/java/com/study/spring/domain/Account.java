package com.study.spring.domain;

import com.study.spring.auditing.AuditableDomain;
import com.study.spring.enums.EnableStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Account extends AuditableDomain {

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EnableStatus enable;

    @OneToMany
    private List<Role> roles;


}
