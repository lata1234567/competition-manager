package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.tatarczyk.wojciech.competition_manager.api.exception.ApplicationNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.api.exception.CompetitionNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.service.ApplicationService;
import pl.tatarczyk.wojciech.competition_manager.service.CompetitionService;
import pl.tatarczyk.wojciech.competition_manager.service.UserService;
import pl.tatarczyk.wojciech.competition_manager.web.model.ApplicationModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/applications")
public class ApplicationWebController {

    private static final Logger LOGGER = Logger.getLogger(ApplicationWebController.class.getName());

    private ApplicationService applicationService;
    private CompetitionService competitionService;
    private UserService userService;

    public ApplicationWebController(ApplicationService applicationService, CompetitionService competitionService, UserService userService) {
        this.applicationService = applicationService;
        this.competitionService = competitionService;
        this.userService = userService;
    }


    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        List<ApplicationModel> applications = applicationService.list();
        modelMap.addAttribute("applications", applications);
        return "applications/list";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("applicationModel", new ApplicationModel());
        modelMap.addAttribute("competitions", competitionService.list());
        modelMap.addAttribute("users", userService.list());

        return "applications/create";
    }

    @PostMapping
    public String create(@ModelAttribute ApplicationModel applicationModel) throws CompetitionNotFoundException {
        LOGGER.info("create(" + applicationModel + ")");

        applicationService.create(applicationModel);

        return "redirect:/applications";
    }

    @GetMapping(value = "/{id}")
    public ApplicationModel read(@PathVariable("id") Long id) throws ApplicationNotFoundException {
        LOGGER.info("read(" + id + ")");
        return applicationService.read(id);
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable("id") Long id, ModelMap modelMap) throws ApplicationNotFoundException {
        LOGGER.info("updateView(" + id + ")");
        ApplicationModel applicationModel = applicationService.read(id);

        modelMap.addAttribute("applicationModel", applicationModel);
        modelMap.addAttribute("users", userService.list());
        modelMap.addAttribute("competitions", competitionService.list());

        return "applications/update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute ApplicationModel applicationModel) {
        LOGGER.info("update(" + applicationModel + ")");
        applicationService.update(applicationModel);
        return "redirect:/applications";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        LOGGER.info("delete(" + id + ")");
        applicationService.delete(id);
        return "redirect:/applications";
    }
}
