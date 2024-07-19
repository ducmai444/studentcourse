package springboot.studentcourse.controller;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.studentcourse.dto.course.CourseDtoCreate;
import springboot.studentcourse.dto.course.CourseDtoGet;
import springboot.studentcourse.dto.course.CourseDtoUpdate;
import springboot.studentcourse.entity.Course;
import springboot.studentcourse.entity.Teacher;
import springboot.studentcourse.repository.CourseRepository;
import springboot.studentcourse.repository.TeacherRepository;
import springboot.studentcourse.service.CourseService;
import springboot.studentcourse.service.TeacherService;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.exception.APIException;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseAPIMethod courseAPIMethod;

    @Autowired
    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;


    public CourseController(CourseAPIMethod courseAPIMethod) {
        this.courseAPIMethod = courseAPIMethod;
    }

    @GetMapping("/get/{courseId}")
    public ResponseEntity<APIResponse<CourseDtoGet>> getCourse(@PathVariable Long courseId) {
        return courseAPIMethod.getById(courseId);
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse<Long>> addCourse(@RequestBody CourseDtoCreate courseDtoCreate, @RequestParam Long callerId) {
        Course course = courseDtoCreate.toEntry();
        Teacher teacher = teacherRepository.findById(courseDtoCreate.getTeacher().getId())
                .orElseThrow(() -> new ObjectNotFoundException(courseDtoCreate, "Teacher not found"));

        if (!teacher.getFirstName().equals(courseDtoCreate.getTeacher().getFirstName()) ||
                !teacher.getLastName().equals(courseDtoCreate.getTeacher().getLastName()) ||
                !teacher.getEmail().equals(courseDtoCreate.getTeacher().getEmail())) {
            throw new APIException("Information in the teacher is not related to each other.");
        }
        courseDtoCreate.setTeacher(teacher);
        return courseAPIMethod.create(courseDtoCreate, callerId);
    }

    @DeleteMapping("/")
    public ResponseEntity<APIResponse<Long>> deleteCourseById(@RequestParam Long courseId, @RequestParam Long callerId) {
        return courseAPIMethod.delete(courseId, callerId);
    }

    @PutMapping("/")
    public ResponseEntity<APIResponse<Long>> updateCourse(@RequestBody CourseDtoUpdate courseDtoUpdate, @RequestParam Long callerId) {

        Teacher teacher = courseDtoUpdate.getTeacher();
        Teacher tempTeacher = teacherRepository.findById(teacher.getId())
                .orElseThrow(() -> new APIException("Teacher not found"));

        if (!Objects.equals(teacher.getFirstName(), tempTeacher.getFirstName()) ||
                !Objects.equals(teacher.getLastName(), teacher.getLastName()) ||
                !Objects.equals(teacher.getEmail(), teacher.getEmail())) {
            throw new APIException("Information in the teacher is not related to each other.");
        }
        return courseAPIMethod.update(courseDtoUpdate, callerId);
    }

    @GetMapping("/list")
    public ResponseEntity<APIListResponse<List<CourseDtoGet>>> getListCourse(@RequestBody PaginationInfo paginationInfo) {
        return courseAPIMethod.getList(paginationInfo);
    }

    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<CourseDtoGet>>> searchCourses(
            @RequestBody BaseFilter<Course, Long> baseFilter,
            @RequestParam int firstRow,
            @RequestParam int maxResults,
            @RequestParam(required = false) String orderBy) {
        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResults, orderBy);
        return courseAPIMethod.search(baseFilter, paginationInfo);
    }
}
