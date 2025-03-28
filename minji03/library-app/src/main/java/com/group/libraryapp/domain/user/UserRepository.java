package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // @Repository 어노테이션 없이도 JpaRepository 를 상속한 것 만으로도 스프링빈으로 관리됨

    // 함수 만들기: 이 때 함수의 이름이 중요함 (함수명을 따라서 쿼리가 작성됨)
    Optional<User> findByName(String name);
}
