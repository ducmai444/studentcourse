package springboot.studentcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.studentcourse.dto.UserDto;
import springboot.studentcourse.entity.User;
import springboot.studentcourse.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getFullname());
        return userRepository.save(user);
    }
}
