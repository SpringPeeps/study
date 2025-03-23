package com.group.libraryapp.repository.user;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id) {
        String sqlCheck = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(sqlCheck, (rs, rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName(String name, long id) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public boolean isUserNotExist(String name) {
        // 수정하고자 하는 User가 데이터베이스에 존재하는지 검증
        String sqlCheck = "SELECT * FROM user WHERE name = ?";
        // user가 존재하지 않는다면 빈 리스트가 반환될 것임.
        return jdbcTemplate.query(sqlCheck, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
