package com.anbustamante.dolarhoy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.ModelAndViewAssert;

@SpringBootTest
class DolarhoyApplicationTests {

	@Test
	void connects_to_url() {

		Document doc = Jsoup.connect(URL).get();
		assert doc != null;

	}

}
