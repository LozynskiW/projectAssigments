package pl.sda.projectassigments.view.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.model.user.UserRepository;
import pl.sda.projectassigments.view.DefaultView;

@Component
@RequiredArgsConstructor
public class DeleteUserView implements DefaultView {

    private final UserRepository userRepository;
    private final UserInputScanner scanner;

    @Override
    public void display() {
        System.out.println("Id of user to delete:");

        Long userIdToDelete = Long.valueOf(scanner.scanUserInput());

        userRepository.deleteById(userIdToDelete);
    }
}
