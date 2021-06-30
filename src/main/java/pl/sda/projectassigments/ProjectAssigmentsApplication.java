package pl.sda.projectassigments;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.projectassigments.view.MenuView;

@SpringBootApplication
@RequiredArgsConstructor
public class ProjectAssigmentsApplication implements CommandLineRunner {

    private final MenuView menuView;

    public static void main(String[] args) {

        SpringApplication.run(ProjectAssigmentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menuView.display();
    }
}
