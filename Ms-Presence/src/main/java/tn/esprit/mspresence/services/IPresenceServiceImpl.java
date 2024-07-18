package tn.esprit.mspresence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.mspresence.client.JustificationClient;
import tn.esprit.mspresence.dto.JustificationDTO;
import tn.esprit.mspresence.dto.PresenceDTO;
import tn.esprit.mspresence.entities.Presence;
import tn.esprit.mspresence.mappers.PresenceMapper;
import tn.esprit.mspresence.repositories.PresenceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IPresenceServiceImpl implements IPresenceService {

    @Autowired
    private PresenceRepository presenceRepository;
    @Autowired
    private JustificationClient justificationClient;
    @Autowired
    private PresenceMapper presenceMapper;

    @Override
    public PresenceDTO savePresence(PresenceDTO presenceDTO) {
        Presence presence = presenceMapper.mapToEntity(presenceDTO);
        presence = presenceRepository.save(presence);
        return presenceMapper.mapToDto(presence);
    }

    @Override
    public PresenceDTO updatePresence(PresenceDTO presenceDTO) {
        Presence presence = presenceMapper.mapToEntity(presenceDTO);
        presence = presenceRepository.save(presence);
        return presenceMapper.mapToDto(presence);
    }

    @Override
    public void deletePresence(Long id) {
        presenceRepository.deleteById(id);
    }

    @Override
    public PresenceDTO getPresenceById(Long id) {
        Presence presence = presenceRepository.findById(id).orElse(null);
        return presenceMapper.mapToDto(presence);
    }

    @Override
    public List<PresenceDTO> getAllPresences() {
        List<Presence> presences = presenceRepository.findAll();
        return presences.stream()
                .map(PresenceMapper::mapToDto)
                .collect(Collectors.toList());
    }
    public JustificationDTO getJustificationForPresence(String justificationId) {
        return justificationClient.getJustificationById(justificationId);
    }
}
