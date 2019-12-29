package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.QuestionAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswersRepository extends JpaRepository<QuestionAnswers, Long> {
}
