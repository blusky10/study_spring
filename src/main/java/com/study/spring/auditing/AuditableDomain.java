package com.study.spring.auditing;

import com.study.spring.domain.Account;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class AuditableDomain extends AbstractAuditable<Account, Long> {
    private static final long serialVersionUID = 359326673134570560L;
}

