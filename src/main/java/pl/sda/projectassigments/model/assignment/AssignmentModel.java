package pl.sda.projectassigments.model.assignment;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Component
@Builder
public class AssignmentModel {

    private Long id;
    private String title;
    private Long userId;
    private String description;

    public AssignmentModel(String title, Long userId, String description) {
        this.title = title;
        this.userId = userId;
        this.description = description;
    }

    @Override
    public String toString() {
        return id.toString() + ";" + title + ";" + userId.toString() + ";" + description;
    }
}
