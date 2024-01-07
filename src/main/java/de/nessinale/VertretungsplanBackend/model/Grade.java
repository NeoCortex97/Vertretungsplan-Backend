package de.nessinale.VertretungsplanBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Grade {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String name;
  @ManyToOne
  School school;
  @OneToMany(mappedBy = "grade")
  List<Lesson> lessons;
}
