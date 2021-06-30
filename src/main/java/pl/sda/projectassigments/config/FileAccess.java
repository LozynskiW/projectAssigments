package pl.sda.projectassigments.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.File;

@Getter
@Setter
@RequiredArgsConstructor
public class FileAccess {

    private final String filepath;

    File getFile() {
        return new File(filepath);
    }
}
