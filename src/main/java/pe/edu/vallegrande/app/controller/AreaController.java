package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.entity.Area;
import pe.edu.vallegrande.app.service.AreaService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areas")
    public List<Area> getAll(){
        return areaService.getAll();
    }

    @GetMapping("/area")
    public Area getForId(@PathVariable Long id){
        return areaService.getForId(id);
    }

    @PostMapping("/area/")
    public Area created(@RequestBody Area area){
        return areaService.created(area);
    }

    @PutMapping("/area/{id}")
    public Area update(@PathVariable Long id, @RequestBody Area area){
        return areaService.update(id, area);
    }

    @DeleteMapping("/area/{id}")
    public void delete(@PathVariable Long id){
        areaService.delete(id);
    }

}
