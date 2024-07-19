package springboot.studentcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.studentcourse.dto.course.CourseDtoGet;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.repository.CourseRepository;
import springboot.studentcourse.repository.TeacherRepository;
import vn.saolasoft.base.persistence.repository.AuditableRepository;
import vn.saolasoft.base.persistence.repository.VoidableRepository;
import vn.saolasoft.base.service.impl.AuditableDtoJpaServiceImpl;
import vn.saolasoft.base.service.impl.VoidableDtoJpaServiceImpl;

@Service
public class CourseServiceImplement extends VoidableDtoJpaServiceImpl<CourseDtoGet, Course, Long> implements CourseService {

    private CourseRepository courseRepository;
    private TeacherRepository teacherRepository;

    @Autowired
    public CourseServiceImplement(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public VoidableRepository<Course, Long> getRepository() {
        return courseRepository;
    }

    @Override
    public CourseDtoGet convert(Course course) {
        return new CourseDtoGet(course.getId(), course.getCourseName(), course.getTitle(), course.getTeacher().getFirstName());
    }

    @Override
    public boolean checkTeacherExist(Long id) {
        return teacherRepository.findById(id).isPresent();
    }

}
