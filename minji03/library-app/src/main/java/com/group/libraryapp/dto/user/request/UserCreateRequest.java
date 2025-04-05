package com.group.libraryapp.dto.user.request;

//@Getter 붙일 수 있음
public class UserCreateRequest {
    private String name;
    private Integer age = null;

    public UserCreateRequest() {}
    public UserCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}
