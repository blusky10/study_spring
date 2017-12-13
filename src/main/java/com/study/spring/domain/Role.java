package com.study.spring.domain;

import com.study.spring.auditing.AuditableDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Role extends AuditableDomain {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean enable;

    private String description;

    public Role(String name, boolean enable) {
        this.name = name;
        this.enable = enable;
    }
}
