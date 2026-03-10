package sparta.cloudarchi.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sparta.cloudarchi.global.s3.S3Service;
import sparta.cloudarchi.user.dto.FileDownloadUrlResponse;
import sparta.cloudarchi.user.dto.FileUploadResponse;
import sparta.cloudarchi.user.dto.UserRequestDto;
import sparta.cloudarchi.user.dto.UserResponseDto;
import sparta.cloudarchi.user.service.UserService;

import java.net.URL;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final S3Service s3Service;

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
        String key = s3Service.upload(file);
        return ResponseEntity.ok(new FileUploadResponse(key));
    }

    @GetMapping("/{key}/profile-image")
    public ResponseEntity<FileDownloadUrlResponse> getUserProfileImage(@PathVariable String key) {
        URL url = s3Service.getDownloadUrl(key);
        return ResponseEntity.ok(new FileDownloadUrlResponse(url.toString()));
    }
}

