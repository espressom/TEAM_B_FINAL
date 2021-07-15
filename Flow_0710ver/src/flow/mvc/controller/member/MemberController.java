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
		return "member/loginForm";
	}

	@RequestMapping("/signup")
	public String signupPage(Model m) throws FileNotFoundException, IOException {
		return "member/signup";
	}

	@PostMapping("/insertmem")
	public String insertmem(MemberVO mvo) {
		memberService.signup(mvo);
		return "redirect:/";

	}

	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(MemberVO mvo, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MemberVO loginvo = memberService.loginProcess(mvo);

		if (loginvo == null) {

			mav.addObject("idpwdchk", "�α��� ����. ���̵� or �н����带 Ȯ���� �ּ���.");
			mav.setViewName("member/login_err");

		} else {
			session.setAttribute("sessionID", mvo.getM_id());
			session.setAttribute("sessionName", loginvo.getM_name());
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

	// session���� ID �ҷ����� ��������
	@RequestMapping("/selectUserInfoView")
	public ModelAndView userInfo() {
		System.out.println("ȸ���������� ����");
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

	// ��й�ȣ ã�� ������
	@RequestMapping("/findPWD")
	public String findpwd() {
		System.out.println("findPWD");
		return "member/findpwd";
	}
	
	@RequestMapping("/findID")
	public String findid() {
		System.out.println("findID");
		return "member/findid";
	}

	// ��й�ȣ ã��
	@PostMapping("/findPWDProcess")
	public ModelAndView findPWD(MemberVO mvo, String jumin1, String jumin2) {
		ModelAndView mav = new ModelAndView();
		StringBuilder sb = new StringBuilder();
		sb.append(jumin1).append("-");
		sb.append(jumin2);
		mvo.setM_jumin(sb.toString());

		MemberVO vo = memberService.findPWD(mvo);
		mav.addObject("vo", vo);
		mav.setViewName("member/changepwd");
		return mav;
	}

	// ��й�ȣ ����
	@PostMapping("/pwdsuccess")
	public String changePWD(MemberVO mvo) {
		memberService.changePWD(mvo);
		System.out.println("��й�ȣ ���� �Ϸ�");
		return "member/loginForm";
	}

}
