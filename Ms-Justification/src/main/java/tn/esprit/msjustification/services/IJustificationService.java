package tn.esprit.msjustification.services;

import tn.esprit.msjustification.dto.JustificationDTO;

import java.util.List;

public interface IJustificationService {
    JustificationDTO saveJustification(JustificationDTO justificationDTO);
    JustificationDTO updateJustification(JustificationDTO justificationDTO);
    void deleteJustification(String id);
    JustificationDTO getJustificationById(String id);
    List<JustificationDTO> getAllJustifications();
}
