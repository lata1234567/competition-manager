package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.web.bind.annotation.*;
import pl.tatarczyk.wojciech.competition_manager.api.exception.CompetitionNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.service.CompetitionService;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/competitions")
public class CompetitionController {

    private static final Logger LOGGER = Logger.getLogger(CompetitionController.class.getName());

    private CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<CompetitionModel> list(){
        LOGGER.info("list()");
        return competitionService.list();
    }

    @PostMapping
    public CompetitionModel create(@RequestBody CompetitionModel competitionModel){
        LOGGER.info("create("+competitionModel+")");
        return competitionService.create(competitionModel);
    }

    @GetMapping(value = "/id")
    public CompetitionModel read(@PathVariable("id") Long id) throws CompetitionNotFoundException {
        LOGGER.info("read("+id+")");
        return competitionService.read(id);
    }

    @PutMapping
    public CompetitionModel update(@RequestBody CompetitionModel competitionModel){
        LOGGER.info("update("+competitionModel+")");
        return competitionService.update(competitionModel);
    }

    @DeleteMapping
    public void delete(){
        LOGGER.info("delete()");
    }
}
