package flow.mvc.dao.stock;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flow.mvc.vo.CompanyVO;
import flow.mvc.vo.MemberVO;
import flow.mvc.vo.StockLikeVO;

@Repository
public class StockDao implements StockDaoInter {

	@Autowired
	private SqlSessionTemplate ss;

	@Override
	public List<CompanyVO> companyList() {
		System.out.println("StockDao : companyList");
		List<CompanyVO> cList= ss.selectList("stock.company_all");
		return cList;
	}

	@Override
	public CompanyVO companyDetail(String c_code) {
		System.out.println("StockDao : companyDetail");
		CompanyVO cDetail = ss.selectOne("stock.company_detail", c_code); // 인자전달 잊지마
		return cDetail;
	} 
	
	@Override
	public int getLike(StockLikeVO slvo) {
		System.out.println("StockDao : getLike");
		int cnt = ss.selectOne("stock.get_like", slvo);
		System.out.println(slvo.getSlike_code() + " / " + slvo.getSlike_id());
		System.out.println(cnt);
		return cnt;
	}

	@Override
	public void addLike(StockLikeVO slvo) {
		System.out.println("StockDao : addLike");
		ss.insert("stock.add_like", slvo);
	}

	@Override
	public void delLike(StockLikeVO slvo) {
		System.out.println("StockDao : delLike");
		ss.insert("stock.del_like", slvo);
	}

	@Override
	public List<StockLikeVO> listLike(String slike_id) {
		System.out.println("StockDao : listLike");
		return ss.selectList("stock.list_like", slike_id);
	}

	@Override
	public int countLike(String c_code) {
		System.out.println("StockDao : count_like");
		return ss.selectOne("stock.count_like", c_code);
		
	}
 
	
	
}
