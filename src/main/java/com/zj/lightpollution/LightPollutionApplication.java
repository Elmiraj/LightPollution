package com.zj.lightpollution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zj.lightpollution.repository")
public class LightPollutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightPollutionApplication.class, args);
    }

}

