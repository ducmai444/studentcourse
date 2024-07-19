package springboot.studentcourse.service;

import springboot.studentcourse.dto.course.CourseDtoGet;
import springboot.studentcourse.entity.Course;
import vn.saolasoft.base.service.VoidableDtoService;

public interface CourseService extends VoidableDtoService<CourseDtoGet, Course, Long> {
    public boolean checkTeacherExist(Long id);
}
