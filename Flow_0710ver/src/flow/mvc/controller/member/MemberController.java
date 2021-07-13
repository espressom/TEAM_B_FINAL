package flow.mvc.controller.member;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import flow.mvc.dao.member.MemberDaoInter;
import flow.mvc.vo.MemberVO;


@Controller
public class MemberController {

	@Autowired
	private MemberDaoInter memberDaoInter;

	@RequestMapping("/loginForm")
	public String loginPage() {
		System.out.println("MemberController  - login 진입");
		return "member/login";
	}
	
	@RequestMapping("/signup")
	public String signupPage(Model m) throws FileNotFoundException, IOException {
		System.out.println("MemberController  - signup 진입");
		return "member/signup";
	}

	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(MemberVO mvo, HttpSession session, HttpServletRequest request) {
		System.out.println("MemberController  - loginProcess 진입");
		ModelAndView mav = new ModelAndView();
		MemberVO loginvo = memberDaoInter.loginCheck(mvo);
		
	
		if (loginvo == null) {
			System.out.println("로그인 실패");
			// 에러페이지 띄우기
			mav.setViewName("redirect:/");
		} else {
			System.out.println("로그인 성공");
			session.setAttribute("sessionID", mvo.getM_id());
			session.setAttribute("sessionName", loginvo.getM_name());
			mav.setViewName("redirect:/");
		}

		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logoutProcess(HttpSession session, HttpServletRequest request, MemberVO mvo) {
		System.out.println("MemberController  - logoutProcess 진입");
		System.out.println("로그아웃 할 id값  : " + session.getAttribute("sessionID"));
		
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	
}
