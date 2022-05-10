package loomtest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

class ServletFrontendApplicationTests {

	@Nested
	@SpringBootTest(properties = "backend.url=http://localhost:8080")
	class PlatformThreadsTest {

		@Test
		void contextLoads() {
		}

	}

	@Nested
	@ActiveProfiles("loom")
	@SpringBootTest(properties = "backend.url=http://localhost:8080")
	class VirtualThreadsTest {

		@Test
		void contextLoads() {
		}

	}

}
