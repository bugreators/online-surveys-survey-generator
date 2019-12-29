package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyTemplateRepository extends JpaRepository<SurveyTemplate, Long> {
}
