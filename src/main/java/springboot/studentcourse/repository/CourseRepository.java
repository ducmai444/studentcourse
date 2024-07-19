package springboot.studentcourse.repository;

import org.springframework.stereotype.Repository;
import springboot.studentcourse.entity.Course;
import vn.saolasoft.base.persistence.repository.VoidableRepository;

import java.io.Serializable;

@Repository
public interface CourseRepository extends VoidableRepository<Course, Long> {
}