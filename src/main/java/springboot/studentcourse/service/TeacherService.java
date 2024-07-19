package springboot.studentcourse.service;

import springboot.studentcourse.dto.teacher.TeacherDtoGet;
import springboot.studentcourse.entity.Teacher;
import vn.saolasoft.base.service.AuditableDtoService;
import vn.saolasoft.base.service.VoidableDtoService;

public interface TeacherService extends VoidableDtoService<TeacherDtoGet, Teacher, Long> {
}
