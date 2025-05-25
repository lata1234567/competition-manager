package pl.tatarczyk.wojciech.competition_manager.web.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tatarczyk.wojciech.competition_manager.api.exception.UserNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.service.UserService;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
public class UserWebController {
    private static final Logger LOGGER = Logger.getLogger(UserWebController.class.getName());

    private UserService userService;

    public UserWebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public  String list(Model model){
        LOGGER.info("list()");
        List<UserModel> users = userService.list();
        model.addAttribute("users",users);
        return "users/list";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap){
        LOGGER.info("createView()");

//        UserModel userModel = new UserModel();

        modelMap.addAttribute("userModel", new UserModel());

        return "users/create";
    }

    @PostMapping
    public String create(@ModelAttribute UserModel userModel){
        LOGGER.info("create("+userModel+")");

        userService.create(userModel);

        return "redirect:/users";
    }

    @GetMapping(value = "/{id}")
    public UserModel read(@PathVariable("id") Long id) throws UserNotFoundException{
        LOGGER.info("read()");

        return userService.read(id);
    }


    @GetMapping(value = "/update/{id}")
    public String updateView(ModelMap modelMap, @PathVariable("id") Long id) throws UserNotFoundException{
        LOGGER.info("updateView("+id+")");

        UserModel userModel = userService.read(id);

        modelMap.addAttribute("userModel", userModel);

        return "users/update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute UserModel userModel){
        LOGGER.info("update("+userModel+")");

        userService.update(userModel);

        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        LOGGER.info("delete()");
        userService.delete(id);
        return "redirect:/users";
    }
}
