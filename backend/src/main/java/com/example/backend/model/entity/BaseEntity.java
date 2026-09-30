package com.example.backend.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.ObjectError;
import org.hibernate.proxy.HibernateProxy;


import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, updatable = true)
    private LocalDateTime updatedAt;
    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false, updatable = true)
    private String updatedBy;
    @Override
    public final boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (!effectiveClass(o).equals(effectiveClass(this))) return false;
        String otherId = ((BaseEntity) o).getId();
        return id != null && id.equals(otherId);
    }
    @Override
    public final int hashCode(){
        return id != null ?  id.hashCode() : effectiveClass(this).hashCode();
    }
    private  static  Class<?> effectiveClass(Object entity){
        return entity instanceof HibernateProxy proxy
                ? proxy.getHibernateLazyInitializer().getImplementation().getClass()
                : entity.getClass();
    }
}
