package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.SurveyRecipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRecipientRepository extends JpaRepository<SurveyRecipient, Long> {
}
