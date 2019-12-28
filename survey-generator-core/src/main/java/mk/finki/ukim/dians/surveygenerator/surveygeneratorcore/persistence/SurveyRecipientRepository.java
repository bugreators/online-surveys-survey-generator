package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.SurveyRecipient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.image.LookupOp;

public interface SurveyRecipientRepository extends JpaRepository<SurveyRecipient, Long> {
}
