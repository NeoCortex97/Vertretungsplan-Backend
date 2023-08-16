package de.nessinale.VertretungsplanBackend.service;

import de.nessinale.VertretungsplanBackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
  @Autowired
  private RoomRepository repository;
}
