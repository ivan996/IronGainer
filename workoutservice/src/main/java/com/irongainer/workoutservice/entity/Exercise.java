package com.irongainer.workoutservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "exercises", schema = "public")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int numberOfSets;

    @Column(nullable = false)
    private int numberOfRepetition;

    @Column(nullable = false)
    private String muscleGroup;

    @Column
    private String description;

    @Column(nullable = false)
    @ManyToOne()
    @JoinColumn(name = "video_id")
    private Video video;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "exercises_categories", joinColumns = @JoinColumn(name = "exercises_id"), inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private List<Categories> categories;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return numberOfSets == exercise.numberOfSets && numberOfRepetition == exercise.numberOfRepetition && Objects.equals(id, exercise.id) && Objects.equals(muscleGroup, exercise.muscleGroup) && Objects.equals(description, exercise.description) && Objects.equals(video, exercise.video) && Objects.equals(categories, exercise.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numberOfSets, numberOfRepetition, muscleGroup, description, video, categories);
    }
}
