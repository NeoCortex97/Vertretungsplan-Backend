package de.nessinale.VertretungsplanBackend.repository;

import de.nessinale.VertretungsplanBackend.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RestResource(exported = false)
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
