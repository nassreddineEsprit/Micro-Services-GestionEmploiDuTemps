package tn.esprit.mspresence.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.mspresence.dto.JustificationDTO;

@FeignClient(name = "ms-justification")
public interface JustificationClient {
    @GetMapping("/api/justifications/getJustification/{justificationId}")
    JustificationDTO getJustificationById(@PathVariable("justificationId") String justificationId);
}
