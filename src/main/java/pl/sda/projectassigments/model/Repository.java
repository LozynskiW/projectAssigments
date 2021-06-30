package pl.sda.projectassigments.model;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface Repository <T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void create(T object) throws IOException;

    void deleteById(Long id);

    void update(T object);
}
