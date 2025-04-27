package com.example.ls.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name; // e.g. "ROLE_USER", "ROLE_ADMIN"

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    // getters/setters
}