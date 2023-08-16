package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TeacherService {
  @Autowired
  private TeacherRepository repository;

  public List<String> all() {
    return Arrays.asList(
            "Michael Langwald",
            "Christopher Castle",
            "Michaela Wahl",
            "Daniel Schüller",
            "Florian Schuppan"
    );
  }
}
