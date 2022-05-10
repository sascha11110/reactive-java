package loomtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "backend.url=http://localhost:8080")
class ReactiveFrontendApplicationTests {

  @Test
  void contextLoads() {
  }

}