package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
  @Autowired
  private GradeRepository repository;
}
