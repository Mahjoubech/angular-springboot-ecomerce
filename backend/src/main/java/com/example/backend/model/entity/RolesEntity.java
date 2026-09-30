package com.example.backend.model.entity;

import com.example.backend.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString(callSuper = true , exclude = {"permissions"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class RolesEntity extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Role name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_permissions" , joinColumns = @JoinColumn(name = "role_id") , inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;
}
