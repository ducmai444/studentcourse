package springboot.studentcourse.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Student;
import vn.saolasoft.base.service.dto.DtoGet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoGet extends DtoGet<Student, Long> {

    private Long id;
    private String firstName;
    private String lastName;
    private String courseName;

    @Override
    public void parse(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.courseName = student.getCourse().getCourseName();
    }
}
