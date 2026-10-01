package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@ToString(callSuper = true)
@SuperBuilder
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User{
    @Column(name = "address" , nullable = false)
    private String address;
    @Column(name = "phone_number" , nullable = false , unique = true)
    private String phoneNumber;
}
