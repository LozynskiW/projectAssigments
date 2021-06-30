package pl.sda.projectassigments.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projectassigments.config.UserInputScanner;
import pl.sda.projectassigments.view.assignment.AddAssignmentView;
import pl.sda.projectassigments.view.assignment.AssignmentDetailsView;
import pl.sda.projectassigments.view.assignment.ListAssignmentsView;
import pl.sda.projectassigments.view.user.AddUserView;
import pl.sda.projectassigments.view.user.AllAssignmentsForUserView;
import pl.sda.projectassigments.view.user.DeleteUserView;
import pl.sda.projectassigments.view.user.ListAllUsersView;

@Component
@RequiredArgsConstructor
public class MenuView implements DefaultView{

    private final UserInputScanner userInputScanner;
    private final AddUserView addUserView;
    private final ListAllUsersView listAllUsersView;
    private final DeleteUserView deleteUserView;
    private final AllAssignmentsForUserView allAssignmentsForUserView;
    private final AddAssignmentView addAssignmentView;
    private final AssignmentDetailsView assignmentDetailsView;
    private final ListAssignmentsView listAssignmentsView;

    @Override
    public void display() {

        int action;

        while (true) {

            System.out.println();
            System.out.println("1. Show all users | 2. Add new user | 3. Delete user by id | 4. Assignments for user");
            System.out.println("5. Show all assignments | 6. Add new assignment | 7. Assignments details | 8 or else. Exit");
            System.out.println();

            try {
                action = Integer.valueOf(userInputScanner.scanUserInput());
            } catch (IllegalStateException | NumberFormatException err) {
                action = 8;
            }

            switch (action) {
                case 1:
                    listAllUsersView.display();
                    break;

                case 2:
                    addUserView.display();
                    break;

                case 3:
                    deleteUserView.display();
                    break;

                case 4:
                    allAssignmentsForUserView.display();
                    break;

                case 5:
                    listAssignmentsView.display();
                    break;

                case 6:
                    addAssignmentView.display();
                    break;

                case 7:
                    assignmentDetailsView.display();
                    break;

                default:
                    System.out.println("Goodbye");
                    break;
            }

            if (action == 8) {
                break;
            }

        }
    }
}
