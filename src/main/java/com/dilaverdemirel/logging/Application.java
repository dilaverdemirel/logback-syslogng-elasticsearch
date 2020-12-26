package com.dilaverdemirel.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RestController
    class SalutationController {

        private final Random random = new Random();
        private final Logger logger = LoggerFactory.getLogger(SalutationController.class);

        @GetMapping
        public String sayHi(@RequestParam("name") String name) {
            logger.info("Say hi to {}", name);

            if (random.nextInt(100) % 2 == 0) {
                throw new RuntimeException("Random exception!");
            }
            return "Hi " + name;
        }
    }
}
