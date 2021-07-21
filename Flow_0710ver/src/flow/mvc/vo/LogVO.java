package flow.mvc.vo;

/**
 * @author 허태준 / 2021. 7. 21. / 오후 2:58:08
 */
public class LogVO {
/*
 *  LOG_NUM NUMBER, 
	M_ID VARCHAR2(50 BYTE), 
	M_IP VARCHAR2(50 BYTE), 
	UAGENT VARCHAR2(300 BYTE), 
	REQUEST VARCHAR2(50 BYTE), 
    PARAMS VARCHAR2(100 BYTE),
	LOG_DATE DATE DEFAULT sysdate, 
 * */
	
	private int log_num;
	private String m_id,m_ip,uagent,request,params,log_date;
	
	public int getLog_num() {
		return log_num;
	}
	public void setLog_num(int log_num) {
		this.log_num = log_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_ip() {
		return m_ip;
	}
	public void setM_ip(String m_ip) {
		this.m_ip = m_ip;
	}
	public String getUagent() {
		return uagent;
	}
	public void setUagent(String uagent) {
		this.uagent = uagent;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getLog_date() {
		return log_date;
	}
	public void setLog_date(String log_date) {
		this.log_date = log_date;
	}
	
}
