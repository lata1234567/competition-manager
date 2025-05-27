package pl.tatarczyk.wojciech.competition_manager.service.decorator;

import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.util.logging.Logger;

public class UserDecorator {

    public static final Logger LOGGER  = Logger.getLogger(UserDecorator.class.getName());

    public static String decorate(UserModel userModel){
        LOGGER.info("decorate("+userModel+")");
        String decoratedUser="";
        if(userModel!=null){
            if(userModel.getName()!=null){
                decoratedUser=userModel.getName();
            }
        }
        LOGGER.info("decorate(...) = " + decoratedUser);
        return decoratedUser;
    }
}
