package com.study.spring.domain;

import com.study.spring.account.dto.AccountResDto;
import com.study.spring.enums.EnableStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper=false)
//@Audited
//@AuditOverride(forClass = AbstractAuditable.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "account_id")
//    private List<Role> roles;

    @Builder
    public Account(String loginId, String username, String password, String email, EnableStatus enable) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
    }

    public AccountResDto convertToAccountResDto(){
        return AccountResDto.builder()
                .username(this.username)
                .email(this.email)
                .loginId(this.loginId)
                .build();
    }

}
