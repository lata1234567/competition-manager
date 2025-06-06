package pl.tatarczyk.wojciech.competition_manager.service;

import org.springframework.stereotype.Service;
import pl.tatarczyk.wojciech.competition_manager.api.exception.ApplicationNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.api.exception.CompetitionNotFoundException;
import pl.tatarczyk.wojciech.competition_manager.repository.ApplicationRepository;
import pl.tatarczyk.wojciech.competition_manager.repository.CompetitionRepository;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.ApplicationEntity;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;
import pl.tatarczyk.wojciech.competition_manager.service.mapper.ApplicationMapper;
import pl.tatarczyk.wojciech.competition_manager.web.model.ApplicationModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ApplicationService {

    private static final Logger LOGGER = Logger.getLogger(ApplicationService.class.getName());

    private ApplicationRepository applicationRepository;
    private ApplicationMapper applicationMapper;
    private CompetitionRepository competitionRepository;

    public ApplicationService(ApplicationRepository applicationRepository, ApplicationMapper applicationMapper, CompetitionRepository competitionRepository) {
        this.applicationRepository = applicationRepository;
        this.applicationMapper = applicationMapper;
        this.competitionRepository = competitionRepository;
    }

    public List<ApplicationModel> list(){
        LOGGER.info("list()");

        List<ApplicationEntity> applicationEntities = applicationRepository.findAll();

        LOGGER.info("entities = " + applicationEntities);

        List<ApplicationModel> applicationModels = applicationMapper.fromEntities(applicationEntities);
        LOGGER.info("list(...) = " + applicationModels);
        return applicationModels;
    }

    public ApplicationModel create(ApplicationModel applicationModel) throws CompetitionNotFoundException{
        LOGGER.info("create("+applicationModel+")");

        applicationModel.setCreatedDate(LocalDate.now());

        ApplicationEntity mappedApplicationEntity = applicationMapper.from(applicationModel);

        Long competitionId = applicationModel.getCompetition().getId();
        Optional<CompetitionEntity> optionalCompetitionEntity = competitionRepository.findById(competitionId);
        CompetitionEntity competitionEntity = optionalCompetitionEntity.orElseThrow(
                ()-> new CompetitionNotFoundException("not found competition with id = " + competitionId)
        );

        mappedApplicationEntity.setCompetition(competitionEntity);
        ApplicationEntity savedApplicationEntity = applicationRepository.save(mappedApplicationEntity);

        ApplicationModel savedApplicationModel = applicationMapper.from(savedApplicationEntity);
        LOGGER.info("create(...) = " + savedApplicationModel);
        return savedApplicationModel;
    }

    public ApplicationModel read(Long id) throws ApplicationNotFoundException {
        LOGGER.info("read("+id+")");

        Optional<ApplicationEntity> optionalApplicationEntity = applicationRepository.findById(id);
        ApplicationEntity applicationEntity = optionalApplicationEntity.orElseThrow(
                ()->new ApplicationNotFoundException("Not found application with id " + id)
        );

        ApplicationModel applicationModel = applicationMapper.from(applicationEntity);

        LOGGER.info("read(...) = " + applicationModel);
        return applicationModel;

    }

    public ApplicationModel update(ApplicationModel applicationModel){
        LOGGER.info("update("+applicationModel+")");

        ApplicationEntity mappedApplicationEntity = applicationMapper.from(applicationModel);
        ApplicationEntity updatedApplicationEntity = applicationRepository.save(mappedApplicationEntity);

        ApplicationModel updatedApplicationModel = applicationMapper.from(updatedApplicationEntity);
        LOGGER.info("update(...) = " + updatedApplicationModel);
        return updatedApplicationModel;
    }

    public void delete(Long id){
        LOGGER.info("delete("+id+")");
        applicationRepository.deleteById(id);
    }
}
