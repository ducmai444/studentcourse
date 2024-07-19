package springboot.studentcourse.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Teacher;
import vn.saolasoft.base.service.dto.DtoGet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDtoGet extends DtoGet<Teacher, Long> {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public void parse(Teacher teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
        this.email = teacher.getEmail();
    }
}
