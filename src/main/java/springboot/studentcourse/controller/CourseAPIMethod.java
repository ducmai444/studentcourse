package springboot.studentcourse.controller;

import org.springframework.stereotype.Component;
import springboot.studentcourse.dto.course.CourseDtoGet;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.service.CourseService;
    import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;

@Component
public class CourseAPIMethod extends AuditableDtoAPIMethod<CourseDtoGet, Course, Long> {

    private final CourseService courseService;

    public CourseAPIMethod(CourseService courseService) {
        super(courseService);
        this.courseService = courseService;
    }
}
