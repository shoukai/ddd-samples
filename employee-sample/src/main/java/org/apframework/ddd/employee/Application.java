package org.apframework.ddd.employee;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class Application implements CommandLineRunner {
    public void run(String... args) throws Exception {
        log.info("employee project run");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
