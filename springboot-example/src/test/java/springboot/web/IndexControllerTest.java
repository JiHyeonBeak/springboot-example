package springboot.web;

import com.pigsheep.book.springboot.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void landing_mainpage() {
        //when
        String body = this.restTemplate.getForObject("/",String.class);

        //then
        // html파일에 해당 문자열이 있는지 체크.
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
