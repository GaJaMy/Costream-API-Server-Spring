package com.gajamy.cotream.domain.collaboration.entity;

import com.gajamy.cotream.domain.collaboration.enums.CollaborationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "collaboration")
public class Collaboration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collaborationId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime time;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CollaborationStatus status;

    @CreatedDate
    @Column(nullable = false, updatable = true)
    private LocalDateTime createdAt;
}
