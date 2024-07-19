package springboot.studentcourse.controller;

import org.springframework.stereotype.Component;
import springboot.studentcourse.dto.teacher.TeacherDtoGet;
import springboot.studentcourse.entity.Teacher;
import springboot.studentcourse.service.TeacherService;
import vn.saolasoft.base.api.method.AuditableDtoAPIMethod;
import vn.saolasoft.base.service.AuditableDtoService;

@Component
public class TeacherAPIMethod extends AuditableDtoAPIMethod<TeacherDtoGet, Teacher, Long> {

    private final TeacherService teacherService;

    public TeacherAPIMethod(TeacherService teacherService) {
        super(teacherService);
        this.teacherService = teacherService;
    }
}
