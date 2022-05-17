package loomtest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

class ServletBackendApplicationTests {

	@Nested
	class PlatformThreadsTest {

		@Test
		void contextLoads() {
		}

	}

	@Nested
	@ActiveProfiles("loom")
	class VirtualThreadsTest {

		@Test
		void contextLoads() {
		}

	}

}
