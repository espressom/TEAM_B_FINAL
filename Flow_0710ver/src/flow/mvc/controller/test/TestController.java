package flow.mvc.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 허태준 / 2021. 7. 18. / 오전 11:40:14
 */

@Controller
public class TestController {

	@RequestMapping("/test")
	public String testPage() {
		return "test/test";
	}
	
	@RequestMapping("/news")
	public String newsPage() {
		return "test/news";
	}
}
