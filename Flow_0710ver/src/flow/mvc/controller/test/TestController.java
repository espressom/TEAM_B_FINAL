package flow.mvc.controller.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import flow.mvc.service.StockService;
import flow.mvc.vo.CompanyVO;

/**
 * @author 허태준 / 2021. 7. 18. / 오전 11:40:14
 */

@Controller
public class TestController {

	@Autowired
	private StockService stockService;

	@RequestMapping("/test")
	public String testPage() {
		return "test/test";
	}

	@RequestMapping("/news")
	public ModelAndView newsPage() throws Exception {
		ModelAndView mav = new ModelAndView();
		String url = "https://finance.naver.com/news/";
		String selector = "#newsMainTop > div > div.inner_area_left > div > div.main_news > ul > li > a";
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get(); // 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Elements titles = doc.select(selector); // 2. doc에서 selector의 내용을 가져와 Elementes 클래스에 담는다.

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (Element element : titles) {
			Map<String, String> map = new HashMap<>();
			map.put("title", element.text());
			map.put("href", "https://finance.naver.com" + element.attr("href"));
			list.add(map);
		}
		mav.addObject("list", list);
		mav.setViewName("test/news");

		return mav;
	}

	@GetMapping(value = { "/companyDetail" })
	public ModelAndView companyDetail2(String c_code, String slike_id) throws Exception {
		// 회사 상세정보 받아오기-----
		System.out.println("StockController - companyDetail");
		ModelAndView mav = new ModelAndView();
		CompanyVO cvo = stockService.companyDetail(c_code);

		// 좋아요 여부 받아오기-----
		// String slike_code = c_code;
		int status = stockService.LikeStatus(c_code, slike_id);

		mav.addObject("cvo", cvo);
		mav.addObject("likeStatus", status);
		List<Map<String, String>> list = newsPage2(c_code);
		mav.addObject("list", list);
		mav.setViewName("stock/companyDetail2");
		return mav;
	}

	private List<Map<String,String>> newsPage2(String c_code) throws Exception {
		String url = "https://finance.naver.com/item/news_news.nhn?code="+c_code;
		System.out.println("url :::::::: "+url);
		String selector = "body > div > table.type5 > tbody > tr > td.title > a";
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get(); // 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Elements titles = doc.select(selector); // 2. doc에서 selector의 내용을 가져와 Elementes 클래스에 담는다.
        System.out.println("?titles size? ::::: "+titles.size());
		List<Map<String,String>> list = new ArrayList<Map<String,String>>(); 
		int count = 0;
		for (Element element : titles) { 
			Map<String,String> map = new HashMap<>(); 
			map.put("title", element.text());
			System.out.println("???? ::::: "+element.text());
			String href = "https://finance.naver.com"+element.attr("href");
			map.put("href",href);
			String selector2 = "span.end_photo_org > img";
			doc = Jsoup.connect(href).get();
			Element img = doc.select(selector2).first();
			if (img != null) map.put("img",img.attr("src"));
			
			list.add(map);
			count += 1;
			if (count == 3){break;}
		}

		return list;
	}

}
