package com.healthcare.generated.proj-101;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stories")
@RequiredArgsConstructor
@Slf4j
public class Proj101Controller {
    
    private final Proj101Service service;
    
    @GetMapping
    public ResponseEntity<List<Proj101>> getAllStories() {
        log.info("GET /api/v1/stories");
        return ResponseEntity.ok(service.getAllStories());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Proj101> getStoryById(@PathVariable Long id) {
        log.info("GET /api/v1/stories/{{id}}", id);
        return service.getStoryById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Proj101> createStory(@Valid @RequestBody Proj101 story) {
        log.info("POST /api/v1/stories");
        Proj101 created = service.createStory(story);
        return ResponseEntity.ok(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Proj101> updateStory(
            @PathVariable Long id, 
            @Valid @RequestBody Proj101 story) {
        log.info("PUT /api/v1/stories/{{id}}", id);
        Proj101 updated = service.updateStory(id, story);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable Long id) {
        log.info("DELETE /api/v1/stories/{{id}}", id);
        service.deleteStory(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Proj101>> getStoriesByPriority(@PathVariable String priority) {
        log.info("GET /api/v1/stories/priority/{{priority}}", priority);
        return ResponseEntity.ok(service.getStoriesByPriority(priority));
    }
}