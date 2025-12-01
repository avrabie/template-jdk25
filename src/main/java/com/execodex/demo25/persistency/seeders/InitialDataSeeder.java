package com.execodex.demo25.persistency.seeders;

import com.execodex.demo25.persistency.repos.UserRepo;
import com.execodex.demo25.persistency.tables.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@Configuration
public class InitialDataSeeder {
    private final UserRepo userRepo;

    public InitialDataSeeder(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Bean
    public CommandLineRunner initData() {
        List<String> emails = List.of("user@user.com", "admin@admin.com", "iaka@execodex.com");
        emails.forEach(email -> userRepo.findByEmail(email)
                .map(User::getId)
                .flatMap(userRepo::deleteById)
                .subscribe());

        return args -> {
            Flux<User> users = Flux.fromIterable(emails)
                    .flatMap(email -> userRepo.save(
                            User.builder()
                                    .username(email.split("@")[0])
                                    .password("password")
                                    .email(email)
                                    .firstName(email.split("@")[0])
                                    .lastName(email.split("@")[1].split("\\.")[0])
                                    .build()
                    ));
            users
                    .subscribe();
            System.out.println("Creating users");
        };
    }
}
