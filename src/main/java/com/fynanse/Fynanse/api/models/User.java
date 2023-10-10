package com.fynanse.Fynanse.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(nullable = false, unique = true)
    private String username;
    private String userPassword;
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private double currentBalance;
    @Column(columnDefinition = "boolean default false")
    public Boolean loggedIn = false;
    public User(String username,  String password, double currentBalance) {
        this.username = username;
        this.userPassword = password;
        this.currentBalance = currentBalance;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getUsername() != null && Objects.equals(getUsername(), user.getUsername());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}