package springboot.studentcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.studentcourse.dto.teacher.TeacherDtoGet;
import springboot.studentcourse.entity.Teacher;
import springboot.studentcourse.repository.TeacherRepository;
import vn.saolasoft.base.persistence.repository.VoidableRepository;
import vn.saolasoft.base.service.impl.VoidableDtoJpaServiceImpl;

@Service
public class TeacherServiceImplement extends VoidableDtoJpaServiceImpl<TeacherDtoGet, Teacher, Long> implements TeacherService{

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImplement(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public VoidableRepository<Teacher, Long> getRepository() {
        return teacherRepository;
    }

    @Override
    public TeacherDtoGet convert(Teacher teacher) {
        return new TeacherDtoGet(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getEmail());
    }
}
