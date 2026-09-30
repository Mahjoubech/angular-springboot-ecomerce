package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(callSuper = true , exclude = { "password" })
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public abstract class User extends BaseEntity{
    @Column(name="first_name" , nullable = false)
    protected String firstName;
    @Column(name="last_name" , nullable = false)
    protected String lastName;
    @Column(name="email" , nullable = false , unique = true)
    protected String email;
    @Column(name="password" , nullable = false)
    protected String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private RolesEntity role;
}
