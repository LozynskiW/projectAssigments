package pl.sda.projectassigments.config;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Setter
@Getter
public class FileOutputReader {

    private Scanner fileReader;
    private File file;

    public FileOutputReader(File file) {
        this.file = file;
    }

    public List<String> readAllLinesFromFile() throws IOException {

        fileReader = new Scanner(file.getAbsoluteFile());

        List<String> output = new ArrayList<>();

        while (fileReader.hasNext()) {
            output.add(fileReader.nextLine());
        }

        return output;
    }

}
