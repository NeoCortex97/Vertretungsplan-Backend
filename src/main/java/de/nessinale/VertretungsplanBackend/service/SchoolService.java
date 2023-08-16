package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
  private SchoolRepository repository;

  @Autowired
  public SchoolService(SchoolRepository schoolRepository) {
    repository = schoolRepository;
  }
}
