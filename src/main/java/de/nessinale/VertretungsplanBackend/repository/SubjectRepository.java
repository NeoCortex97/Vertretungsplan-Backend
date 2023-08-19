package de.nessinale.VertretungsplanBackend.repository;

import de.nessinale.VertretungsplanBackend.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
