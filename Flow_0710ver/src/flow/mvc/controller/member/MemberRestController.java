package flow.mvc.controller.member;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import flow.mvc.service.MemberService;
import flow.mvc.vo.MemberVO;

@RestController
public class MemberRestController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/idchk")
	public int idchk(String mid) throws UnsupportedEncodingException {
		System.out.println(">>> idchk 진입 >>>");

		System.out.println("mid :::: " + mid);

		int res = memberService.idchk(mid);

		System.out.println("res :::: " + res);

		return res;
	}
	
	//아이디 찾기 
    @GetMapping("/findIDProcess")
    public String findID(MemberVO mvo) {
       System.out.println("findIDProcess 진입");
       
       System.out.println("name ::::" + mvo.getM_name());
       
       MemberVO vo = memberService.findID(mvo);
       System.out.println("res id ::::" + vo.getM_id());

       return vo.getM_id();
    }

}
