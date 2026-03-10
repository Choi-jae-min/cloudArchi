package sparta.cloudarchi.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sparta.cloudarchi.user.dto.UserRequestDto;
import sparta.cloudarchi.user.dto.UserResponseDto;
import sparta.cloudarchi.user.service.UserService;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
}

