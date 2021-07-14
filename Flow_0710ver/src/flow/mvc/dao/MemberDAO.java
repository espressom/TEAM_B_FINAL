package flow.mvc.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flow.mvc.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public int idchk(MemberVO mvo) {
		return ss.selectOne("member.idchk", mvo);
	}

	public void signup(MemberVO mvo) {
		ss.insert("member.signup", mvo);
	}
	

}
