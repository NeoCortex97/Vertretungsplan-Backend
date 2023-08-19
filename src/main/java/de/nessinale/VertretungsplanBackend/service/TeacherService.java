package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.model.Teacher;
import de.nessinale.VertretungsplanBackend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
  @Autowired
  private TeacherRepository repository;

  public List<Teacher> all() {
    List<Teacher> res = new ArrayList<>();
    repository.findAll().forEach(res::add);
    return res;
  }

  public void add(Teacher teacher) {
    // This is due to a strange bug with the first item being added multiple times.
    // That's strange shit tho!
    if (!repository.existsByShorthand(teacher.getShorthand()))
      repository.save(teacher);
  }

  public Teacher byShorthand(String shorthand) {
    return repository.findByShorthand(shorthand);
  }

  public void update(Long id, Optional<String> shorthand, Optional<String> name) {
    Teacher entity = repository.findById(id).get();
    shorthand.ifPresent(entity::setShorthand);
    name.ifPresent(entity::setName);
    repository.save(entity);
  }
}
