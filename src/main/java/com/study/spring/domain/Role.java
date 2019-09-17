package com.study.spring.domain;

import com.study.spring.enums.EnableStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Getter
@Setter
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Role {

    @Id
    @GeneratedValue
    private Long id;

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
