package pl.sda.projectassigments.model.user;

import org.springframework.beans.factory.annotation.Qualifier;
import pl.sda.projectassigments.config.FileOutputReader;
import pl.sda.projectassigments.config.FileOutputWriter;
import pl.sda.projectassigments.model.Repository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Repository
public class UserRepository implements Repository<UserModel>{

    private final FileOutputWriter fileWriter;
    private final FileOutputReader fileReader;

    public UserRepository(@Qualifier("userFileWriter") FileOutputWriter fileWriter, @Qualifier("userFileReader") FileOutputReader fileReader) {
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
    }

    private void writeToFile(UserModel user) throws IOException {

        String userToSave = user.toString();

        fileWriter.writeToFile(userToSave);
    }


    @Override
    public List<UserModel> getAll() {

        List<UserModel> users = new ArrayList<>();
        List<String> usersFromFile;
        String[] lineSplitted = new String[4];

        try {
            usersFromFile = fileReader.readAllLinesFromFile();
        } catch (IOException err) {
            return users;
        }

        for (String line : usersFromFile) {

            lineSplitted = line.split(";");
            users.add(new UserModel(Long.valueOf(lineSplitted[0]), lineSplitted[1], lineSplitted[2], lineSplitted[3]));
        }

        return users;
    }

    @Override
    public Optional<UserModel> getById(Long id) {

        List<UserModel> allUsers = this.getAll();

        return allUsers.stream().filter(u -> u.getId().equals(id)).findFirst();

    }

    @Override
    public void create(UserModel user) {

        user.setId(this.determineId());

        try {

            this.writeToFile(user);

        } catch (IOException err) {

            err.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {

        List<UserModel> users = this.getAll();

        List<UserModel> usersAfterDeleting = users.stream()
                .filter(user -> !user.getId().equals(id))
                .collect(Collectors.toList());

        fileWriter.deleteAll();

        usersAfterDeleting.forEach(user -> {
            try {
                this.fileWriter.writeToFile(user.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void update(UserModel object) {

    }

    private Long determineId() {
        List<UserModel> users = this.getAll();

        if (users.size() >= 1) {
            UserModel lastUser = users.get(users.size()-1);
            return lastUser.getId() + 1;
        } else {
            return 1L;
        }
    }
}
