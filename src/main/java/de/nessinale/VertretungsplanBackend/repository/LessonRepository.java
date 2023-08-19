package de.nessinale.VertretungsplanBackend.repository;

import de.nessinale.VertretungsplanBackend.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository  extends JpaRepository<Lesson, Long> {
}
