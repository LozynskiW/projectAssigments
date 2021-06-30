package pl.sda.projectassigments.view.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.controller.AssignmentController;
import pl.sda.projectassigments.view.DefaultView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListAssignmentsView implements DefaultView {

    private final AssignmentController assignmentController;
    private final UserInputScanner scanner;


    @Override
    public void display() {
        System.out.println("List of assignments:");
        System.out.println("Assignment ID | Assignment title | User ID");

        List<String> assignments = assignmentController.getAllAssignments();

        assignments.forEach(System.out::println);
    }
}
