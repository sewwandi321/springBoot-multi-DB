package com.example.springbootmultidb;

import com.example.springbootmultidb.model.book.Book;
import com.example.springbootmultidb.model.user.User;
import com.example.springbootmultidb.repository.book.BookRepository;
import com.example.springbootmultidb.repository.user.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootTest
class SpringBootMultiDbApplicationTests {

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    BookRepository bookRepository;
//
//    private static User user;
//    private static Book book;
//    @BeforeAll
//    public static void initializeDataObjects(){
//        user = User.builder().userName("navodya").build();
//        book = Book.builder().Bookname("jane").build();
//    }
    @Test
    void contextLoads() {
//
//        userRepository.save(User.builder().Userid(123).userName("navodya").build());
//        userRepository.save(User.builder().Userid(124).userName("navodya2").build());
////        User save = userRepository.save(user);
////        Optional<User> userById = userRepository.findById(save.getUserid());
//        assert (userById.isPresent());

//        userRepository.deleteAll();
//        bookRepository.deleteAll();
//
//        userRepository.findAll();
//        bookRepository.findAll();
//        System.out.println("Users" + userRepository.findAll());
//        System.out.println("Books" + bookRepository.findAll());



    }
//    @Test
//    public void savebook(){
//        Book save = bookRepository.save(book);
//        Optional<Book> book = bookRepository.findById(save.getBookid());
//        assert book.isPresent();
//    }


}
