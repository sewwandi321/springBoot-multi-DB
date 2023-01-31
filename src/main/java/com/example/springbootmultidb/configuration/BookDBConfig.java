package com.example.springbootmultidb.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.springbootmultidb.repository.book",
        entityManagerFactoryRef = "bookEntityManagerFactory",
        transactionManagerRef= "bookTransactionManager")
public class BookDBConfig {

    @Bean
    @ConfigurationProperties("spring.book.datasource")
    public DataSourceProperties bookDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.book.configuration")
    public DataSource bookDataSource() {
        return bookDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Bean(name = "bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
                 return builder
                .dataSource(bookDataSource())
                .packages("com.example.springbootmultidb.model.book")
                .build();
    }
    @Bean
    public PlatformTransactionManager bookTransactionManager(
            final @Qualifier("bookEntityManagerFactory") LocalContainerEntityManagerFactoryBean bookEntityManagerFactory) {
        return new JpaTransactionManager(bookEntityManagerFactory.getObject());
    }

}
