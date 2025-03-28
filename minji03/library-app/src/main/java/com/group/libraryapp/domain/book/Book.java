package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // , length = 255, name = "name" 이 둘은 기본값이므로 생략 가능
    private String name;

    protected Book(){};

    public Book(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(String.format("잘못된 name (%s)이 들어옴", name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
