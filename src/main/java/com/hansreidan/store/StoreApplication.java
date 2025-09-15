package com.hansreidan.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {

    private final DataSource dataSource;

    public StoreApplication(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService = context.getBean(OrderService.class);
        orderService.placeOrder(34.5);

        // https://www.youtube.com/watch?v=Nv2DERaMx-4

    }

    @Override
    public void run(String... args) throws Exception {
        final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
        restTemplate.execute("select 1");
    }
}
