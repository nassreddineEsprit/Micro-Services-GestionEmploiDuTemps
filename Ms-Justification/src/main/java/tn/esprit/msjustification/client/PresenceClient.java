package tn.esprit.msjustification.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.msjustification.dto.PresenceDTO;

@FeignClient(name = "ms-presence")
public interface PresenceClient {

    @GetMapping("/api/presences/getPresence/{id}")
    PresenceDTO getPresenceById(@PathVariable("id") Long id);
}
