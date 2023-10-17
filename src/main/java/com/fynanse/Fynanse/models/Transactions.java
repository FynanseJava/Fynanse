package com.fynanse.Fynanse.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date transactionDate;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "user_username")
    private User user;
}