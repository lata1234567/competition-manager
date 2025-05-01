package pl.tatarczyk.wojciech.competition_manager.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.ApplicationEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.ApplicationModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class ApplicationMapper {

    private static final Logger LOGGER = Logger.getLogger(ApplicationMapper.class.getName());

    public ApplicationEntity from(ApplicationModel applicationModel){
        LOGGER.info("from("+applicationModel+")");
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ApplicationEntity applicationEntity = modelMapper.map(applicationModel, ApplicationEntity.class);

        LOGGER.info("from(...) = " + applicationEntity);
        return applicationEntity;
    }

    public ApplicationModel from(ApplicationEntity applicationEntity){
        LOGGER.info("from("+applicationEntity+")");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        ApplicationModel applicationModel = modelMapper.map(applicationEntity, ApplicationModel.class);

        LOGGER.info("from(...) = " + applicationModel);
        return applicationModel;
    }

    public List<ApplicationEntity> fromModels(List<ApplicationModel> models){
        LOGGER.info("fromModels("+models+")");
        return models.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public List<ApplicationModel> fromEntities(List<ApplicationEntity> entities){
        LOGGER.info("fromEntities("+entities+")");
        return entities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
