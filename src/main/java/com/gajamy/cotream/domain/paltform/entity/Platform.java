package com.gajamy.cotream.domain.paltform.entity;

import com.gajamy.cotream.domain.BaseEntity;
import com.gajamy.cotream.domain.user.entity.Users;
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
@Table(name = "platform")
public class Platform extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String name;

    private String profile;

    @Column(nullable = false)
    private int followers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
}
