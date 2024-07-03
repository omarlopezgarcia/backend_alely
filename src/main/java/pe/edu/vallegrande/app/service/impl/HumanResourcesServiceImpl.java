package pe.edu.vallegrande.app.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.app.model.dto.HumanResourcesDto;
import pe.edu.vallegrande.app.model.entity.Area;
import pe.edu.vallegrande.app.model.entity.HumanResources;
import pe.edu.vallegrande.app.repository.AreaRepository;
import pe.edu.vallegrande.app.repository.HumanResourcesRepository;
import pe.edu.vallegrande.app.service.HumanResourcesService;

import java.util.List;
import java.util.Optional;

@Service
public class HumanResourcesServiceImpl implements HumanResourcesService {

    @Autowired
    private HumanResourcesRepository humanResourcesRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<HumanResources> getActive() {
        return humanResourcesRepository.findByActiveHumanResources("A");
    }

    @Override
    public List<HumanResources> getInactive() {
        return humanResourcesRepository.findByActiveHumanResources("I");
    }

    @Override
    public HumanResources getForId(Long id) {
        return humanResourcesRepository.findById(id).orElse(null);
    }

    public HumanResourcesDto created(HumanResourcesDto humanResourcesDto){
        Area area = areaRepository.findById(humanResourcesDto.getArea()).get();
        HumanResources humanResources = new HumanResources();
        humanResources.setName(humanResourcesDto.getName());
        humanResources.setLastName(humanResourcesDto.getLastName());
        humanResources.setDocumentType(humanResourcesDto.getDocumentType());
        humanResources.setDocumentNumber(humanResourcesDto.getDocumentNumber());
        humanResources.setCellphone(humanResourcesDto.getCellphone());
        humanResources.setArea(area);
        humanResources = humanResourcesRepository.save(humanResources);
        humanResourcesDto.setId(humanResources.getId());
        return humanResourcesDto;
    }

    @Override
    public HumanResourcesDto update(Long id, HumanResourcesDto humanResourcesDto) {
        Optional<HumanResources> humanResourcesId = humanResourcesRepository.findById(id);
        if (humanResourcesId.isPresent()){
            Area area = areaRepository.findById(humanResourcesDto.getArea()).get();
            HumanResources humanResources = humanResourcesId.get();
            humanResources.setName(humanResourcesDto.getName());
            humanResources.setLastName(humanResourcesDto.getLastName());
            humanResources.setDocumentType(humanResourcesDto.getDocumentType());
            humanResources.setDocumentNumber(humanResourcesDto.getDocumentNumber());
            humanResources.setCellphone(humanResourcesDto.getCellphone());
            humanResources.setArea(area);
            humanResources = humanResourcesRepository.save(humanResources);
            humanResourcesDto.setId(humanResources.getId());
            return humanResourcesDto;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void removed(Long id) {
        humanResourcesRepository.removeById(id);
    }

    @Transactional
    @Override
    public void restore(Long id) {
        humanResourcesRepository.restoreById(id);
    }

    @Override
    public void delete(Long id) {
        humanResourcesRepository.deleteById(id);
    }

}
