package springboot.studentcourse.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.entity.Student;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoUpdate extends DtoUpdate<Student, Long> {

    private Long id;
    private String firstName;
    private String lastName;
    private Course course;

    @Override
    public boolean apply(Student student) {
        boolean modified = false;
        if (!Objects.equals(this.firstName, student.getFirstName())) {
            student.setFirstName(this.firstName);
            modified = true;
        }
        if (!Objects.equals(this.lastName, student.getLastName())) {
            student.setLastName(this.lastName);
            modified = true;
        }
        if ((!Objects.equals(this.course.getId(), student.getCourse().getId())) ||
                (!Objects.equals(this.course.getCourseName(), student.getCourse().getCourseName())) ||
                (!Objects.equals(this.course.getTitle(), student.getCourse().getTitle()))) {
            student.setCourse(this.course);
            modified = true;
        }
        return modified;
    }
}
