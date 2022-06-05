package NTTDATA.application.config;

import NTTDATA.application.entity.Assurance;
import NTTDATA.application.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

//Esto nos sirve para precargar el Data de nuestros Assurance

@Component
public class AssuranceDataLoader implements ApplicationRunner {

    @Autowired private AssuranceService assuranceService;
    //Voy a cargar data solo si no hay ningun valor dentro de la collecion de Assurance
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(assuranceService.count().block().equals(0L)){

            Assurance assurance1 = Assurance.builder()
                    .id(UUID.randomUUID().toString())
                    .description("Assurance number 1")
                    .minimumAmount(BigDecimal.valueOf(0))
                    .maximumAmount(BigDecimal.valueOf(500))
                    .price(BigDecimal.valueOf(5.50))
                    .status("1")
                    .build();

            Assurance assurance2 = Assurance.builder()
                    .id(UUID.randomUUID().toString())
                    .description("Assurance number 2")
                    .minimumAmount(BigDecimal.valueOf(500))
                    .maximumAmount(BigDecimal.valueOf(930))
                    .price(BigDecimal.valueOf(8.70))
                    .status("1")
                    .build();

            Assurance assurance3 = Assurance.builder()
                    .id(UUID.randomUUID().toString())
                    .description("Assurance number 3")
                    .minimumAmount(BigDecimal.valueOf(930))
                    .maximumAmount(BigDecimal.valueOf(1500))
                    .price(BigDecimal.valueOf(10.70))
                    .status("1")
                    .build();

            Assurance assurance4 = Assurance.builder()
                    .id(UUID.randomUUID().toString())
                    .description("Assurance number 4")
                    .minimumAmount(BigDecimal.valueOf(1500))
                    .maximumAmount(BigDecimal.valueOf(3500))
                    .price(BigDecimal.valueOf(13.8))
                    .status("1")
                    .build();

            Assurance assurance5 = Assurance.builder()
                    .id(UUID.randomUUID().toString())
                    .description("Assurance number 5")
                    .minimumAmount(BigDecimal.valueOf(3500))
                    .maximumAmount(BigDecimal.valueOf(1000000))
                    .price(BigDecimal.valueOf(100.80))
                    .status("0")
                    .build();
        }
    }
}
