package flow.mvc.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import flow.mvc.service.StockService;
import flow.mvc.vo.CompanyVO;

/**
 * @author 허태준 / 2021. 5. 7. / 오전 10:00:01
 */
@Component
public class Suggest {
	private static Suggest suggest;
	private List<CompanyVO> clist;
	@Autowired
	private StockService stockService;

	public List<String> getSuggest2(String key) {
		if (clist == null)
			clist = stockService.companyList();
		List<String> sugList = new ArrayList<String>();
		// 자식 Element중에 keyword를 찾아서 List로 저장
		Iterator<CompanyVO> it = clist.iterator();
		// 사용자가 전달한 문자 또눈 문자열(n)을 대/소문자 구분없이 소문자로
		key = key.toLowerCase();
		while (it.hasNext()) {
			// Element객체가 가지고있는 문자열 봔한
			String result = it.next().getC_name();
			String compare = result.toLowerCase();
			/*
			 * 사용자가 입력한 값으로 시작하는 것인지 판단 compare.endsWith(key); // 마지막 글자 비교
			 */
//			첫글자 비교해서 검색값과 xml의 찾은 문자가 일치하면
			if (compare.startsWith(key)) {
				sugList.add(result);
			}
		}
		return sugList;

	}

	public List<Map<String,String>> getSuggest(String key) {
		if (clist == null)
			clist = stockService.companyList();
		List<Map<String,String>> sugList = new ArrayList<>();
		key = key.toLowerCase();
		for (CompanyVO vo : clist) {
			Map<String,String> map = new HashMap<String, String>();
			String c_name = vo.getC_name();
			String c_code = vo.getC_code();
			map.put("c_name", c_name);
			map.put("c_code", c_code);
			String compare = c_name.toLowerCase();
			if (compare.startsWith(key)) {
				sugList.add(map);
			}
		}
		return sugList;

	}

}
