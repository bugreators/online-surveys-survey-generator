package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.domain.jpamodels.User;
import mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.persistence.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/login")
    public Boolean login(@RequestBody UserLoginRequest user){
        User dbUser = repository.findByUsername(user.getUsername());
        return dbUser.getPassword().equals(user.getPassword());
    }

    @PostMapping(value = "/create")
    public User create (@RequestBody UserCreateRequest request) {
        return repository.save(new User(1L,request.getUsername(), request.getPassword(), request.getEmail()));
    }

}
