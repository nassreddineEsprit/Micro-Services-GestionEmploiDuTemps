package tn.esprit.mspresence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mspresence.entities.Presence;

public interface PresenceRepository extends JpaRepository <Presence, Long> {
}
