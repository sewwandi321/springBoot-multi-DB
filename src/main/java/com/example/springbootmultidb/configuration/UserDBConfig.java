package com.example.springbootmultidb.configuration;


import com.example.springbootmultidb.model.user.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "userEntityManagerFactory",transactionManagerRef = "userTransactionManager"
       , basePackages = "com.example.springbootmultidb.repository.user")
public class UserDBConfig {


    @Bean
    @Primary
    @ConfigurationProperties("spring.user.datasource")
    public DataSourceProperties userDatasourceProperties(){
        return new DataSourceProperties();
    }
    @Bean
    @Primary
    @ConfigurationProperties("spring.user.datasource.configuration")
    public DataSource userDataSource() {
        return userDatasourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    @Primary
    @Bean(name ="userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(userDataSource())
                .packages(User.class)
                .build();
    }
    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager(
            final @Qualifier("userEntityManagerFactory") LocalContainerEntityManagerFactoryBean userEntityManagerFactory) {
        return new JpaTransactionManager(userEntityManagerFactory.getObject());
    }


}
