package com.study.spring.domain;

import com.study.spring.auditing.AuditableDomain;
import com.study.spring.enums.EnableStatus;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Audited
@AuditOverride(forClass = AbstractAuditable.class)
public class Role extends AuditableDomain {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EnableStatus enable;

    public Role(String name, EnableStatus enable) {
        this.name = name;
        this.enable = enable;
    }
}
