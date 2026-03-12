package sparta.cloudarchi.global.s3;

import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sparta.cloudarchi.global.exception.s3.S3UploadFailException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final S3Template s3Template;

    @Value("${app.s3.bucket}")
    private String bucket;

    @Value("${app.cloudfront.url}")
    private String cloudFrontUrl;

    public String upload(MultipartFile file) {
        try {
            String key = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, key, file.getInputStream());
            return key;
        } catch (IOException e) {
            throw new S3UploadFailException("파일 업로드 실패 :" + e.getMessage());
        }
    }

    public String getDownloadUrl(String key) {
        return cloudFrontUrl + "/" + key;
    }
}
