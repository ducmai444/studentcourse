package springboot.studentcourse.repository;

import org.springframework.stereotype.Repository;
import springboot.studentcourse.entity.Teacher;
import vn.saolasoft.base.persistence.repository.VoidableRepository;

@Repository
public interface TeacherRepository extends VoidableRepository<Teacher, Long> {
}
