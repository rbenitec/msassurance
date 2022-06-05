package NTTDATA.application.repository;

import NTTDATA.application.entity.Assurance;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends ReactiveMongoRepository<Assurance, String> {
}
