package pl.tatarczyk.wojciech.competition_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojciech.competition_manager.repository.entity.CompetitionEntity;

@Repository
public interface CompetitionRepository extends JpaRepository<CompetitionEntity, Long> {
}
