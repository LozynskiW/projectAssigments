package pl.sda.projectassigments.config;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Setter
@Getter
@NoArgsConstructor
public class UserInputScanner {

    private final Scanner scanner = new Scanner(System.in);

    public String scanUserInput() {
        return scanner.nextLine();
    }
}
