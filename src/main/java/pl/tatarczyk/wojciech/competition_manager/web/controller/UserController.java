package pl.tatarczyk.wojciech.competition_manager.web.controller;

import org.springframework.web.bind.annotation.*;
import pl.tatarczyk.wojciech.competition_manager.api.exception.UserNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.service.UserService;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> list(){
        LOGGER.info("list()");
        return userService.list();
    }

    @PostMapping
    public UserModel create(@RequestBody UserModel userModel){
        LOGGER.info("create("+userModel+")");
        return userService.create(userModel);
    }

    @GetMapping(value = "/id")
    public UserModel read(@PathVariable("id") Long id) throws UserNotFoundException {
        LOGGER.info("read("+id+")");
        return userService.read(id);
    }

    @PutMapping
    public UserModel update(@RequestBody UserModel userModel){
        LOGGER.info("update("+userModel+")");
        return userService.update(userModel);
    }

    @DeleteMapping
    public void delete(){
        LOGGER.info("delete()");
    }
}
