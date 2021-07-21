package flow.mvc.controller.stockportfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StockPortfolioController {
	
	@RequestMapping("/estiInvestForm")
	public String estimationInvestForm() {
		System.out.println("투자 예상 폼으로 이동");
		return "stock/estiInvestForm";
	}
}
