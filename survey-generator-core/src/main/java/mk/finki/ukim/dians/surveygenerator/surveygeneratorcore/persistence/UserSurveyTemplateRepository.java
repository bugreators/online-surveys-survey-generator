package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.UserSurveyTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSurveyTemplateRepository extends JpaRepository<UserSurveyTemplate, Long> {
}
