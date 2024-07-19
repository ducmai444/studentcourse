package springboot.studentcourse.controller;

import org.springframework.stereotype.Component;
import springboot.studentcourse.dto.student.StudentDtoGet;
import springboot.studentcourse.entity.Student;
import springboot.studentcourse.service.StudentService;
import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;

@Component
public class StudentAPIMethod extends AuditableDtoAPIMethod<StudentDtoGet, Student, Long> {

    private final StudentService studentService;

    public StudentAPIMethod(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }
}
