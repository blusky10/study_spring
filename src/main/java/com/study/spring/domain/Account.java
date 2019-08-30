package com.study.spring.domain;

import com.study.spring.auditing.AuditableDomain;
import com.study.spring.enums.EnableStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Audited
@AuditOverride(forClass = AbstractAuditable.class)
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

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;


}
