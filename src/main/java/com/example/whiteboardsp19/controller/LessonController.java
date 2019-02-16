package com.example.whiteboardsp19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboardsp19.model.Lesson;
import com.example.whiteboardsp19.services.LessonService;

@RestController
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @DeleteMapping("/api/lessons/{lid}")
    public List<Lesson> deleteLesson(@PathVariable("lid") int lid) {
        return lessonService.deleteLesson(lid);
    }


    @PutMapping("/api/lessons/{lid}")
    public Lesson updateLesson(@PathVariable("lid") Integer lid, @RequestBody Lesson newLesson) {
        return lessonService.updateLesson(lid, newLesson);
    }

    @PostMapping("/api/modules/{mid}/lesson")
    public List<Lesson> createLesson(@PathVariable("mid") Integer mid, @RequestBody Lesson lesson) {
        return lessonService.createLesson(mid, lesson);
    }

    @GetMapping("/api/modules/{mid}/lesson")
    public List<Lesson> findAllLessons(@PathVariable("mid") Integer mid) {
        return lessonService.findAllLessons(mid);
    }

    @GetMapping("/api/lessons/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Integer lid) {
        return lessonService.findLessonById(lid);
    }

}
