package flow.mvc.dao.member;

import flow.mvc.vo.MemberVO;

public interface MemberDaoInter {

	public MemberVO loginProcess(MemberVO mvo);
	public MemberVO detailMem(String userID);
	

	
}
