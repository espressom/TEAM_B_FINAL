package flow.mvc.vo;

import java.util.Date;

public class BoardVO {
	private int b_num;
	private int bl_num;
	private String b_subject;
	private String b_content;
	private String b_category;
	private String b_filename;
	private Date b_regdate;
	
	public int getBl_num() {
		return bl_num;
	}
	public void setBl_num(int bl_num) {
		this.bl_num = bl_num;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_subject() {
		return b_subject;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_category() {
		return b_category;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public String getB_filename() {
		return b_filename;
	}
	public void setB_filename(String b_filename) {
		this.b_filename = b_filename;
	}
	public Date getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}
	
	
}
