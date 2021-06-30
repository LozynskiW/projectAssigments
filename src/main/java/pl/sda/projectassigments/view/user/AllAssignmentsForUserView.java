package pl.sda.projectassigments.view.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.controller.AssignmentController;
import pl.sda.projectassigments.controller.UserController;
import pl.sda.projectassigments.view.DefaultView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AllAssignmentsForUserView implements DefaultView {

    private final UserController userController;
    private final UserInputScanner scanner;

    @Override
    public void display() {
        System.out.println("Id of user to check assignments: ");

        Long userId = Long.valueOf(scanner.scanUserInput());

        List<String> assignmentsForUser = userController.getAllAssignmentsForUser(userId);

        if (assignmentsForUser.size() >0) {
            assignmentsForUser.forEach(System.out::println);
        } else {
            System.out.println("No such user or no assignments");
        }
    }
}
