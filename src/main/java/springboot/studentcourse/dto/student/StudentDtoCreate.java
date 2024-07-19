package springboot.studentcourse.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.entity.Student;
import vn.saolasoft.base.service.dto.DtoCreate;
import vn.saolasoft.base.service.dto.SerialIDDtoCreate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoCreate extends SerialIDDtoCreate<Student> {

    private String firstName;
    private String lastName;
    private Course course;

    @Override
    public Student toEntry() {
        Student student = new Student();
        student.setId(this.getId());
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setCourse(course);
        return student;
    }
}
