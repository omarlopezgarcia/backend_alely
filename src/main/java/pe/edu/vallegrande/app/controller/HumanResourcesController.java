package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.dto.HumanResourcesDto;
import pe.edu.vallegrande.app.model.entity.HumanResources;
import pe.edu.vallegrande.app.service.HumanResourcesService;

import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class HumanResourcesController {

    @Autowired
    private HumanResourcesService humanResourcesService;

    @GetMapping("/humanresources/active")
    public List<HumanResources> getActive(){
        return humanResourcesService.getActive();
    }

    @GetMapping("/humanresources/inactive")
    public List<HumanResources> getInactive(){
        return humanResourcesService.getInactive();
    }

    @GetMapping("/humanresource/{id}")
    public HumanResources getForId(@PathVariable Long id){
        return humanResourcesService.getForId(id);
    }

    @PostMapping("/humanresource/")
    public HumanResourcesDto created(@RequestBody HumanResourcesDto humanResourcesDto){
        return humanResourcesService.created(humanResourcesDto);
    }

    @PutMapping("/humanresource/{id}")
    public HumanResourcesDto update(@PathVariable Long id, @RequestBody HumanResourcesDto humanResourcesDto){
        return humanResourcesService.update(id, humanResourcesDto);
    }

    @DeleteMapping("/humanresource/removed/{id}")
    public void removed(@PathVariable Long id){
        humanResourcesService.removed(id);
    }

    @DeleteMapping("/humanresource/restore/{id}")
    public void restore(@PathVariable Long id){
        humanResourcesService.restore(id);
    }

    @DeleteMapping("/humanresource/{id}")
    public void delete(@PathVariable Long id){
        humanResourcesService.delete(id);
    }

}
