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
	public String insertmem(MemberVO mvo, String m_jumin1, String m_jumin2) {
		System.out.println("MemberController  - insertmem ����");

		System.out.println("mid ::::" + mvo.getM_id());
		mvo.setM_jumin(m_jumin1 + "-" + m_jumin2);
		memberService.signup(mvo);
		return "redirect:/";

	}

	@RequestMapping("/userCheckForm")
	public String userCheck() {
		System.out.println("------------------------ userCheckForm ���� ------------------------");
		return "mng/userCheckForm";
	}

	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(MemberVO mvo, HttpSession session, HttpServletRequest request) {
		System.out.println("MemberController  - loginProcess ����");
		ModelAndView mav = new ModelAndView();
		MemberVO loginvo = memberService.loginProcess(mvo);

		if (loginvo == null) {

			mav.addObject("idpwdchk", "�α��� ����. ���̵� or �н����带 Ȯ���� �ּ���.");
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

	@RequestMapping("/selectUserInfoView")
	public ModelAndView userInfo(HttpSession session) {
		String userID = session.getAttribute("sessionID").toString();
		ModelAndView mav = new ModelAndView();
		System.out.println("ȸ���������� ����");
		MemberVO vo = new MemberVO();
		vo = memberService.detailMem(userID);
		mav.addObject("vo", vo);
		mav.setViewName("mng/selectUserInfoView");
		return mav;
	}

	// ��й�ȣ ã�� ������
	@RequestMapping("/findPWD")
	public String findpwdform() {
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
		System.out.println(" -------- findPWDProcess / findPWD ���� -------- ");
		mvo.setM_jumin(sb.toString());
		MemberVO vo = memberService.findPWD(mvo);
		if (vo == null) {
			mav.addObject("pwderr", "��й�ȣ ã�⿡ ���� �ϼ̽��ϴ�.");
			mav.setViewName("member/pwdfind_err");
		} else {
			mav.addObject("vo", vo);
			mav.setViewName("member/changepwd");
		}

		return mav;
	}

	// ��й�ȣ ����
	@PostMapping("/pwdsuccess")
	public String changePWD(MemberVO mvo) {
		memberService.changePWD(mvo);
		System.out.println("��й�ȣ ���� �Ϸ�");
		return "member/loginForm";
	}

	@RequestMapping("/memberUpdate")
	public ModelAndView memberUpdate(MemberVO mvo) {
		ModelAndView mav = new ModelAndView();
		System.out.println("���̵� : " + mvo.getM_id());
		System.out.println("��й�ȣ : " + mvo.getM_pwd());
		System.out.println("��ȭ��ȣ : " + mvo.getM_tel());
		memberService.memUpdate(mvo);
		System.out.println("������Ʈ �Ϸ�");
		mav.setViewName("redirect:/");
		return mav;
	}

	@RequestMapping("/delMember")
	public String delMember(HttpServletRequest request, HttpSession session) {
		System.out.println("ȸ�� Ż��!");
		// �ٹ������ ���̵� �޾ƿ´�!
		String m_id = request.getParameter("mId");
		System.out.println("���� �� ���̵� : " + m_id);
		memberService.delMem(m_id);
		System.out.println("���� �Ϸ�");
		session.removeAttribute("sessionID");
		session.removeAttribute("sessionName");
		return "redirect:/";
	}

	@PostMapping("/isvalidpwd")
	public String validpwd(MemberVO mvo, HttpSession session) {
		System.out.println("--------------------------- isvalidpwd ���� ----------------------------");
		String userid = session.getAttribute("sessionID").toString();
		mvo.setM_id(userid);
		System.out.println("id :::: " + mvo.getM_id());
		System.out.println("pwd :::: " + mvo.getM_pwd());
		int res = memberService.isValidPwd(mvo);
		System.out.println("res :::: " + res);

		if (res == 1) {

			return "redirect:/selectUserInfoView";

		} else {

			return "redirect:/";

		}

	}

}
