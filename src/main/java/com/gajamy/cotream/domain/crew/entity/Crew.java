package com.gajamy.cotream.domain.crew.entity;

import com.gajamy.cotream.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "crew")
public class Crew extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crewId;

    @Column(nullable = false, unique = true)
    private String uuid;

    private String imageUrl;

    private String notification;

    @Column(nullable = false)
    private String name;

    private String description;
}
