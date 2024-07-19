package springboot.studentcourse.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.entity.Teacher;
import springboot.studentcourse.repository.TeacherRepository;
import vn.saolasoft.base.service.dto.SerialIDDtoCreate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDtoCreate extends SerialIDDtoCreate<Course> {

    private String courseName;
    private String title;
    private Teacher teacher;
    private Long teacherId;

    @Override
    public Course toEntry() {
        Course course = new Course();
        course.setId(this.getId());
        course.setCourseName(courseName);
        course.setTitle(title);
        course.setTeacher(teacher);
        return course;
    }
}
