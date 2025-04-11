package com.group.libraryapp.domain.book;

import javax.persistence.*;

@Entity
public class Book {

    public Book(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 이름(%s)가 들어왔습니다.", name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected Book(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;
}
