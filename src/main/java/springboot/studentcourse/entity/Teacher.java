package springboot.studentcourse.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.saolasoft.base.persistence.model.VoidableGeneratedIDEntry;
import vn.saolasoft.base.persistence.model.VoidableSerialIDEntry;

import java.util.List;

@Entity
@Table(name="teacher")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "courses"})
@Getter
@Setter
public class Teacher extends VoidableSerialIDEntry {

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "teacher",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Course> courses;

    @Override
    public String toString() {
        return "Teacher{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
