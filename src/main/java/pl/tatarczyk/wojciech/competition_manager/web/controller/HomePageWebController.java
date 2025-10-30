package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping
public class HomePageWebController {
    private static final Logger LOGGER = Logger.getLogger(HomePageWebController.class.getName());

    @GetMapping(value = "/")
    public String homePageView() {
        LOGGER.info("homePageView()");

        return "homePage/homePage";
    }
}
