package flow.mvc.vo;

import java.util.Date;

public class BlogVO {
	private int bl_num;
	private String m_id;
	private String bl_subject;
	private String bl_count;
	private Date bl_regdate;
	
	public int getBl_num() {
		return bl_num;
	}
	public void setBl_num(int bl_num) {
		this.bl_num = bl_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getBl_subject() {
		return bl_subject;
	}
	public void setBl_subject(String bl_subject) {
		this.bl_subject = bl_subject;
	}
	public String getBl_count() {
		return bl_count;
	}
	public void setBl_count(String bl_count) {
		this.bl_count = bl_count;
	}
	public Date getBl_regdate() {
		return bl_regdate;
	}
	public void setBl_regdate(Date bl_regdate) {
		this.bl_regdate = bl_regdate;
	}
	
	
}
