package springboot.studentcourse.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.studentcourse.dto.course.CourseDtoGet;
import springboot.studentcourse.dto.course.CourseDtoUpdate;
import springboot.studentcourse.dto.student.StudentDtoCreate;
import springboot.studentcourse.dto.student.StudentDtoGet;
import springboot.studentcourse.dto.student.StudentDtoUpdate;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.entity.Student;
import springboot.studentcourse.repository.CourseRepository;
import springboot.studentcourse.service.StudentService;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentAPIMethod studentAPIMethod;

    @Autowired
    private CourseRepository courseRepository;

    public StudentController(StudentAPIMethod studentAPIMethod) {
        this.studentAPIMethod = studentAPIMethod;
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<APIResponse<StudentDtoGet>> getStudent(@PathVariable Long studentId) {
        return studentAPIMethod.getById(studentId);
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse<Long>> addStudent(@RequestBody StudentDtoCreate studentDtoCreate, @RequestParam Long callerId) {
        Student student = studentDtoCreate.toEntry();
        Course course = courseRepository.findById(studentDtoCreate.getCourse().getId())
                .orElseThrow(() -> new ObjectNotFoundException(studentDtoCreate, "Cannot found course"));

        if (!Objects.equals(course.getCourseName(), studentDtoCreate.getCourse().getCourseName()) ||
                !Objects.equals(course.getTitle(), studentDtoCreate.getCourse().getTitle())) {
            throw new APIException("Not match with course get by id");
        }
        studentDtoCreate.setCourse(course);
        return studentAPIMethod.create(studentDtoCreate, callerId);
    }

    @DeleteMapping("/")
    public ResponseEntity<APIResponse<Long>> deleteStudentById(@RequestParam Long studentId, @RequestParam Long callerId) {
        return studentAPIMethod.delete(studentId, callerId);
    }

    @PutMapping("/")
    public ResponseEntity<APIResponse<Long>> updateStudent(@RequestBody StudentDtoUpdate studentDtoUpdate, @RequestParam Long callerId) {
        Course course = studentDtoUpdate.getCourse();
        Course tempCourse = courseRepository.findById(course.getId())
                .orElseThrow(() -> new APIException("Course not found"));

        if (!Objects.equals(course.getCourseName(), tempCourse.getCourseName()) ||
                !Objects.equals(course.getTitle(), tempCourse.getTitle())) {
            throw new APIException("Information in the course is not related to each other.");
        }

        return studentAPIMethod.update(studentDtoUpdate, callerId);
    }

    @GetMapping("/list")
    public ResponseEntity<APIListResponse<List<StudentDtoGet>>> getListCourse(@RequestBody PaginationInfo paginationInfo) {
        return studentAPIMethod.getList(paginationInfo);
    }

    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<StudentDtoGet>>> searchStudents(
            @RequestBody BaseFilter<Student, Long> baseFilter,
            @RequestParam int firstRow,
            @RequestParam int maxResults,
            @RequestParam(required = false) String orderBy) {
        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResults, orderBy);
        return studentAPIMethod.search(baseFilter, paginationInfo);
    }

}
