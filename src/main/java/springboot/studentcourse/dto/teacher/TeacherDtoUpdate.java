package springboot.studentcourse.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Teacher;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDtoUpdate extends DtoUpdate<Teacher, Long> {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public boolean apply(Teacher teacher) {
        boolean modified = false;
        if (!Objects.equals(this.firstName, teacher.getFirstName())) {
            teacher.setFirstName(this.firstName);
            modified = true;
        }
        if (!Objects.equals(this.lastName, teacher.getLastName())) {
            teacher.setLastName(this.lastName);
            modified = true;
        }
        if (!Objects.equals(this.email, teacher.getEmail())) {
            teacher.setEmail(this.email);
            modified = true;
        }
        return modified;
    }
}
