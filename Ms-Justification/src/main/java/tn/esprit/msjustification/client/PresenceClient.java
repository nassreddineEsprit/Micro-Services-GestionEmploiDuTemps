package tn.esprit.msjustification.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import tn.esprit.msjustification.dto.PresenceDTO;
import tn.esprit.dto.PresenceDTO;

@FeignClient(name = "ms-presence",url = "http://localhost:9090")
public interface PresenceClient {

    @GetMapping("/api/presences/getPresence/{id}")
    PresenceDTO getPresenceById(@PathVariable("id") Long id);
}
