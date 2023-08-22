package de.nessinale.VertretungsplanBackend.controller;

import de.nessinale.VertretungsplanBackend.dto.WeekDTO;
import de.nessinale.VertretungsplanBackend.model.School;
import de.nessinale.VertretungsplanBackend.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/week")
public class WeekController {
  @Autowired
  private SchoolRepository schoolRepo;

  @GetMapping("/{school}/")
  public WeekDTO getWeek(@PathVariable String school) {
    School s = schoolRepo.findByName(school).get();
    return null;
  }
}
