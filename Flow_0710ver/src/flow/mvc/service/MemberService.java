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

	public int idchk(String id) {
		System.out.println(">>> MemberService - idchk 진입 >>>");
		System.out.println("id :::: " + id);
		MemberVO mvo = new MemberVO();
		mvo.setM_id(id);
		return memberdao.idchk(mvo);

	}

	public void signup(MemberVO mvo) {

		System.out.println(">>> MemberService - signup 진입 >>>");
		memberdao.signup(mvo);

	}

	public MemberVO loginProcess(MemberVO mvo) {
		return memberDaoInter.loginProcess(mvo);
	}

	public MemberVO detailMem(String userID) {
		return memberDaoInter.detailMem(userID);
	}

	public MemberVO findID(MemberVO mvo) {
		MemberVO vo = memberDaoInter.findID(mvo);
		if (vo == null) {
			MemberVO nvo = new MemberVO();
			nvo.setM_id("null");
			return nvo;
		}
		return vo;
	}

	// 비밀번호 찾기 트렌젝션
	public MemberVO findPWD(MemberVO mvo) {
		return memberDaoInter.findPWD(mvo);
	}

	// 비밀번호 변경 트렌젝션
	public void changePWD(MemberVO mvo) {
		memberDaoInter.changePWD(mvo);
	}

	public int isValidPwd(MemberVO mvo) {
		System.out.println("result :::: " + memberdao.userPwdChk(mvo));
		return memberdao.userPwdChk(mvo);
	}

	public void memUpdate(MemberVO mvo) {
		memberDaoInter.memberUpdate(mvo);
	}

	public void delMem(String m_id) {
		memberDaoInter.delMem(m_id);
	}

}
