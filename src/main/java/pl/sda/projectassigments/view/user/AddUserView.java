package pl.sda.projectassigments.view.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.model.user.UserModel;
import pl.sda.projectassigments.model.user.UserRepository;
import pl.sda.projectassigments.view.DefaultView;

@Component
@RequiredArgsConstructor
public class AddUserView implements DefaultView {

    private final UserRepository userRepository;
    private final UserInputScanner scanner;

    @Override
    public void display() {
        String name;
        String surname;
        String email;

        System.out.println("User name:");
        name = scanner.scanUserInput();

        System.out.println("User surname:");
        surname = scanner.scanUserInput();

        System.out.println("User email:");
        email = scanner.scanUserInput();

        userRepository.create(new UserModel(name, surname, email));
    }
}
