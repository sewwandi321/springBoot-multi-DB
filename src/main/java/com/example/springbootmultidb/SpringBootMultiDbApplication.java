package com.example.springbootmultidb;

import com.example.springbootmultidb.model.book.Book;
import com.example.springbootmultidb.model.user.User;
import com.example.springbootmultidb.repository.book.BookRepository;
import com.example.springbootmultidb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@SpringBootApplication

public class SpringBootMultiDbApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMultiDbApplication.class, args);
    }

}
