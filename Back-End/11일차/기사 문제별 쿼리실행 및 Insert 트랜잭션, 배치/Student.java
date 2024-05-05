package sku.lesson.db.try1;

public class Student {
	private int stdNo;
	private String email;
	private int k_score;
	private int e_score;
	private int m_score;
	private int s_score;
	private int h_score;
	private int total_score;
	private String techer_code;
	private String good_code;
	private String region_code;
	
	public Student(int stdNo, String email, int k_score, int e_score, int m_score, int s_score, int h_score,
			int total_score, String techer_code, String good_code, String region_code) {
		this.stdNo = stdNo;
		this.email = email;
		this.k_score = k_score;
		this.e_score = e_score;
		this.m_score = m_score;
		this.s_score = s_score;
		this.h_score = h_score;
		this.total_score = total_score;
		this.techer_code = techer_code;
		this.good_code = good_code;
		this.region_code = region_code;
	}
	
	public int getStdNo() {
		return stdNo;
	}
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getK_score() {
		return k_score;
	}
	public void setK_score(int k_score) {
		this.k_score = k_score;
	}
	public int getE_score() {
		return e_score;
	}
	public void setE_score(int e_score) {
		this.e_score = e_score;
	}
	public int getM_score() {
		return m_score;
	}
	public void setM_score(int m_score) {
		this.m_score = m_score;
	}
	public int getS_score() {
		return s_score;
	}
	public void setS_score(int s_score) {
		this.s_score = s_score;
	}
	public int getH_score() {
		return h_score;
	}
	public void setH_score(int h_score) {
		this.h_score = h_score;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public String getTecher_code() {
		return techer_code;
	}
	public void setTecher_code(String techer_code) {
		this.techer_code = techer_code;
	}
	public String getGood_code() {
		return good_code;
	}
	public void setGood_code(String good_code) {
		this.good_code = good_code;
	}
	public String getRegion_code() {
		return region_code;
	}
	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}
	
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", email=" + email + ", k_score=" + k_score + ", e_score=" + e_score
				+ ", m_score=" + m_score + ", s_score=" + s_score + ", h_score=" + h_score + ", total_score="
				+ total_score + ", techer_code=" + techer_code + ", good_code=" + good_code + ", region_code="
				+ region_code + "]";
	}

}
