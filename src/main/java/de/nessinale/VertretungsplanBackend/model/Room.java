package de.nessinale.VertretungsplanBackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Room {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column
  private String name;
  @Column
  private String number;
  @ManyToOne
  School school;
  @OneToMany(mappedBy = "room")
  List<Lesson> lessons;
}
