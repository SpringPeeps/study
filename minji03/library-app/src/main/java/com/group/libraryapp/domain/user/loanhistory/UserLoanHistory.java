package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import jakarta.persistence.*;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    // @Column
    // private Long userId;

    @ManyToOne // 내가 다수이고(N), 네가 하나임(1)
    private User user;

    @Column
    private String bookName;

    @Column
    private boolean isReturn; // 0 == false, 1 == true로 자동으로 매핑!

    protected UserLoanHistory() {};

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn() {
        this.isReturn = true;
    }

    public String getBookName() {
        return this.bookName;
    }
}
