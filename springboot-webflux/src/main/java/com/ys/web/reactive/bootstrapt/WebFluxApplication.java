package com.ys.web.reactive.bootstrapt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author HuaDong
 * @date 2018/12/9 21:48
 *
 * SpringBoot Webflux编程模型之Function Endpoint，另一种是注解驱动
 */
@SpringBootApplication
@RestController
public class WebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class, args);
    }

    @GetMapping("/mvc")
    public String mvc() {
        println("mvc");
        return "MVC";
    }

    @GetMapping("/mono")
    public Mono<String> mono() {
        println("mono");
        return Mono.just("Mono");
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

//        // 写法一：
//        return RouterFunctions.route(
//                // 判断请求是否匹配
//                request -> {
//                    URI uri = request.uri();
//                    return "/hello-world".equals(uri.getPath());
//                },
//                // 绑定实现
//                request -> ServerResponse
//                        .status(HttpStatus.OK)
//                        .body(Mono.just("Hello World"), String.class)
//        );

        // 写法二：
        return route(GET("/hello-world"), this::helloWorld)
                .andRoute(GET("/hua-dong"), this::huaDong);
    }

    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest) {

        println("helloWorld");
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.just("Hello,World"), String.class);

    }

    public Mono<ServerResponse> huaDong(ServerRequest serverRequest) {

        println("Hua Dong!");
        return ServerResponse.status(HttpStatus.OK)
                .body(Mono.just("Hua Dong!"), String.class);

    }

    private static void println(String message) {
        System.out.println("[" + Thread.currentThread().getName() + "] : " + message);
    }

}
