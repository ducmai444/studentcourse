package springboot.studentcourse.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String username;
    private String password;
    private String fullname;

    public UserDto(String username, String password, String fullname) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
