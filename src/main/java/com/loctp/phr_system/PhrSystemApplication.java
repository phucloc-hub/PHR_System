package com.loctp.phr_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.loctp.phr_system.controller", "com.loctp.phr_system.service","com.loctp.phr_system.utils"})
@EntityScan("com.loctp.phr_system.model")
@EnableJpaRepositories("com.loctp.phr_system.repository")
@EnableSwagger2
public class PhrSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhrSystemApplication.class, args);
    }

}
