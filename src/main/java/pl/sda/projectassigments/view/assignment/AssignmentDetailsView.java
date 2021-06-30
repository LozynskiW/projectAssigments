package pl.sda.projectassigments.view.assignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.controller.AssignmentController;
import pl.sda.projectassigments.view.DefaultView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AssignmentDetailsView implements DefaultView {

    private final AssignmentController assignmentController;
    private final UserInputScanner scanner;

    @Override
    public void display() {

        System.out.println("Id of assignment to check details:");

        Long id = Long.valueOf(scanner.scanUserInput());

        String assignmentDetails = assignmentController.getDescriptionOfAssignmentById(id);

        if (assignmentDetails.equals("")) System.out.println("No such assigment");
        else System.out.println(assignmentDetails);
    }
}
