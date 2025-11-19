package pl.tatarczyk.wojciech.competition_manager.service.decorator;

import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.util.logging.Logger;

public class UserLoginDecorator {
    private static final Logger LOGGER = Logger.getLogger(UserLoginDecorator.class.getName());

    public static String decorate(UserEntity userEntity){
        LOGGER.info("decorate("+userEntity+")");
        String decoratedUserLogin="";
        if(userEntity!=null){
            if(userEntity.getName()!=null){
                decoratedUserLogin=userEntity.getLogin();
            }
        }
        LOGGER.info("decorate(...) = " + decoratedUserLogin);
        return decoratedUserLogin;
    }
}
