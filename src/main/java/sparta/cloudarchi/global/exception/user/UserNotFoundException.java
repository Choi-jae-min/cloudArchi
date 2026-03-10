package sparta.cloudarchi.global.exception.user;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    public UserNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }
}
