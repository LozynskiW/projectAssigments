package pl.sda.projectassigments.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.sda.projectassigments.model.assignment.AssignmentModel;
import pl.sda.projectassigments.model.assignment.AssignmentRepository;
import pl.sda.projectassigments.model.user.UserModel;
import pl.sda.projectassigments.model.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;

    public void addNewUser(String name, String surname, String email) {

        UserModel user = new UserModel(name, surname, email);

        userRepository.create(user);
    }

    public List<UserModel> getAllUsers() {

        return userRepository.getAll();
    }

    public void deleteUserById(Long id) {

        userRepository.deleteById(id);
    }

    public List<String> getAllAssignmentsForUser(Long id) {

        List<String> output = new ArrayList<>();

        Optional<UserModel> userCheck = userRepository.getById(id);

        if (userCheck.isEmpty()) return output;

        List<AssignmentModel> assignments = assignmentRepository.getAll();

        assignments = assignments.stream().filter(a -> a.getUserId().equals(id))
                .collect(Collectors.toList());

        return assignments.stream().map(a -> a.getId().toString()+" "+a.getTitle()+" "+a.getDescription())
                .collect(Collectors.toList());

    }

}
