package flow.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flow.mvc.dao.MemberDAO;
import flow.mvc.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberdao;
	
	public int idchk(String id) {
		System.out.println(">>> MemberService - idchk ���� >>>");
		System.out.println("id :::: " + id);
		MemberVO mvo = new MemberVO();
		mvo.setM_id(id);
		return memberdao.idchk(mvo);
		
	}
	
	public void signup(MemberVO mvo) {
		
		System.out.println(">>> MemberService - signup ���� >>>");
		memberdao.signup(mvo);
		
	}
	
	

}
