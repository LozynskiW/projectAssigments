package pl.sda.projectassigments.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;

@Configuration
@Setter
@Getter
public class MainIOConfig {

    @Value("${io.user.filepath}")
    private String userFilepath;

    @Value("${io.user.file}")
    private String userFile;

    @Value("${io.assignment.filepath}")
    private String assignmentFilepath;

    @Value("${io.assignment.file}")
    private String assignmentFile;

    @Bean(name = "userFileReader")
    public FileOutputReader getUserFileReader() {

        return new FileOutputReader(getUserFile().getFile());
    }

    @Bean(name = "userFileWriter")
    public FileOutputWriter getUserFileWriter() {

        return new FileOutputWriter(getUserFile().getFile());
    }

    @Bean(name = "assignmentFileReader")
    public FileOutputReader getAssignmentFileReader() {

        return new FileOutputReader(getAssignmentFile().getFile());
    }

    @Bean(name = "assignmentFileWriter")
    public FileOutputWriter getAssignmentFileWriter() {

        return new FileOutputWriter(getAssignmentFile().getFile());
    }

    @Bean
    public UserInputScanner getDataFromUser() {

        return new UserInputScanner();
    }

    @Bean
    public FileAccess getUserFile() {

        return new FileAccess(userFilepath+userFile);
    }

    @Bean
    public FileAccess getAssignmentFile() {

        return new FileAccess(assignmentFilepath+assignmentFile);
    }

}
