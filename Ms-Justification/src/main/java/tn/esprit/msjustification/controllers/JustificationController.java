package tn.esprit.msjustification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msjustification.dto.JustificationDTO;
import tn.esprit.msjustification.services.IJustificationService;

import java.util.List;

@RestController
@RequestMapping("/api/justifications")
public class JustificationController {

    @Autowired
    private IJustificationService justificationService;

    @PostMapping("/addjustification")
    public ResponseEntity<JustificationDTO> createJustification(@RequestBody JustificationDTO justificationDTO) {
        JustificationDTO savedJustification = justificationService.saveJustification(justificationDTO);
        return ResponseEntity.ok(savedJustification);
    }

    @PutMapping("updateJustification/{id}")
    public ResponseEntity<JustificationDTO> updateJustification(@PathVariable String id, @RequestBody JustificationDTO justificationDTO) {
        justificationDTO.setIdJustification(id);
        JustificationDTO updatedJustification = justificationService.updateJustification(justificationDTO);
        return ResponseEntity.ok(updatedJustification);
    }

    @DeleteMapping("deleteJustification/{id}")
    public ResponseEntity<Void> deleteJustification(@PathVariable String id) {
        justificationService.deleteJustification(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getJustification/{id}")
    public ResponseEntity<JustificationDTO> getJustificationById(@PathVariable String id) {
        JustificationDTO justificationDTO = justificationService.getJustificationById(id);
        return ResponseEntity.ok(justificationDTO);
    }

    @GetMapping("/getAllJustifications")
    public ResponseEntity<List<JustificationDTO>> getAllJustifications() {
        List<JustificationDTO> justifications = justificationService.getAllJustifications();
        return ResponseEntity.ok(justifications);
    }
}