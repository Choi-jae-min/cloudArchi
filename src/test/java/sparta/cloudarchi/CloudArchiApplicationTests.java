package sparta.cloudarchi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sparta.cloudarchi.global.s3.S3Service;

@SpringBootTest(properties = {
        "spring.cloud.aws.s3.enabled=false",
        "spring.cloud.aws.parameterstore.enabled=false"
})
class CloudArchiApplicationTests {

    @MockBean
    private S3Service s3Service;

    @Test
    void contextLoads() {
    }

}
