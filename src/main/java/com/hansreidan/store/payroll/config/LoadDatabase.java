package com.hansreidan.store.payroll.config;

import com.hansreidan.store.payroll.domain.Employee;
import com.hansreidan.store.payroll.domain.Order;
import com.hansreidan.store.payroll.domain.Status;
import com.hansreidan.store.payroll.repository.EmployeeRepository;
import com.hansreidan.store.payroll.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {

        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order(Status.COMPLETED, "MacBook Pro"));
            orderRepository.save(new Order(Status.IN_PROGRESS, "iPhone"));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });

        };
    }

}
