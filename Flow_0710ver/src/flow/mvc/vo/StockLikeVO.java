package flow.mvc.vo;

public class StockLikeVO {
	
	private String slike_id, slike_code;
	
	// ResultMap Association 사용을 위한 VO 객체
	private MemberVO members;
	private CompanyVO company;
	

	public MemberVO getMembers() {
		return members;
	}

	public void setMembers(MemberVO members) {
		this.members = members;
	}

	public CompanyVO getCompany() {
		return company;
	}

	public void setCompany(CompanyVO company) {
		this.company = company;
	}

	public String getSlike_id() {
		return slike_id;
	}

	public void setSlike_id(String slike_id) {
		this.slike_id = slike_id;
	}

	public String getSlike_code() {
		return slike_code;
	}

	public void setSlike_code(String slike_code) {
		this.slike_code = slike_code;
	}
	
	

}
