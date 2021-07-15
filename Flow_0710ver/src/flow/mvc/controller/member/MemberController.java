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

   // 비밀번호 찾기 페이지
	@RequestMapping("/findPWD")
	public String findpwd() {
		System.out.println("findPWD");
		return "member/findpwd";
	}

	// 비밀번호 찾기
	@PostMapping("/findPWDProcess")
	public ModelAndView findPWD(MemberVO mvo, String jumin1, String jumin2) {
		ModelAndView mav = new ModelAndView();
		StringBuilder sb = new StringBuilder();
		sb.append(jumin1).append("-");
		sb.append(jumin2);
		mvo.setM_jumin(sb.toString());
		MemberVO vo = memberService.findPWD(mvo);
		if(vo == null) {
			mav.addObject("pwderr", "비밀번호 찾기에 실패 하셨습니다.");
			mav.setViewName("member/pwdfing_err");
		}else {
			mav.addObject("vo", vo);
			mav.setViewName("member/changepwd");
		}
			
		
		return mav;
	}

	// 비밀번호 변경
	@PostMapping("/pwdsuccess")
	public String changePWD(MemberVO mvo) {
		memberService.changePWD(mvo);
		System.out.println("비밀번호 변경 완료");
		return "member/loginForm";
	}

}
