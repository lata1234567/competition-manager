package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.web.bind.annotation.*;
import pl.tatarczyk.wojciech.competition_manager.api.exception.ApplicationNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.api.exception.CompetitionNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.service.ApplicationService;
import pl.tatarczyk.wojciech.competition_manager.web.model.ApplicationModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private static final Logger LOGGER  = Logger.getLogger(ApplicationController.class.getName());

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<ApplicationModel> list(){
        LOGGER.info("list()");
        return applicationService.list();
    }

    @PostMapping
    public ApplicationModel create(@RequestBody ApplicationModel applicationModel) throws CompetitionNotFoundException {
        LOGGER.info("create("+applicationModel+")");
        return applicationService.create(applicationModel);
    }

    @GetMapping(value = "/id")
    public ApplicationModel read(@PathVariable("id") Long id) throws ApplicationNotFoundException {
        LOGGER.info("read("+id+")");
        return applicationService.read(id);
    }

    @PutMapping
    public ApplicationModel update(@RequestBody ApplicationModel applicationModel){
        LOGGER.info("update("+applicationModel+")");
        return applicationService.update(applicationModel);
    }

    @DeleteMapping
    public void delete(){
        LOGGER.info("delete()");
    }
}
