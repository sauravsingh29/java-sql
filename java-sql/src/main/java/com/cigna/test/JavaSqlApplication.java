package com.cigna.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class JavaSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSqlApplication.class, args);
    }

    @Autowired
    private SQLServerRepository sqlServerRepository;

    @Autowired
    private SQLFileWriter sqlFileWriter;

    @Bean
    CommandLineRunner runner() {
        return $ -> {
            Page<Employee> employees = sqlServerRepository.findAll(PageRequest.of(0, 100));
            sqlFileWriter.write(employees.getContent());
        };
    }
}
