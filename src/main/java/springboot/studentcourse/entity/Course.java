package springboot.studentcourse.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.saolasoft.base.persistence.model.VoidableSerialIDEntry;

import java.util.List;

@Entity
@Table(name="course")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "students"})
@Getter
@Setter
public class Course extends VoidableSerialIDEntry {

    @Column(name="course_name")
    private String courseName;

    @Column(name="title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY
            , cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL})
    private List<Student> students;

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", title='" + title + '\'' +
                ", teacher=" +
                '}';
    }
}
