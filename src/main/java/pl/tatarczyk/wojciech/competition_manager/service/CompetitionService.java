package pl.tatarczyk.wojciech.competition_manager.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojciech.competition_manager.api.exception.CompetitionNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.repository.CompetitionRepository;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;
import pl.tatarczyk.wojciech.competition_manager.service.mapper.CompetitionMapper;
import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CompetitionService {

    private static final Logger LOGGER = Logger.getLogger(CompetitionService.class.getName());

    private CompetitionRepository competitionRepository;
    private CompetitionMapper competitionMapper;

    public CompetitionService(CompetitionRepository competitionRepository, CompetitionMapper competitionMapper) {
        this.competitionRepository = competitionRepository;
        this.competitionMapper = competitionMapper;
    }

    public List<CompetitionModel> list(){
        LOGGER.info("list()");

        List<CompetitionEntity> competitionEntities = competitionRepository.findAll();

        LOGGER.info("entities = " + competitionEntities);

        List<CompetitionModel> competitionModels = competitionMapper.fromEntities(competitionEntities);

        LOGGER.info("list(...) = " + competitionModels);
        return competitionModels;
    }

    public CompetitionModel create(CompetitionModel competitionModel){
        LOGGER.info("create("+competitionModel+")");

        CompetitionEntity mappedCompetitionEntity = competitionMapper.from(competitionModel);
        CompetitionEntity savedCompetitionEntity = competitionRepository.save(mappedCompetitionEntity);

        CompetitionModel savedCompetitionModel = competitionMapper.form(savedCompetitionEntity);
        LOGGER.info("create(...) = " + savedCompetitionModel);
        return savedCompetitionModel;

    }

    public CompetitionModel read(Long id) throws CompetitionNotFoundException{
        LOGGER.info("read("+id+")");

        Optional<CompetitionEntity> optionalCompetitionEntity = competitionRepository.findById(id);
        CompetitionEntity competitionEntity = optionalCompetitionEntity.orElseThrow(
                ()-> new CompetitionNotFoundException("Not found competition with id " + id)
        );
        CompetitionModel competitionModel = competitionMapper.form(competitionEntity);
        LOGGER.info("read(...) = " + competitionModel);
        return competitionModel;
    }

    public CompetitionModel update(CompetitionModel competitionModel){
        LOGGER.info("update("+competitionModel+")");

        CompetitionEntity mappedCompetitionEntity = competitionMapper.from(competitionModel);
        CompetitionEntity updateCompetitionEntity = competitionRepository.save(mappedCompetitionEntity);

        return competitionMapper.form(updateCompetitionEntity);
    }

    public void delete(Long id){
        LOGGER.info("delete("+id+")");
        competitionRepository.deleteById(id);
    }
}
