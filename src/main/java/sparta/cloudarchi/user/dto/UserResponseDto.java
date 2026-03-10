package sparta.cloudarchi.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserResponseDto {
    private final String username;
    private final int age;
    private final String mbti;
}
