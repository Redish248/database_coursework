package itmo.coursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"itmo.coursework.service", "itmo.coursework.entity",
        "itmo.coursework.controller", "itmo.coursework.impl",
        "itmo.coursework.config",})
@EntityScan("itmo.coursework.entity")
@EnableJpaRepositories("itmo.coursework.repository.statistic")
public class DatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }
}
