package springboot.studentcourse.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.entity.Teacher;
import springboot.studentcourse.repository.TeacherRepository;
import vn.saolasoft.base.service.dto.DtoUpdate;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDtoUpdate extends DtoUpdate<Course, Long> {

    private Long id;
    private String courseName;
    private String title;
    private Teacher teacher;

    @Override
    public boolean apply(Course course) {
        boolean modified = false;
        if (!Objects.equals(this.courseName, course.getCourseName())) {
            course.setCourseName(this.courseName);
            modified = true;
        }
        if (!Objects.equals(this.title, course.getTitle())) {
            course.setTitle(this.title);
            modified = true;
        }
        if (teacher != course.getTeacher()) {
            course.setTeacher(teacher);
            modified = true;
        }
        return modified;
    }
}
