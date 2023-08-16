package de.nessinale.VertretungsplanBackend.controller;

import de.nessinale.VertretungsplanBackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
  @Autowired
  private TeacherService service;

  @GetMapping("/list")
  public List<String> listAll() {
    return service.all();
  }


}
