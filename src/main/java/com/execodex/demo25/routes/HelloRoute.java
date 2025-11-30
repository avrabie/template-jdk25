package com.execodex.demo25.routes;

import com.execodex.demo25.handlers.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class HelloRoute {
    private final UserHandler userHandler;

    public HelloRoute(UserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> greetingsRoutes() {
        return RouterFunctions.route()
                .GET("/hello", request -> ServerResponse.ok().body(Mono.just("Hello World!"), String.class))
                .GET("/public", request -> ServerResponse.ok().body(Mono.just("Public Route Accessed!"), String.class))
                .GET("/user", userHandler::getUser)
                .build();
    }
}
