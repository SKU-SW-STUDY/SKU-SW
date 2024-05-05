package sku.lesson.dto;

public class StudentDTO {
	private int std_no;
	private String email;
	private int kor; 
	private int eng; 
	private int math;
	private int sci;
	private int hist;
	private int total;
	private String mag_code;
	private String acc_code;
	private String loc_code;
	
	public StudentDTO(int std_no, String email, int kor, int eng, int math, int sci, int hist, int total, String mag_code,
			String acc_code, String loc_code) {
		this.std_no = std_no;
		this.email = email;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sci = sci;
		this.hist = hist;
		this.total = total;
		this.mag_code = mag_code;
		this.acc_code = acc_code;
		this.loc_code = loc_code;
	}

	public int getStd_no() {
		return std_no;
	}

	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}

	public int getHist() {
		return hist;
	}

	public void setHist(int hist) {
		this.hist = hist;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getMag_code() {
		return mag_code;
	}

	public void setMag_code(String mag_code) {
		this.mag_code = mag_code;
	}

	public String getAcc_code() {
		return acc_code;
	}

	public void setAcc_code(String acc_code) {
		this.acc_code = acc_code;
	}

	public String getLoc_code() {
		return loc_code;
	}

	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}

	@Override
	public String toString() {
		return "Student [std_no=" + std_no + ", email=" + email + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", sci=" + sci + ", hist=" + hist + ", total=" + total + ", mag_code=" + mag_code + ", acc_code="
				+ acc_code + ", loc_code=" + loc_code + "]";
	}
}
