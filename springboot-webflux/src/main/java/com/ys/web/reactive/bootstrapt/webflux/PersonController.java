package com.ys.web.reactive.bootstrapt.webflux;

import com.ys.web.reactive.bootstrapt.WebFluxApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author HuaDong
 * @date 2018/12/16 22:12
 */
@SpringBootApplication
@RestController
public class PersonController {

    public static void main(String[] args) {
        SpringApplication.run(PersonController.class, args);
    }

    @Autowired
    private PersonService service;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return route(GET("/person/{id}").and(accept(APPLICATION_JSON)), service::getPerson)
                .andRoute(GET("/person").and(accept(APPLICATION_JSON)), service::listPeople)
                .andRoute(POST("/person"), service::createPerson);
    }

    //=====================================以上方式等同于以下方式==========================================

    @GetMapping(value = "/person/{id}", consumes = "application/json")
    public void getPerson(HttpServletRequest request, HttpServletResponse response) {

    }

    @GetMapping(value = "/person", consumes = "application/json")
    public void listPeople(HttpServletRequest request, HttpServletResponse response) {

    }

    @GetMapping(value = "/person")
    public void createPerson(HttpServletRequest request, HttpServletResponse response) {

    }
}
