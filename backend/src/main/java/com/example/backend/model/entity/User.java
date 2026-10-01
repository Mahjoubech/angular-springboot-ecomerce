package com.example.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.*;
import lombok.experimental.SuperBuilder;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(callSuper = true , exclude = { "password" })
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public abstract class User extends BaseEntity {
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


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        if(role != null && role.getName() == null) return authorities;
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().name().toUpperCase()));
//        if(role.getPermissions() != null){
//            role.getPermissions().stream()
//                    .filter(permission -> permission.getName() != null)
//                    .map(permission ->  new SimpleGrantedAuthority(permission.getName().toUpperCase().replace(" " , "_")))
//                    .forEach(authorities::add);
//        }
//        System.out.println("========== AUTHORITIES ==========");
//        authorities.forEach((a -> System.out.println(a.getAuthority())));
//        System.out.println("=================================");
//        return authorities;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//    @Override
//    public String getPassword() {
//        return password;
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
}
