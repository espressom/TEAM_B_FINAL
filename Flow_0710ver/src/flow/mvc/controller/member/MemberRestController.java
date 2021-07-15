package flow.mvc.controller.member;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flow.mvc.service.MemberService;

@RestController
public class MemberRestController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/idchk")
	public int idchk(String mid) throws UnsupportedEncodingException {
		
		System.out.println(">>> idchk ÁøÀÔ >>>");
		
		System.out.println("mid :::: " + mid);

		int res = memberService.idchk(mid);
		
		System.out.println("res :::: " + res);
		
		return res;
	}

}
