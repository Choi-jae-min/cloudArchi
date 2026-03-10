package sparta.cloudarchi.global.exception.s3;

import org.springframework.http.HttpStatus;
import sparta.cloudarchi.global.exception.ServiceException;

public abstract class S3Exception extends ServiceException {
    public S3Exception(HttpStatus status ,String message) {
        super(status,message);
    }
}
