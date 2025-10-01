package com.hansreidan.store.payroll.config;

import com.hansreidan.store.payroll.domain.Employee;
import com.hansreidan.store.payroll.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository) {

        return args -> {
            log.info("Inizializzazione " + employeeRepository.save(new Employee("Bilbo","Bagging", "piedone")));
            log.info("Inizializzazione " + employeeRepository.save(new Employee("Frodo", "Baggins", "ladro")));
        };
    }

}
