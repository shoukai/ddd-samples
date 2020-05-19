package org.apframework.ddd.employee;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@MapperScan("org.apframework.ddd.employee.domain.repository")
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("employee run.");
    }
}
