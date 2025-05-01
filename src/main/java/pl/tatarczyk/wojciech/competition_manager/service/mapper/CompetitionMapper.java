package pl.tatarczyk.wojciech.competition_manager.service.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
public class CompetitionMapper {

    private static final Logger LOGGER = Logger.getLogger(CompetitionMapper.class.getName());

    public CompetitionModel form(CompetitionEntity competitionEntity){
        LOGGER.info("from("+competitionEntity+")");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompetitionModel competitionModel = modelMapper.map(competitionEntity,CompetitionModel.class);

        LOGGER.info("from(...) = " + competitionModel);
        return competitionModel;
    }

    public CompetitionEntity from(CompetitionModel competitionModel){
        LOGGER.info("from("+competitionModel+")");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CompetitionEntity competitionEntity = modelMapper.map(competitionModel, CompetitionEntity.class);

        LOGGER.info("from(...) = " + competitionEntity);
        return competitionEntity;
    }

    public List<CompetitionModel> fromEntities(List<CompetitionEntity> competitionEntities){
        LOGGER.info("fromEntities("+ competitionEntities+")");

        return competitionEntities.stream()
                .map(this::form)
                .collect(Collectors.toList());
    }

    public List<CompetitionEntity> fromModels(List<CompetitionModel> competitionModels){
        LOGGER.info("fromModels("+competitionModels+")");

        return competitionModels.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
}
