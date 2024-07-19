package springboot.studentcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.studentcourse.dto.student.StudentDtoGet;
import springboot.studentcourse.entity.Student;
import springboot.studentcourse.repository.StudentRepository;
import vn.saolasoft.base.persistence.repository.VoidableRepository;
import vn.saolasoft.base.service.impl.VoidableDtoJpaServiceImpl;

@Service
public class StudentServiceImplement extends VoidableDtoJpaServiceImpl<StudentDtoGet, Student, Long> implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplement(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public VoidableRepository<Student, Long> getRepository() {
        return studentRepository;
    }

    @Override
    public StudentDtoGet convert(Student student) {
        return new StudentDtoGet(student.getId(), student.getFirstName(), student.getLastName(), student.getCourse().getCourseName());
    }
}
