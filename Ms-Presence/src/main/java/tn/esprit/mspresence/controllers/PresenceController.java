package tn.esprit.mspresence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.mspresence.dto.JustificationDTO;
import tn.esprit.mspresence.dto.PresenceDTO;
import tn.esprit.mspresence.services.IPresenceService;

import java.util.List;

@RestController
@RequestMapping("/api/presences")
public class PresenceController {

    @Autowired
    private IPresenceService presenceService;

    @PostMapping("/addPresence")
    public ResponseEntity<PresenceDTO> createPresence(@RequestBody PresenceDTO presenceDTO) {
        PresenceDTO savedPresence = presenceService.savePresence(presenceDTO);
        return ResponseEntity.ok(savedPresence);
    }

    @PutMapping("updatePresence/{id}")
    public ResponseEntity<PresenceDTO> updatePresence(@PathVariable Long id, @RequestBody PresenceDTO presenceDTO) {
        presenceDTO.setIdPresence(id);
        PresenceDTO updatedPresence = presenceService.updatePresence(presenceDTO);
        return ResponseEntity.ok(updatedPresence);
    }

    @DeleteMapping("deletePresence/{id}")
    public ResponseEntity<Void> deletePresence(@PathVariable Long id) {
        presenceService.deletePresence(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getPresence/{id}")
    public ResponseEntity<PresenceDTO> getPresenceById(@PathVariable Long id) {
        PresenceDTO presenceDTO = presenceService.getPresenceById(id);
        return ResponseEntity.ok(presenceDTO);
    }

    @GetMapping("getAllPresences")
    public ResponseEntity<List<PresenceDTO>> getAllPresences() {
        List<PresenceDTO> presences = presenceService.getAllPresences();
        return ResponseEntity.ok(presences);
    }
    @GetMapping("/justifications/getJustification/{justificationId}")
    public ResponseEntity<JustificationDTO> getJustificationForPresence(@PathVariable String justificationId) {
        JustificationDTO justificationDTO = presenceService.getJustificationForPresence(justificationId);
        return ResponseEntity.ok(justificationDTO);
    }
}