package StudentManager;

public class DiemTb {
	private String MaSV;
	private String HoTen;
	private String HocKi;
	private float GPA;
	private float CPA;
	
	public float getCPA() {
		return CPA;
	}
	public void setCPA(float cPA) {
		CPA = cPA;
	}
	public String getMaSV() {
		return MaSV;
	}
	public void setMaSV(String maSV) {
		MaSV = maSV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getHocKi() {
		return HocKi;
	}
	public void setHocKi(String hocKi) {
		HocKi = hocKi;
	}
	public float getGPA() {
		return GPA;
	}
	public void setGPA(float gPA) {
		GPA = gPA;
	}
	public DiemTb(String maSV, String hoTen, String hocKi, float gPA, float cPA) {
		super();
		MaSV = maSV;
		HoTen = hoTen;
		HocKi = hocKi;
		GPA = gPA;
		CPA = cPA;
	}
	
}




