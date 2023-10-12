package com.fynanse.Fynanse.api.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private double currentBalance;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private double initialBalance;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private double lastSpent;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private double weeklySpent;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private double monthlySpent;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private User user;

}