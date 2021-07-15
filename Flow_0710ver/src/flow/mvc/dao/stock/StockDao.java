package flow.mvc.dao.stock;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flow.mvc.vo.MemberVO;

@Repository
public class StockDao implements StockDaoInter {

	@Autowired
	private SqlSessionTemplate ss;


	
	
}
