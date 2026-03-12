package sparta.cloudarchi.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sparta.cloudarchi.global.exception.user.UserNotFoundException;
import sparta.cloudarchi.global.s3.S3Service;
import sparta.cloudarchi.user.dto.UserRequestDto;
import sparta.cloudarchi.user.dto.UserResponseDto;
import sparta.cloudarchi.user.entity.User;
import sparta.cloudarchi.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final S3Service s3Service;

    @Transactional
    public UserResponseDto save(UserRequestDto userDto) {
        User user = new User(userDto);
        userRepository.save(user);

        return new UserResponseDto(user.getUsername(),user.getAge(),user.getMbti());
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId) {
        User user = findUserBuId(userId);

        return new UserResponseDto(user.getUsername(),user.getAge(),user.getMbti());
    }

    @Transactional
    public String saveProfile(Long userId, MultipartFile file) {
        User user = findUserBuId(userId);

        String profileKey = s3Service.upload(file);

        user.setProfile_key(profileKey);
        return profileKey;
    }

    @Transactional(readOnly = true)
    public String getUserProfileUrl(Long userId) {
        User user = findUserBuId(userId);

        return s3Service.getDownloadUrl(user.getProfile_key());
    }

    public User findUserBuId(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("존재하지 않는 맴버입니다.")
        );
    }
}
