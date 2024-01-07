package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.model.Lesson;
import de.nessinale.VertretungsplanBackend.model.Weekday;
import de.nessinale.VertretungsplanBackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
  @Autowired
  private RoomRepository repository;

  public List<Lesson> getPlannedLessonForWeekDay(Long roomId, Weekday day) {
    return repository.findById(roomId)
            .orElseThrow()
            .getLessons().stream()
            .filter(item -> item.getDay() == day)
            .toList();
  }
}
