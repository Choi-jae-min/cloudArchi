package sparta.cloudarchi.global.exception.user;

import org.springframework.http.HttpStatus;
import sparta.cloudarchi.global.exception.ServiceException;

public abstract class UserException extends ServiceException {
    public UserException(HttpStatus status,String message) {
        super(status,message);
    }
}
