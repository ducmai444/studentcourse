package springboot.studentcourse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String fullname;

    public User() {}

    public User(String username, String password, String fullname) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=";
    }
}
