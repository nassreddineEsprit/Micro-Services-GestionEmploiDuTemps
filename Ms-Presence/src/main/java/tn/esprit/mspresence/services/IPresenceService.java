package tn.esprit.mspresence.services;

import tn.esprit.mspresence.dto.JustificationDTO;
import tn.esprit.mspresence.dto.PresenceDTO;

import java.util.List;

public interface IPresenceService {
    PresenceDTO savePresence(PresenceDTO presenceDTO);
    PresenceDTO updatePresence(PresenceDTO presenceDTO);
    void deletePresence(Long id);
    PresenceDTO getPresenceById(Long id);
    List<PresenceDTO> getAllPresences();
    JustificationDTO getJustificationForPresence(String justificationId);
}
