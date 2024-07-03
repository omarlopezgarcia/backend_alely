package pe.edu.vallegrande.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.app.model.entity.Area;
import pe.edu.vallegrande.app.repository.AreaRepository;
import pe.edu.vallegrande.app.service.AreaService;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area getForId(Long id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public Area created(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area update(Long id, Area areas) {
        Optional<Area> areaId = areaRepository.findById(id);
        if (areaId.isPresent()){
            Area area = areaId.get();
            area.setType(areas.getType());
            return areaRepository.save(area);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        areaRepository.deleteById(id);
    }

}
