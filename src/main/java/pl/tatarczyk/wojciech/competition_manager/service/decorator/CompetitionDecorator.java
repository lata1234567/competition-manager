package pl.tatarczyk.wojciech.competition_manager.service.decorator;

import pl.tatarczyk.wojciech.competition_manager.web.model.CompetitionModel;

import java.util.logging.Logger;

public class CompetitionDecorator {

    private static final Logger LOGGER = Logger.getLogger(CompetitionDecorator.class.getName());

    public static String decorate(CompetitionModel competitionModel){
        LOGGER.info("decorate("+competitionModel+")");
        String decoratedCompetition = "";
        if(competitionModel != null){
            if(competitionModel.getName()!=null){
                decoratedCompetition=competitionModel.getName();
            } else{
                decoratedCompetition="null n";
            }
        } else{
            decoratedCompetition="null c";
        }
        LOGGER.info("decorate(...) = " + decoratedCompetition);

        return decoratedCompetition;
    }
}
