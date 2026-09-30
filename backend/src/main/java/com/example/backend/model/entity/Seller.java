package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Table(name = "sellers")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Seller extends User {
    @Column(name = "seller_code" ,unique = true , nullable = false)
    private String sellerCode;
}
