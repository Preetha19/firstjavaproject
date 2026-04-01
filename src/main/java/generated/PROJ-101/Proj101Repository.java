package com.healthcare.generated.proj-101;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface Proj101Repository extends JpaRepository<Proj101, Long> {
    
    @Query("SELECT s FROM Proj101 s WHERE s.priority = :priority")
    List<Proj101> findByPriority(String priority);
    
    @Query("SELECT s FROM Proj101 s WHERE s.status = :status")
    List<Proj101> findByStatus(String status);
    
    @Query("SELECT s FROM Proj101 s WHERE s.title LIKE %:keyword%")
    List<Proj101> findByTitleContaining(String keyword);
}