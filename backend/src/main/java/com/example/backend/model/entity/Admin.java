package com.example.backend.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "admins")
@ToString(callSuper = true)
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {
}
