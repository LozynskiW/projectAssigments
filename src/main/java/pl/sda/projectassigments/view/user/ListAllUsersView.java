package pl.sda.projectassigments.view.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.model.user.UserModel;
import pl.sda.projectassigments.model.user.UserRepository;
import pl.sda.projectassigments.view.DefaultView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListAllUsersView implements DefaultView {

    private final UserRepository userRepository;
    private List<UserModel> users;

    @Override
    public void display() {
        System.out.println("ALL USERS:");

        users = userRepository.getAll();

        users.forEach(System.out::println);
    }
}
