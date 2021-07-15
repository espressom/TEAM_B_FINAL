package flow.mvc.dao.member;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flow.mvc.vo.MemberVO;

@Repository
public class MemberDao implements MemberDaoInter {

	@Autowired
	private SqlSessionTemplate ss;
	
	@Override
	public MemberVO loginProcess (MemberVO mvo) {
		System.out.println("MemberDao : loginCheck");
		return ss.selectOne("member.loginChk", mvo);
		 
	}
//	
//	public int idchk(MemberVO mvo) {
//		return ss.selectOne("member.idchk", mvo);
//	}
//
//	public void signup(MemberVO mvo) {
//		ss.insert("member.signup", mvo);
//	}
//
//	@Override
//	public MemberVO detailMem(String userID) {
//		return ss.selectOne("member.detail", userID);
//	}
//	
//	@Override
//	public MemberVO findID(MemberVO mvo) {
//		return ss.selectOne("member.findid", mvo);
//	}
	
	
	// 비밀번호 찾기
	@Override
	public MemberVO findPWD(MemberVO mvo) {
		return ss.selectOne("member.findpwd", mvo);
	}
	// 비밀번호 변경
	@Override
	public void changePWD(MemberVO mvo) {
		ss.update("member.changepwd", mvo);
	}
	
	
}
