package springboot.studentcourse.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.studentcourse.entity.Course;
import vn.saolasoft.base.service.dto.DtoGet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDtoGet extends DtoGet<Course, Long> {

    private Long id;
    private String courseName;
    private String title;
    private String teacherName;

    @Override
    public void parse(Course course) {
        this.id = course.getId();
        this.courseName = course.getCourseName();
        this.title = course.getTitle();
        this.teacherName = course.getTeacher().getFirstName();
    }
}
