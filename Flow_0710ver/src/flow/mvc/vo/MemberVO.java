package flow.mvc.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemberVO {

	private int m_num;
	private String m_id;
	private String m_pwd;
	private String m_name;
	private int m_division;
	private String m_jumin;
	private int m_tel;
	private String m_adate;
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
	
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_division() {
		return m_division;
	}
	public void setM_division(int m_division) {
		this.m_division = m_division;
	}
	public String getM_jumin() {
		return m_jumin;
	}
	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}
	public int getM_tel() {
		return m_tel;
	}
	public void setM_tel(int m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_adate() {
		return m_adate;
	}
	public void setM_adate(String m_adate) {
		this.m_adate = m_adate;
	}
	
	

}
