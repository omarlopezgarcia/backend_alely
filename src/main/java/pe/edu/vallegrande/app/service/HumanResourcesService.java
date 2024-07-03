package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.dto.HumanResourcesDto;
import pe.edu.vallegrande.app.model.entity.HumanResources;

import java.util.List;

public interface HumanResourcesService {
    List<HumanResources> getActive();
    List<HumanResources> getInactive();
    HumanResources getForId(Long id);
    HumanResourcesDto created(HumanResourcesDto humanResourcesDto);
    HumanResourcesDto update(Long id, HumanResourcesDto humanResourcesDto);
    void removed(Long id);
    void restore(Long id);
    void delete(Long id);
}
