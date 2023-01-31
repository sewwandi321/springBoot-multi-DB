package com.example.springbootmultidb.Controller;

import com.example.springbootmultidb.model.book.Book;
import com.example.springbootmultidb.model.user.User;
import com.example.springbootmultidb.repository.book.BookRepository;
import com.example.springbootmultidb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/user")
    public List<User> list(){
        return userRepository.findAll();
    }
    @GetMapping("/book")
    public List<Book> booklist(){
        return bookRepository.findAll();
    }

    }


