package NTTDATA.application.service;

import NTTDATA.application.api.response.AssuranceResponse;
import NTTDATA.application.entity.Assurance;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssuranceService {
    Mono<String> createAssurance(Assurance assurance);
    Flux<AssuranceResponse> getAllActiveAssuranceList();

    Mono<Long> count();
}
