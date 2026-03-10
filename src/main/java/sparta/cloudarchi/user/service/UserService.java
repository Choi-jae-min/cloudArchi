package sparta.cloudarchi.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.cloudarchi.global.exception.UserNotFoundException;
import sparta.cloudarchi.user.dto.UserRequestDto;
import sparta.cloudarchi.user.dto.UserResponseDto;
import sparta.cloudarchi.user.entity.User;
import sparta.cloudarchi.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserRequestDto userDto) {
        User user = new User(userDto);
        userRepository.save(user);

        return new UserResponseDto(user.getUsername(),user.getAge(),user.getMbti());
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 맴버입니다.")
        );

        return new UserResponseDto(user.getUsername(),user.getAge(),user.getMbti());
    }
}
