package com.execodex.demo25.persistency.repos;

import com.execodex.demo25.persistency.tables.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByUsername(String username);
    Mono<User> findByEmail(String email);
}
