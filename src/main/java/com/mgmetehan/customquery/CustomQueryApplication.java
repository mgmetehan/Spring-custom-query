package com.mgmetehan.customquery;

import com.mgmetehan.customquery.model.User;
import com.mgmetehan.customquery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CustomQueryApplication {

    private final UserRepository userRepository;

    public CustomQueryApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomQueryApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            userRepository.deleteAll();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            List<User> users = Arrays.asList(
                    new User("metehan", true, 7500, sdf.parse("1999-08-15")),
                    new User("cansu", true, 5000, sdf.parse("2001-01-01")),
                    new User("mert", false, 7000, sdf.parse("1992-05-21")),
                    new User("elif", true, 6500, sdf.parse("1988-11-30")),
                    new User("burak", true, 4800, sdf.parse("1995-02-15")),
                    new User("zeynep", false, 5600, sdf.parse("2001-07-19"))
            );
            userRepository.saveAll(users);
        };
    }
}
