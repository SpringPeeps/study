package com.group.libraryapp.domain.user.loanhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookNameAndIsReturn(String name, Boolean isReturn);
    // select * from user_loan_history where book_name = ? and is_return = ?
//    Optional<UserLoanHistory> findByUserIdAndBookName(Long userId, String bookName);
}
