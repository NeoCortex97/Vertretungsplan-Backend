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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
//  @Column
//  private Set<Teacher> teachers;
//  @Column
//  private Set<Room> rooms;
//  @Column
//  private Set<Grade> grades;
}
