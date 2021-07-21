package flow.mvc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import flow.mvc.dao.stock.StockDaoInter;
import flow.mvc.vo.CompanyVO;
import flow.mvc.vo.StockLikeVO;


@Service
@Transactional
public class StockService {

	private final static int LIKE = 1;
	private final static int UNLIKE = -1;
	
	@Autowired
	private StockDaoInter stockDaoInter;

	public List<CompanyVO> companyList() {
		return stockDaoInter.companyList();
	}

	public CompanyVO companyDetail(String c_code) {
		return stockDaoInter.companyDetail(c_code);
	}
	
	// 사업장 주소 받아오기 (작업중)
	public void companyMap(String c_code) {
		System.out.println("Service - companyMap : " + c_code);
		String key = "5e52b565665c28032cdf2b64260b2a80313b2a64";
		String url = "https://opendart.fss.or.kr/api/company.json?crtfc_key="+key+"&corp_code=00126380";
		
	}
	
	// 종목별 실시간 가격 받아오기
	public String stockPrice(String c_code) {

		String url = "https://finance.naver.com/item/main.nhn?code="+c_code;
		String today = "#chart_area > div.rate_info > div > p.no_today > em > .blind";
		Document doc = null;

	      try {
	         doc = Jsoup.connect(url).get(); // 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.
	      } catch (IOException e) {
	         System.out.println(e.getMessage());
	      }

	      Elements ele = doc.select(today); // 2. doc에서 selector의 내용을 가져와 Elementes 클래스에 담는다.
	      String price = ele.text();
	      System.out.println(price);
	      return price;
	
	}
	
	

	// 내 관심종목 (좋아요) 에 표시될 종목 가격정보
	public List<CompanyVO> listLike(String slike_id) {
		List<CompanyVO> slist = stockDaoInter.listLike(slike_id);
 
		
		String today_sel = "#chart_area > div.rate_info > div > p.no_today > em > .blind";
		String exday_sel = "#chart_area > div.rate_info > table > tbody > tr:nth-child(1) > td.first > em > span.blind";
		String comp_sel = "#chart_area > div.rate_info > div > p.no_exday > em > span:nth-child(1)"; // 하락이냐 상승이냐
		
		String comp_pri_sel="#chart_area > div.rate_info > div > p.no_exday > em:nth-child(2) > span.blind";
		String comp_per_sel="#chart_area > div.rate_info > div > p.no_exday > em:nth-child(4) > span.blind";
		
		String open_sel = "#chart_area > div.rate_info > table > tbody > tr:nth-child(2) > td.first > em > span.blind";
		String high_sel = "#chart_area > div.rate_info > table > tbody > tr:nth-child(1) > td:nth-child(2) > em > span.blind "; 
		String low_sel = "#chart_area > div.rate_info > table > tbody > tr:nth-child(2) > td:nth-child(2) > em > span.blind ";  
		String volume_sel = "#chart_area > div.rate_info > table > tbody > tr:nth-child(1) > td:nth-child(3) > em > span.blind";
		
		Document doc = null;
		
		for (CompanyVO c : slist) {
			String url = "https://finance.naver.com/item/main.nhn?code="+c.getC_code();
			
			 try {
		         doc = Jsoup.connect(url).get(); // 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.
		      } catch (IOException e) {
		         System.out.println(e.getMessage());
		      }
		
		Elements today_ele = doc.select(today_sel); // 2. doc에서 selector의 내용을 가져와 Elementes 클래스에 담는다.
		Elements exday_ele = doc.select(exday_sel);
		Elements comp_ele = doc.select(comp_sel);
		
		Elements comp_pri_ele = doc.select(comp_pri_sel);
		Elements comp_per_ele = doc.select(comp_per_sel);
	
		Elements open_ele =  doc.select(open_sel);
		Elements high_ele =  doc.select(high_sel);
		Elements low_ele =  doc.select(low_sel);
		Elements volume_ele =  doc.select(volume_sel);
	
		String today = today_ele.text(); //오늘가격
		String exday = exday_ele.text(); // size=2size=2 size=2전일가격
		String compare = comp_ele.text(); // 전일비 (상승/하락)
		String comp_pri = comp_pri_ele.text(); // 전일비 (가격)
		String comp_per = comp_per_ele.text(); // 전일비 (비율)
		String open = open_ele.text(); // 시가
		String high = high_ele.text(); // 고가
		String low = low_ele.text(); // 저가
		String volume = volume_ele.text(); // 거래량
		
		
		
		c.setPrice(today);
		c.setExday(exday);
		c.setCompare(compare);
		c.setCom_price(comp_pri);
		c.setCom_percent(comp_per);
		c.setOpen(open);
		c.setLow(low);
		c.setVolume(volume);
		c.setHigh(high); 
		}
 
 
	return slist;
	}
	 
	
	
	// 좋아요 받아오기
	public int LikeStatus(String slike_code, String slike_id) {
		StockLikeVO slvo = new StockLikeVO();
		slvo.setSlike_code(slike_code); 
		slvo.setSlike_id(slike_id);
		
		int res = stockDaoInter.getLike(slvo);
		return res;
	}

 
	// 좋아요 눌렀을 때 
	public @ResponseBody int LikeUpdate(String c_code, String slike_id) {
		StockLikeVO slvo = new StockLikeVO();
		slvo.setSlike_code(c_code); 
		slvo.setSlike_id(slike_id); 
		int res = stockDaoInter.getLike(slvo);
		
		if (res != 0) {
			stockDaoInter.delLike(slvo);
			res = UNLIKE;
		} else {
			stockDaoInter.addLike(slvo);
			res = LIKE;
		}

		return res;
	}
	
	public String c_code_to_c_name(String c_code) {
		return stockDaoInter.c_code_to_c_name(c_code);
	}
  
}
