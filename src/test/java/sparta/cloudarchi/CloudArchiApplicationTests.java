package sparta.cloudarchi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sparta.cloudarchi.global.s3.S3Service;

@SpringBootTest
class CloudArchiApplicationTests {

    @MockBean
    private S3Service s3Service;

    @Test
    void contextLoads() {
    }

}
