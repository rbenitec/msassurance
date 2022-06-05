package NTTDATA.application.web.expose;

import NTTDATA.application.api.response.AssuranceResponse;
import NTTDATA.application.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/assurance")
public class AssuranceController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping(value = "/active")
    public Flux<AssuranceResponse> getActiveAssuranceList(){
        return assuranceService.getAllActiveAssuranceList();
    }

}
