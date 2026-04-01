package com.healthcare.generated.proj-102;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface Proj102Repository extends JpaRepository<Proj102, Long> {
    
    @Query("SELECT s FROM Proj102 s WHERE s.priority = :priority")
    List<Proj102> findByPriority(String priority);
    
    @Query("SELECT s FROM Proj102 s WHERE s.status = :status")
    List<Proj102> findByStatus(String status);
    
    @Query("SELECT s FROM Proj102 s WHERE s.title LIKE %:keyword%")
    List<Proj102> findByTitleContaining(String keyword);
}