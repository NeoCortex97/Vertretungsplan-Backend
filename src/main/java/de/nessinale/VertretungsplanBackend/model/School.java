package de.nessinale.VertretungsplanBackend.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class School {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String name;
  @ManyToMany
  private Set<Teacher> teachers;
  @OneToMany(mappedBy = "school")
  private Set<Room> rooms;
  @OneToMany(mappedBy = "school")
  private Set<Grade> grades;
  @OneToMany(mappedBy = "school")
  private List<Lesson> lessons;
}
