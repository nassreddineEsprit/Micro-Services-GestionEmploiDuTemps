package tn.esprit.msjustification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.msjustification.dto.JustificationDTO;
import tn.esprit.msjustification.entities.Justification;
import tn.esprit.msjustification.mappers.JustificationMapper;
import tn.esprit.msjustification.repositories.JustificationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IJustificationServiceImpl implements IJustificationService{
    @Autowired
    private JustificationRepository justificationRepository;

    @Autowired
    private JustificationMapper justificationMapper;

    @Override
    public JustificationDTO saveJustification(JustificationDTO justificationDTO) {
        Justification justification = justificationMapper.maptoEntity(justificationDTO);
        justification = justificationRepository.save(justification);
        return justificationMapper.maptoDto(justification);
    }

    @Override
    public JustificationDTO updateJustification(JustificationDTO justificationDTO) {
        Justification justification = justificationMapper.maptoEntity(justificationDTO);
        justification = justificationRepository.save(justification);
        return justificationMapper.maptoDto(justification);
    }

    @Override
    public void deleteJustification(String id) {
        justificationRepository.deleteById(id);
    }

    @Override
    public JustificationDTO getJustificationById(String id) {
        Justification justification = justificationRepository.findById(id).orElse(null);
        return justificationMapper.maptoDto(justification);
    }

    @Override
    public List<JustificationDTO> getAllJustifications() {
        List<Justification> justifications = justificationRepository.findAll();
        return justifications.stream()
                .map(justificationMapper::maptoDto)
                .collect(Collectors.toList());
    }
}
