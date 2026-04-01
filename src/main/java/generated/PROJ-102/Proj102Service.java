package com.healthcare.generated.proj-102;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class Proj102Service {
    
    private final Proj102Repository repository;
    
    public List<Proj102> getAllStories() {
        log.info("Fetching all stories");
        return repository.findAll();
    }
    
    public Optional<Proj102> getStoryById(Long id) {
        log.info("Fetching story by id: {}", id);
        return repository.findById(id);
    }
    
    public Proj102 createStory(Proj102 story) {
        log.info("Creating new story: {}", story.getTitle());
        story.setCreatedAt(LocalDateTime.now());
        story.setUpdatedAt(LocalDateTime.now());
        return repository.save(story);
    }
    
    public Proj102 updateStory(Long id, Proj102 story) {
        log.info("Updating story: {}", id);
        Proj102 existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Story not found: " + id));
        
        existing.setTitle(story.getTitle());
        existing.setDescription(story.getDescription());
        existing.setPriority(story.getPriority());
        existing.setStatus(story.getStatus());
        existing.setUpdatedAt(LocalDateTime.now());
        
        return repository.save(existing);
    }
    
    public void deleteStory(Long id) {
        log.info("Deleting story: {}", id);
        repository.deleteById(id);
    }
    
    public List<Proj102> getStoriesByPriority(String priority) {
        log.info("Fetching stories by priority: {}", priority);
        return repository.findByPriority(priority);
    }
}