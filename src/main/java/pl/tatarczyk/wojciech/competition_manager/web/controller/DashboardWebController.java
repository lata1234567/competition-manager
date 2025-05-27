package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardWebController {

    private static final Logger LOGGER  = Logger.getLogger(DashboardWebController.class.getName());

    @GetMapping
    public String dashboardView(){
        LOGGER.info("dashboardView()");

        return "/dashboard/dashboard";
    }
}
