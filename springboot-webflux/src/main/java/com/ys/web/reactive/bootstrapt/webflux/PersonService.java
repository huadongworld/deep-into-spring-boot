package com.ys.web.reactive.bootstrapt.webflux;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author HuaDong
 * @date 2018/12/16 22:12
 */
@Service
public class PersonService {

    public Mono<ServerResponse> listPeople(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> createPerson(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> getPerson(ServerRequest request) {
        return null;
    }
}


