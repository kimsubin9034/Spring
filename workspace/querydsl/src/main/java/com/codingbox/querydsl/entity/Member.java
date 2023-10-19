package com.codingbox.querydsl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private int age;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID") // Team 엔티티와 연결할 컬럼
    private Team team;

    // 필요한 다른 멤버 변수 및 메서드들
}

