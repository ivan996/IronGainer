package com.irongainer.workoutservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "categories", schema = "public")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nameOfCategory;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return Objects.equals(id, that.id) && Objects.equals(nameOfCategory, that.nameOfCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfCategory);
    }
}