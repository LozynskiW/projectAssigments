package pl.sda.projectassigments.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.sda.projectassigments.model.assignment.AssignmentModel;
import pl.sda.projectassigments.model.assignment.AssignmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentRepository assignmentRepository;

    public void addNewAssignment(String title, Long userId, String desc) {

        if (userId == null) {
            userId = -1L;

        }

        AssignmentModel assignmentModel = AssignmentModel.builder()
                .title(title)
                .userId(userId)
                .description(desc)
                .build();

        assignmentRepository.create(assignmentModel);

    }

    public String getDescriptionOfAssignmentById(Long id) {

        Optional<AssignmentModel> assignment = assignmentRepository.getById(id);

        if (assignment.isPresent()) {
            return assignment.get().getDescription();
        }

        return "";
    }

    public List<String> getAllAssignments() {

        List<String> output = new ArrayList<>();

        List<AssignmentModel> assignments = assignmentRepository.getAll();

        return  assignments.stream().map(a -> a.getId().toString()+" "+a.getTitle()+" "+a
                .getUserId()).collect(Collectors.toList());

    }

}
