package flow.mvc.controller.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import flow.mvc.service.StockService;
import flow.mvc.vo.CompanyVO;
import flow.mvc.vo.StockLikeVO;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;
 

	@RequestMapping("/companyList")
	public ModelAndView companyList() {
		System.out.println("StockController - companyList");
		ModelAndView mav = new ModelAndView();
		List<CompanyVO> clist = stockService.companyList();
		
		mav.addObject("clist", clist);
		mav.setViewName("stock/companyList");
		return mav;
	}
	
	@GetMapping(value = {"/companyDetail"})
	public ModelAndView companyDetail(String c_code, String slike_id) {
		// 회사 상세정보 받아오기-----
		System.out.println("StockController - companyDetail");
		ModelAndView mav = new ModelAndView();
		CompanyVO cvo = stockService.companyDetail(c_code);
		String price = stockService.stockPrice(c_code);
		
		// 좋아요 여부 받아오기-----
		int status = stockService.LikeStatus(c_code, slike_id);
		
		mav.addObject("cvo", cvo);
		mav.addObject("price", price);
		mav.addObject("likeStatus", status);
	 
		mav.setViewName("stock/companyDetail");
		return mav;
	}
	
	@GetMapping(value="/likeStatus")
	public @ResponseBody int likeStatus(String slike_code, String slike_id) {
		int res = stockService.LikeUpdate(slike_code, slike_id);
		
		return res;
	}
	
	@GetMapping(value="/myPortfolio")
	public ModelAndView myPortfolio(String slike_id) {
		System.out.println("StockController - myPortfolio");
		ModelAndView mav = new ModelAndView();

		// 종목코드 + 종목이름
		List<CompanyVO> slist = stockService.listLike(slike_id);
	
	
		mav.addObject("slist", slist);


		mav.setViewName("stock/myPortfolio");
		return mav;
	}
	

}
