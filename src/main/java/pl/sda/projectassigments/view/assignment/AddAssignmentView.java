package pl.sda.projectassigments.view.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.controller.AssignmentController;
import pl.sda.projectassigments.model.assignment.AssignmentModel;
import pl.sda.projectassigments.model.assignment.AssignmentRepository;
import pl.sda.projectassigments.model.user.UserModel;
import pl.sda.projectassigments.model.user.UserRepository;
import pl.sda.projectassigments.view.DefaultView;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AddAssignmentView implements DefaultView {

    private final AssignmentController assignmentController;
    private final UserInputScanner scanner;

    @Override
    public void display() {
        String title;
        long userId;
        String desc;

        System.out.println("Assignment title:");
        title = scanner.scanUserInput();

        System.out.println("User id:");
        userId = Long.parseLong(scanner.scanUserInput());

        System.out.println("Assignment description:");
        desc = scanner.scanUserInput();

        assignmentController.addNewAssignment(title, userId, desc);
    }
}
