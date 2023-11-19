package com.school.sotfware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 어노테이션을 활성화 시키도록 하는 어노테이션.
@SpringBootApplication
public class SotfwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(SotfwareApplication.class, args);
    }

}
