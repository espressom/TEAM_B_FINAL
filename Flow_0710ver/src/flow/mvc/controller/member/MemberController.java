package flow.mvc.controller.member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

import flow.mvc.service.MemberService;
import flow.mvc.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/loginForm")
	public String loginPage() {
		System.out.println("MemberController  - login");
		return "member/loginForm";
	}

	@RequestMapping("/signup")
	public String signupPage(Model m) throws FileNotFoundException, IOException {
		System.out.println("MemberController  - signup");
		return "member/signup";
	}

	@PostMapping("/insertmem")
	public String insertmem(MemberVO mvo) {

		System.out.println("mid ::::" + mvo.getM_id());

		memberService.signup(mvo);
		return "redirect:/";

	}

	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(MemberVO mvo, HttpSession session, HttpServletRequest request) {
		System.out.println("MemberController  - loginProcess 빳럼");
		ModelAndView mav = new ModelAndView();
		MemberVO loginvo = memberService.loginProcess(mvo);

		if (loginvo == null) {

			mav.addObject("idpwdchk", "로그인 실패. 아이디 or 패스워드를 확인해 주세요.");
			mav.setViewName("member/login_err");

		} else {
			session.setAttribute("sessionID", mvo.getM_id());
			session.setAttribute("sessionName", loginvo.getM_name());
			System.out.println("sessionID ::::" + session.getAttribute("sessionID"));
			mav.setViewName("redirect:/");
		}

		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logoutProcess(HttpSession session, HttpServletRequest request, MemberVO mvo) {

		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}

	// session에서 ID 불러오게 만들어야함
	@RequestMapping("/selectUserInfoView")
	public ModelAndView userInfo() {
		System.out.println("회원정보수정 진입");
		ModelAndView mav = new ModelAndView();
		MemberVO vo = new MemberVO();
		String userID = "admin";
		vo = memberService.detailMem(userID);
		System.out.println("id ::::" + vo.getM_id());
		System.out.println("mnum ::::" + vo.getM_num());
		// m.addAttribute("vo",vo);
		mav.addObject("vo", vo);
		mav.setViewName("mng/selectUserInfoView");
		return mav;
	}

}
