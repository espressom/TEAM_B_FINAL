package flow.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flow.mvc.dao.member.MemberDao;
import flow.mvc.dao.member.MemberDaoInter;
import flow.mvc.vo.MemberVO;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao memberdao;

	@Autowired
	private MemberDaoInter memberDaoInter;

 
 
	public MemberVO loginProcess(MemberVO mvo) {
		return memberDaoInter.loginProcess(mvo);
	}

 
 
	// 비밀번호 찾기 트렌젝션
	public MemberVO findPWD(MemberVO mvo) {
		return memberDaoInter.findPWD(mvo);
	}

	// 비밀번호 변경 트렌젝션
	public void changePWD(MemberVO mvo) {
		memberDaoInter.changePWD(mvo);
	}

}
