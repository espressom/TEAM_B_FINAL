package flow.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flow.mvc.dao.member.MemberDaoInter;
import flow.mvc.vo.MemberVO;

@Service
@Transactional
public class MemberService implements MemberServiceInter {

	@Autowired
	private MemberDaoInter memberDaoInter;
	
	@Override
	public MemberVO loginProcess(MemberVO mvo) {
		return memberDaoInter.loginProcess(mvo);
	}

	
	
}
