package flow.mvc.controller.member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		System.out.println("MemberController  - insertmem 진입");

		System.out.println("mid ::::" + mvo.getM_id());
		mvo.setM_jumin(m_jumin1 + "-" + m_jumin2);
		memberService.signup(mvo);
		return "redirect:/";

	}

	@RequestMapping("/userCheckForm")
	public String userCheck() {
		System.out.println("------------------------ userCheckForm 접속 ------------------------");
		return "mng/userCheckForm";
	}

	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(MemberVO mvo, HttpSession session, HttpServletRequest request) {
		System.out.println("MemberController  - loginProcess 진입");
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

	@RequestMapping("/selectUserInfoView")
	public ModelAndView userInfo(HttpSession session) {
		String userID = session.getAttribute("sessionID").toString();
		ModelAndView mav = new ModelAndView();
		System.out.println("회원정보수정 진입");
		MemberVO vo = new MemberVO();
		vo = memberService.detailMem(userID);
		mav.addObject("vo", vo);
		mav.setViewName("mng/selectUserInfoView");
		return mav;
	}

	// 비밀번호 찾기 페이지
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

	// 비밀번호 찾기
	@PostMapping("/findPWDProcess")
	public ModelAndView findPWD(MemberVO mvo, String jumin1, String jumin2) {
		ModelAndView mav = new ModelAndView();
		StringBuilder sb = new StringBuilder();
		sb.append(jumin1).append("-");
		sb.append(jumin2);
		System.out.println(" -------- findPWDProcess / findPWD 접속 -------- ");
		mvo.setM_jumin(sb.toString());
		MemberVO vo = memberService.findPWD(mvo);
		if (vo == null) {
			mav.addObject("pwderr", "비밀번호 찾기에 실패 하셨습니다.");
			mav.setViewName("member/pwdfind_err");
		} else {
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

	@RequestMapping("/memberUpdate")
	public ModelAndView memberUpdate(MemberVO mvo) {
		ModelAndView mav = new ModelAndView();
		System.out.println("아이디 : " + mvo.getM_id());
		System.out.println("비밀번호 : " + mvo.getM_pwd());
		System.out.println("전화번호 : " + mvo.getM_tel());
		memberService.memUpdate(mvo);
		System.out.println("업데이트 완료");
		mav.setViewName("redirect:/");
		return mav;
	}
	// 회원탈퇴
	@RequestMapping("/delMember")
	@ResponseBody
	public ModelAndView delMember(MemberVO mvo, HttpSession session, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		// 회원 탈퇴전에 비밀번호 확인!		
		String m_id = session.getAttribute("sessionID").toString();
		mvo.setM_id(m_id);
		
		// 비밀번호 일치 여부
		int res = memberService.isValidPwd(mvo);
		
		if(res == 1) {
			
			memberService.delMem(mvo.getM_id());
			session.removeAttribute("sessionID");
			session.removeAttribute("sessionName");
			
			mav.addObject("idpwdchk", "탈퇴처리되었습니다. 이용해 주셔서 감사합니다.");
			mav.setViewName("mng/delOk");
			return mav;
		} else {
			mav.addObject("idpwdchk", "회원 탈퇴 실패! 비밀번호를 확인해 주세요.");
			mav.setViewName("mng/delPwdChkErr");
			return mav;
			}
			
		
	}

	@PostMapping("/isvalidpwd")
	public String validpwd(MemberVO mvo, HttpSession session) {
		System.out.println("--------------------------- isvalidpwd 접속 ----------------------------");
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
	
	// 회원 탈퇴 확인
	@RequestMapping("/delChk")
	public String delChk() {
		System.out.println("회원탈퇴 확인절차");
		
		return "mng/delCheckForm";
	}
	

}
