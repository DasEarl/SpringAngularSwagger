package com.example.angular;

import io.swagger.api.PetApi;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class AngularApplication {
    public static void main(String[] args) {
        SpringApplication.run(AngularApplication.class, args);
    }

    private static void logUser(User user) {
        log.info(String.format("%s, %s", user.getFirstname(), user.getLastname()));
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (String... args) -> {
            repository.save(new User("Hasan", "Celik"));
            repository.save(new User("Ilja", "Köthe"));
            repository.save(new User("Sergen", "Sentürk"));

            repository.findAll().forEach(AngularApplication::logUser);
            repository.findByLastname("Celik").forEach(AngularApplication::logUser);
        };
    }
}
