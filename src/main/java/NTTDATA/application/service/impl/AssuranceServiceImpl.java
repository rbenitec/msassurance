package NTTDATA.application.service.impl;

import NTTDATA.application.api.response.AssuranceResponse;
import NTTDATA.application.entity.Assurance;
import NTTDATA.application.repository.AssuranceRepository;
import NTTDATA.application.service.AssuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class AssuranceServiceImpl implements AssuranceService {
    private final AssuranceRepository assuranceRepository;

    //  Metodo para crear un Assurance y que lo validemos haciendo que
    //  nos devuelva el ID con el que se autogenero(creo).
    @Override
    public Mono<String> createAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance)
                .map(storedAssurance -> storedAssurance.getId());
    }

    // Metodo para nos devuleva una lista de Assurance activos
    // Como se va obtener una lista de Assurance se coloca Flux<AssuranceReponse>
    // y como quiero todos los activos utilixo el filter con una validacion, que nos ayuda un metodo creado desde entity
    // una vez filtrado, quiero obtener ciertos valores de cada Assurance entonces me apoyo del map()

    @Override
    public Flux<AssuranceResponse> getAllActiveAssuranceList() {
        return assuranceRepository.findAll()
                .filter(Assurance::isActive)
                .map(assurance -> AssuranceResponse.builder()
                        .id(assurance.getId())
                        .maximumAmount(assurance.getMaximumAmount())
                        .minimumAmount(assurance.getMaximumAmount())
                        .price(assurance.getPrice())
                        .build());
    }

    //  Para realizar una validacion para saber si hay o no objetos registrados
    //  Catindad de item registrados dentro del repositorio de Assurance
    @Override
    public Mono<Long> count() {
        return assuranceRepository.count();
    }
}
