package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
}
