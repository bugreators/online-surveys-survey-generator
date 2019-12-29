package mk.finki.ukim.dians.surveygenerator.surveygeneratorcore.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserCreateRequest {

    private String username;

    private String email;

    private String password;

    public UserCreateRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserCreateRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
