package flow.mvc.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompanyVO {

	private String c_code, c_name, c_type, c_product, c_ipo, 
	c_closingmonth, c_ceo, c_homepage, c_location, c_price;

	// 마이페이지 - 내 관심좀옥 ResultMap을 위한 객체
	private StockLikeVO stocklike;
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String result=null;
		try {
			result = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
 
	public String getC_price() {
		return c_price;
	}

	public void setC_price(String c_price) {
		this.c_price = c_price;
	}

	public StockLikeVO getStocklike() {
		return stocklike;
	}

	public void setStocklike(StockLikeVO stocklike) {
		this.stocklike = stocklike;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public String getC_product() {
		return c_product;
	}

	public void setC_product(String c_product) {
		this.c_product = c_product;
	}

	public String getC_ipo() {
		return c_ipo;
	}

	public void setC_ipo(String c_ipo) {
		this.c_ipo = c_ipo;
	}

	public String getC_closingmonth() {
		return c_closingmonth;
	}

	public void setC_closingmonth(String c_closingmonth) {
		this.c_closingmonth = c_closingmonth;
	}

	public String getC_ceo() {
		return c_ceo;
	}

	public void setC_ceo(String c_ceo) {
		this.c_ceo = c_ceo;
	}

	public String getC_homepage() {
		return c_homepage;
	}

	public void setC_homepage(String c_homepage) {
		this.c_homepage = c_homepage;
	}

	public String getC_location() {
		return c_location;
	}

	public void setC_location(String c_location) {
		this.c_location = c_location;
	}
	
	
	
}
