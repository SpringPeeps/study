package com.group.libraryapp.domain.user;

import javax.persistence.*;

@Entity
public class User {
    @Id // 이 필드를 PK로 간주한다는 의미
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동생성되는 값임을 의미
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String name;

    private Integer age;

    protected User() {}

    public User(String name, Integer age) {
        // name은 NOT NULL 이므로 조건을 걸어야 함
        if (name == null || name.trim().isEmpty()) { // 이렇게 예외를 던져두면, name이 비어있는 경우 User 객체 자체가 생성이 안됨
            throw new IllegalArgumentException("name은 비워둘 수 없습니다.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() { return id; }

    public void updateName(String name) {
        this.name = name;
    }
}
