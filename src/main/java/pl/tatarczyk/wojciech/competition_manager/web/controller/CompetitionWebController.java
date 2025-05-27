package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.tatarczyk.wojciech.competition_manager.api.exception.CompetitionNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.service.CompetitionService;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/competitions")
public class CompetitionWebController {

    private static final Logger LOGGER = Logger.getLogger(CompetitionWebController.class.getName());

    private CompetitionService competitionService;

    public CompetitionWebController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public String list(ModelMap modelMap){
        LOGGER.info("list()");
        List<CompetitionModel> competitions = competitionService.list();
        modelMap.addAttribute("competitions", competitions);
        return "competitions/list";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("competitionModel", new CompetitionModel());

        return "competitions/create";
    }

    @PostMapping
    public String create(@ModelAttribute CompetitionModel competitionModel){
        LOGGER.info("create("+competitionModel+")");
        competitionService.create(competitionModel);
        return "redirect:/competitions";
    }

    @GetMapping(value = "/{id}")
    public CompetitionModel read(@PathVariable("id") Long id) throws CompetitionNotFoundException {
        LOGGER.info("read("+id+")");
        return competitionService.read(id);
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(ModelMap modelMap, @PathVariable("id") Long id) throws CompetitionNotFoundException{
        LOGGER.info("updateView("+id+")");
        CompetitionModel competitionModel = competitionService.read(id);

        modelMap.addAttribute("competitionModel", competitionModel);
        modelMap.addAttribute("deadlineDate", competitionModel.getDeadline());
        LOGGER.info("updateView(...)");
        return "competitions/update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute CompetitionModel competitionModel){
        LOGGER.info("update("+competitionModel+")");
        competitionService.update(competitionModel);
        return "redirect:/competitions";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        LOGGER.info("delete("+id+")");
        competitionService.delete(id);
        return "redirect:/competitions";
    }
}
