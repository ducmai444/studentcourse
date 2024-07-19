package springboot.studentcourse.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Teacher;
import vn.saolasoft.base.service.dto.DtoCreate;
import vn.saolasoft.base.service.dto.SerialIDDtoCreate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDtoCreate extends SerialIDDtoCreate<Teacher> {

    private String firstName;
    private String lastName;
    private String email;

    @Override
    public Teacher toEntry() {
        Teacher teacher = new Teacher();
        teacher.setId(this.getId());
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setEmail(email);
        return teacher;
    }
}
