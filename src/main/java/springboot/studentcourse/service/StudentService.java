package springboot.studentcourse.service;

import springboot.studentcourse.dto.student.StudentDtoGet;
import springboot.studentcourse.entity.Student;
import vn.saolasoft.base.service.VoidableDtoService;

public interface StudentService extends VoidableDtoService<StudentDtoGet, Student, Long> {
}
