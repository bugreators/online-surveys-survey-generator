package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
