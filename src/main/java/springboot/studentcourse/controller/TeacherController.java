package springboot.studentcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.studentcourse.dto.course.CourseDtoGet;
import springboot.studentcourse.dto.teacher.TeacherDtoCreate;
import springboot.studentcourse.dto.teacher.TeacherDtoGet;
import springboot.studentcourse.dto.teacher.TeacherDtoUpdate;
import springboot.studentcourse.entity.Teacher;
import springboot.studentcourse.service.TeacherServiceImplement;
import vn.saolasoft.base.api.response.APIListResponse;
import vn.saolasoft.base.api.response.APIResponse;
import vn.saolasoft.base.service.filter.BaseFilter;
import vn.saolasoft.base.service.filter.PaginationInfo;
import vn.saolasoft.base.service.filter.SortInfo;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherAPIMethod teacherAPIMethod;

    @Autowired
    private TeacherServiceImplement teacherServiceImplement;

    public TeacherController(TeacherAPIMethod teacherAPIMethod) {
        this.teacherAPIMethod = teacherAPIMethod;
    }

    @GetMapping("/get/{teacherId}")
    public ResponseEntity<APIResponse<TeacherDtoGet>> getTeacherById(@PathVariable Long teacherId) {
        return teacherAPIMethod.getById(teacherId);
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse<Long>> addTeacher(@RequestBody TeacherDtoCreate teacherDtoCreate, @RequestParam Long callerId){
        return teacherAPIMethod.create(teacherDtoCreate, callerId);
    }

    @DeleteMapping("/")
    public ResponseEntity<APIResponse<Long>> deleteTeacherById(@RequestParam Long teacherId, @RequestParam Long callerId) {
        return teacherAPIMethod.delete(teacherId, callerId);
    }

    @PutMapping("/")
    public ResponseEntity<APIResponse<Long>> updateTeacher(@RequestBody TeacherDtoUpdate teacherDtoUpdate, @RequestParam Long callerId) {
        return teacherAPIMethod.update(teacherDtoUpdate, callerId);
    }

    @GetMapping("/list")
    public ResponseEntity<APIListResponse<List<TeacherDtoGet>>> getListCourse(@RequestParam int firstRow,
                                                                             @RequestParam int maxResults,
                                                                             @RequestParam String sortInfo,
                                                                             @RequestParam Boolean orderAsc) {
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setFirstRow(firstRow);
        paginationInfo.setMaxResults(maxResults);
        paginationInfo.setOrders(new SortInfo(sortInfo, orderAsc));

        return teacherAPIMethod.getList(paginationInfo);
    }

    @GetMapping("/search")
    public ResponseEntity<APIListResponse<List<TeacherDtoGet>>> searchTeachers(
            @RequestBody BaseFilter<Teacher, Long> baseFilter,
            @RequestParam int firstRow,
            @RequestParam int maxResults,
            @RequestParam(required = false) String orderBy) {
        PaginationInfo paginationInfo = new PaginationInfo(firstRow, maxResults, orderBy);
        return teacherAPIMethod.search(baseFilter, paginationInfo);
    }

    @DeleteMapping("/purge")
    public TeacherDtoGet deleteTeacherAndGet(@RequestParam Long teacherId, @RequestParam boolean purged, @RequestParam Long callerId) {
        return teacherServiceImplement.deleteAndGet(teacherId, purged, callerId);
    }


}
