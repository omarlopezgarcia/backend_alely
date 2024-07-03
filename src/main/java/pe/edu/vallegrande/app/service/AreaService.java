package pe.edu.vallegrande.app.service;

import pe.edu.vallegrande.app.model.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAll();
    Area getForId(Long id);
    Area created(Area area);
    Area update(Long id, Area area);
    void delete(Long id);

}
