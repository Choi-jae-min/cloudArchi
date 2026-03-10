package sparta.cloudarchi.global.exception;

import org.springframework.http.HttpStatus;

public abstract class UserException extends ServiceException {
    public UserException(HttpStatus status,String message) {
        super(status,message);
    }
}
