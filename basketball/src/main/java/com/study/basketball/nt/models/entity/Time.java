package com.study.basketball.nt.models.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 테이블로 매핑하지 않고, 자식 Entity에게 매핑정보를 상속하기 위한 애노테이션
@EntityListeners(AuditingEntityListener.class) // JPA에게 해당 Entity는 Auditing 기능을 사용한다는 것을 알리는 애노테이션
public class Time {

    @CreatedDate
    @Column(name = "REG_DT", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "MDF_DT", nullable = false)
    @LastModifiedDate
    private LocalDateTime mdfDt;

    @PrePersist
    public void onPrePersist() {
        this.regDt = LocalDateTime.now();
        this.mdfDt = this.regDt;
    }

    @PreUpdate
    public void onPreUpdate() {
        this.mdfDt = LocalDateTime.now();
    }
}
