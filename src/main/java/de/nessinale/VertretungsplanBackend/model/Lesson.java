package de.nessinale.VertretungsplanBackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "day_of_week")
    @Enumerated
    Weekday day;
    @Column
    @Positive
    Integer lesson;
    @ManyToOne
    Subject subject;
    @ManyToOne
    Room room;
    @ManyToOne
    School school;
    @ManyToOne
    Grade grade;
}
