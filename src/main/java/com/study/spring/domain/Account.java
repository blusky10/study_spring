package com.study.spring.domain;

import com.study.spring.enums.EnableStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper=false)
//@Audited
//@AuditOverride(forClass = AbstractAuditable.class)
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue
    private Long id;

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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Role> roles;

}
