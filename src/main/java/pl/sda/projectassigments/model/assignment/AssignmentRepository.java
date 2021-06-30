package pl.sda.projectassigments.model.assignment;

import org.springframework.beans.factory.annotation.Qualifier;

import pl.sda.projectassigments.config.FileOutputReader;
import pl.sda.projectassigments.config.FileOutputWriter;
import pl.sda.projectassigments.model.Repository;
import pl.sda.projectassigments.model.user.UserModel;
import pl.sda.projectassigments.model.user.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class AssignmentRepository implements Repository<AssignmentModel> {

    private final FileOutputWriter fileWriter;
    private final FileOutputReader fileReader;
    private final UserRepository userRepository;

    public AssignmentRepository(@Qualifier("assignmentFileWriter") FileOutputWriter fileWriter,
                                @Qualifier("assignmentFileReader") FileOutputReader fileReader,
                                UserRepository userRepository) {

        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
        this.userRepository = userRepository;
    }

    @Override
    public List<AssignmentModel> getAll() {

        List<AssignmentModel> assignments = new ArrayList<>();
        List<String> assignmentsFromFile;
        String[] lineSplitted = new String[4];

        try {
            assignmentsFromFile = fileReader.readAllLinesFromFile();
        } catch (IOException err) {
            return assignments;
        }

        for (String line : assignmentsFromFile) {

            lineSplitted = line.split(";");
            assignments.add(new AssignmentModel(Long.valueOf(lineSplitted[0]), lineSplitted[1],
                    Long.valueOf(lineSplitted[2]), lineSplitted[3]));
        }

        return assignments;
    }

    @Override
    public Optional<AssignmentModel> getById(Long id) {

        List<AssignmentModel> assignments = new ArrayList<>();

        assignments = this.getAll();

        return assignments.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public void create(AssignmentModel assignment) {

        assignment.setId(this.determineId());

        List<UserModel> users = userRepository.getAll();

        Optional<UserModel> userIdCheck = users.stream().filter(u -> u.getId().equals(assignment.getUserId()))
                .findFirst();

        if (userIdCheck.isEmpty()) assignment.setUserId(-1L);

        try {

            this.writeToFile(assignment);

        } catch (IOException err) {

            err.printStackTrace();
        }

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(AssignmentModel object) {

    }

    private void writeToFile(AssignmentModel assignment) throws IOException {

        String assignmentToSave = assignment.toString();

        fileWriter.writeToFile(assignmentToSave);
    }

    private Long determineId() {

        List<AssignmentModel> assignments = this.getAll();

        if (assignments.size() >= 1) {
            AssignmentModel lastAssignment = assignments.get(assignments.size()-1);
            return lastAssignment.getId() + 1;
        } else {
            return 1L;
        }
    }
}
