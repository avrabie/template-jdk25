package com.execodex.demo25.handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class HelloHandler {
    public Mono<ServerResponse> handleHello(ServerRequest serverRequest) {
        Mono<String> greeting = Mono.just("Hello World!");
        return ServerResponse.ok().body(greeting, String.class);
    }
}
