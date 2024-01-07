package de.nessinale.VertretungsplanBackend.controller;

import de.nessinale.VertretungsplanBackend.dto.WeekDTO;
import de.nessinale.VertretungsplanBackend.model.Lesson;
import de.nessinale.VertretungsplanBackend.model.School;
import de.nessinale.VertretungsplanBackend.model.Weekday;
import de.nessinale.VertretungsplanBackend.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(name = "/week")
public class WeekController {
  @Autowired
  private SchoolRepository schoolRepo;

  @GetMapping("/{school}/")
  public WeekDTO getWeek(@PathVariable("school") String school) {
    School s = schoolRepo.findByName(school).orElseThrow();
    return WeekDTO.builder()
            .monday(s.getLessons().stream().filter(item -> item.getDay() == Weekday.MONDAY).toList())
            .tuesday(s.getLessons().stream().filter(item -> item.getDay() == Weekday.TUESDAY).toList())
            .wednesday(s.getLessons().stream().filter(item -> item.getDay() == Weekday.WEDNESDAY).toList())
            .thusday(s.getLessons().stream().filter(item -> item.getDay() == Weekday.THURSDAY).toList())
            .friday(s.getLessons().stream().filter(item -> item.getDay() == Weekday.FRIDAY).toList())
            .schoolName(s.getName())
            .build();
  }

  @GetMapping("/{school}/{grade}")
  public List<Lesson> getWeekByClass(@PathVariable("school") String school, @PathVariable("grade") Long grade) {
    School s = schoolRepo.findByName(school).orElseThrow();
    return s.getGrades().stream().filter(item -> Objects.equals(item.getId(), grade)).toList().get(0).getLessons();
  }


}

/**
 * Klassenbuch
 * Raumänderungen
 * Entfall
 * Rundschreiben / Ankündigungen
 *
 */
