package sparta.cloudarchi.global.exception.s3;

import org.springframework.http.HttpStatus;

public class S3UploadFailException extends S3Exception{
    public S3UploadFailException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR,message);
    }
}
