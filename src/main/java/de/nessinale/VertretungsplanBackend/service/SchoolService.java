package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.model.School;
import de.nessinale.VertretungsplanBackend.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
  private SchoolRepository repository;

  @Autowired
  public SchoolService(SchoolRepository schoolRepository) {
    repository = schoolRepository;
  }

  public List<School> all() {
    List<School> res = new ArrayList<>();
    repository.findAll().forEach(res::add);
    return res;
  }
  public void create() {}
}
