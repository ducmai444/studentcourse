package springboot.studentcourse.repository;

import org.springframework.stereotype.Repository;
import springboot.studentcourse.entity.Student;
import vn.saolasoft.base.persistence.repository.VoidableRepository;

@Repository
public interface StudentRepository extends VoidableRepository<Student, Long>{
}
