package sparta.cloudarchi.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sparta.cloudarchi.global.exception.s3.S3Exception;
import sparta.cloudarchi.global.exception.user.UserException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        log.error("예상치 못한 예외 발생 : {}", ex.getMessage());
        return ResponseEntity.status(500).body(ex.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handleServiceException(ServiceException ex) {
        log.error("서비스 예외 발생 : {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleUserException(UserException ex) {
        log.error("유저 예외 발생 : {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(S3Exception.class)
    public ResponseEntity<String> handleS3Exception(S3Exception ex) {
        log.error("S3 예외 발생 : {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
