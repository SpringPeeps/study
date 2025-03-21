package com.group.libraryapp.domain.user;

public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        // name은 NOT NULL 이므로 조건을 걸어야 함
        if (name == null || name.trim().isEmpty()) { // 이렇게 예외를 던져두면, name이 비어있는 경우 User 객체 자체가 생성이 안됨
            throw new IllegalArgumentException("name은 비워둘 수 없습니다.");
        }
        this.name = name;
        this.age = age;
    }

}
