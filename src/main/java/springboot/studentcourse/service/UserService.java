package springboot.studentcourse.service;

import springboot.studentcourse.dto.UserDto;
import springboot.studentcourse.entity.User;

public interface UserService {
    User findByUsername(String username);

    User save(UserDto userDto);
}
