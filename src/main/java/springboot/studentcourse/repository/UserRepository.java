package springboot.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.studentcourse.dto.UserDto;
import springboot.studentcourse.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User save(UserDto userDto);
}
