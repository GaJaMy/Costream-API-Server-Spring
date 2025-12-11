package com.gajamy.cotream.domain.user.entity;

import com.gajamy.cotream.domain.BaseEntity;
import com.gajamy.cotream.domain.friend.entity.Friend;
import com.gajamy.cotream.domain.friend.entity.FriendRequest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class Users extends BaseEntity {
    @Id
    private String id;

    private String profile;

    @Column(nullable = false)
    private int followers;

    @OneToMany(mappedBy = "toId", cascade = CascadeType.ALL)
    private List<FriendRequest> friendRequests;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Friend> friends = new ArrayList<>();
}
