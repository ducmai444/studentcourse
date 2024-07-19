package springboot.studentcourse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.saolasoft.base.persistence.model.VoidableGeneratedIDEntry;
import vn.saolasoft.base.persistence.model.VoidableSerialIDEntry;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student extends VoidableSerialIDEntry {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private Course course;

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
