package sparta.cloudarchi.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sparta.cloudarchi.user.dto.FileDownloadUrlResponse;
import sparta.cloudarchi.user.dto.FileUploadResponse;
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

    @PostMapping("/{userId}/profile-image")
    public ResponseEntity<FileUploadResponse> uploadUserProfileImage(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
        String key = userService.saveProfile(userId, file);
        return ResponseEntity.ok(new FileUploadResponse(key));
    }

    @GetMapping("/{userId}/profile-image")
    public ResponseEntity<FileDownloadUrlResponse> getUserProfileImage(@PathVariable Long userId) {
        String url = userService.getUserProfileUrl(userId);
        return ResponseEntity.ok(new FileDownloadUrlResponse(url));
    }
}

