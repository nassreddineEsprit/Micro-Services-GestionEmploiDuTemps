package tn.esprit.msjustification.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.esprit.msjustification.entities.Justification;

public interface JustificationRepository extends MongoRepository<Justification, String> {
}
