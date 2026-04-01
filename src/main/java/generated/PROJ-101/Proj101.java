package com.healthcare.generated.proj-101;

import javax.persistence.*;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDateTime;

@Entity
@Table(name = "proj-101")
@Data
@Builder
public class Proj101 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String priority;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}