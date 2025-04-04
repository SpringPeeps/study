package com.group.libraryapp.service.book;

import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// import javax.transaction.Transactional;
import jakarta.transaction.Transactional;


@Service
//@RequiredArgsConstructor // 현재 존재하는 필드들에 꼭 필요한 생성자가 자동으로 생김
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService( // spring container로부터 의존성을 주입받기 위해 생성자 사용
            BookRepository bookRepository,
            UserLoanHistoryRepository userLoanHistoryRepository,
            UserRepository userRepository
    ) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createBook(BookCreateRequest request) {
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        // 1. 책 정보 가져오기 (bookName 기준이므로 내장 CRUD 사용 불가)
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        // 2. 대출중인 책인지 점검하기
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)) {
            // 3. 대출중인 책이라면 예외 발생시키기
            throw new IllegalArgumentException("Book already loaned");
        } else {
            // 4. 대출중이지 않다면 빌려주기
            // 4-1. user 정보 가져오기
            User user = userRepository.findByName(request.getUserName())
                    .orElseThrow(IllegalArgumentException::new);
            // 4-2. user 정보와 책 정보를 기반으로 UserLoanHistory를 저장
            // userLoanHistoryRepository.save(new UserLoanHistory(user, book.getName()));
            user.loanBook(book.getName());

        }
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        //1. user 정보 가져오기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
//        // 2. user id, book name을 기준으로 대출기록을 찾음
//        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
//                .orElseThrow(IllegalArgumentException::new);
//        // 3. 반납 처리: isReturn == true로 바꿔주기
//        history.doReturn();
        user.returnBook(request.getBookName());

    }
}
