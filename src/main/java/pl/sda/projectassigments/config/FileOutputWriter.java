package pl.sda.projectassigments.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Setter
@Getter
public class FileOutputWriter {

    private File file;

    public FileOutputWriter(File file) {
        this.file = file;
    }

    public void writeToFile(String line) throws IOException {

        try (FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){

            System.out.println("Trying to save file, do not turn off");

            if (file.length()>0) {
                bufferedWriter.newLine();
            }
            bufferedWriter.write(line);


        } catch (IOException err) {
            System.out.println("File not saved");
            err.printStackTrace();
        }

    }

    public void deleteAll() {

        try{
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}
