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
@Table(name = "workout", schema = "public")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "workoutType_id")
    private WorkoutType workoutType;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "workout_exercises", joinColumns = @JoinColumn(name = "workout_id"), inverseJoinColumns = @JoinColumn(name = "exercises_id"))
    private List<Exercise> exercises;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return Objects.equals(id, workout.id) && Objects.equals(name, workout.name) && Objects.equals(description, workout.description) && Objects.equals(workoutType, workout.workoutType) && Objects.equals(exercises, workout.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, workoutType, exercises);
    }
}
