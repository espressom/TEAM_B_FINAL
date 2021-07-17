package flow.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flow.mvc.dao.stock.StockDaoInter;
import flow.mvc.vo.CompanyVO;
import flow.mvc.vo.StockLikeVO;


@Service
@Transactional
public class StockService {

	@Autowired
	private StockDaoInter stockDaoInter;

	public List<CompanyVO> companyList() {
		return stockDaoInter.companyList();
	}

	public CompanyVO companyDetail(String c_code) {
		return stockDaoInter.companyDetail(c_code);
	}

	
	// 좋아요 받아오기
	public int LikeStatus(String slike_code, String slike_id) {
		StockLikeVO slvo = new StockLikeVO();
		System.out.println("LikeStatus param : " + slike_code + slike_id);
		slvo.setSlike_code(slike_code); 
		slvo.setSlike_id(slike_id);
		int res = stockDaoInter.getLike(slvo);
		System.out.println("StockService res : " + res);
		return res;
	}

	
}
