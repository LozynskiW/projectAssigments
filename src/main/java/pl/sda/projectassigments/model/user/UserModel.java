package pl.sda.projectassigments.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
public class UserModel {

    private Long id;
    private String name;
    private String surname;
    private String email;

    public UserModel(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return  id.toString() + ';' + name + ';' + surname + ';' + email;
    }
}
