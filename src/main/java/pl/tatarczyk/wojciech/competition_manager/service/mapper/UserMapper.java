package pl.tatarczyk.wojciech.competition_manager.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.UserEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.UserModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final static Logger LOGGER = Logger.getLogger(UserMapper.class.getName());

    public UserEntity from(UserModel userModel){
        LOGGER.info("from("+userModel+")");
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userModel, UserEntity.class);

        LOGGER.info("from(...) = " + userEntity);
        return userEntity;
    }

    public UserModel from(UserEntity userEntity) {
        LOGGER.info("from("+userEntity+")");
        ModelMapper modelMapper = new ModelMapper();
        UserModel userModel = modelMapper.map(userEntity, UserModel.class);

        LOGGER.info("from(...) = " + userModel);
        return userModel;
    }

    public List<UserEntity> fromModels(List<UserModel> models){
        LOGGER.info("fromModels("+models+")");
        return models.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<UserModel> formEntities(List<UserEntity> entities){
        LOGGER.info("fromEntities("+entities+")");
        return entities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

}
