package de.nessinale.VertretungsplanBackend.dto;

import de.nessinale.VertretungsplanBackend.model.Lesson;
import lombok.Builder;

import java.util.List;

@Builder
public record WeekDTO(
        String schoolName,
        List<Lesson> monday,
        List<Lesson> tuesday,
        List<Lesson> wednesday,
        List<Lesson> thusday,
        List<Lesson> friday
){}
