package flow.mvc.controller.member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import flow.mvc.service.MemberService;
import flow.mvc.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping("/login")
	public String loginPage(Model m) throws FileNotFoundException, IOException {
		System.out.println("MemberController  - login 진입");
		return "member/login";
	}
	
	@RequestMapping("/signup")
	public String signupPage(Model m) throws FileNotFoundException, IOException {
		System.out.println("MemberController  - signup 진입");
		return "member/signup";
	}
	
	@PostMapping("/insertmem")
	public String insertmem(MemberVO mvo) {
		System.out.println("MemberController  - insertmem 진입");
		
		System.out.println("mid ::::" + mvo.getM_id());

		memberService.signup(mvo);
		return "redirect:/";
		
	}

}
