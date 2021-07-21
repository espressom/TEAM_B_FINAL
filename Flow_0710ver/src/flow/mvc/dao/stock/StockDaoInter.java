package flow.mvc.dao.stock;

import java.util.List;

import flow.mvc.vo.CompanyVO;
import flow.mvc.vo.StockLikeVO;


public interface StockDaoInter {

	// 기업목록 -----
	public List<CompanyVO> companyList ();
	public CompanyVO companyDetail(String c_code);
	
	// 관심종목 -----
	public int getLike(StockLikeVO slvo);
	public void addLike(StockLikeVO slvo);
	public void delLike(StockLikeVO slvo);
	public int countLike(String c_code);
	public List<CompanyVO> listLike(String slike_id);
    public String c_code_to_c_name(String c_code);
}
