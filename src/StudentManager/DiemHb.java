package StudentManager;

public class DiemHb {
private String MaKhoa;
private String TenKhoa;
private String HocKi;
private String MaSv;
private String HoTen;
private float GPA;
private String LoaiHb;
public DiemHb(String maKhoa, String tenKhoa, String hocKi, String maSv, String hoTen, float gPA, String loaiHb) {
	super();
	MaKhoa = maKhoa;
	TenKhoa = tenKhoa;
	HocKi = hocKi;
	MaSv = maSv;
	HoTen = hoTen;
	GPA = gPA;
	LoaiHb = loaiHb;
}
public String getMaKhoa() {
	return MaKhoa;
}
public void setMaKhoa(String maKhoa) {
	MaKhoa = maKhoa;
}
public String getTenKhoa() {
	return TenKhoa;
}
public void setTenKhoa(String tenKhoa) {
	TenKhoa = tenKhoa;
}
public String getHocKi() {
	return HocKi;
}
public void setHocKi(String hocKi) {
	HocKi = hocKi;
}
public String getMaSv() {
	return MaSv;
}
public void setMaSv(String maSv) {
	MaSv = maSv;
}
public String getHoTen() {
	return HoTen;
}
public void setHoTen(String hoTen) {
	HoTen = hoTen;
}
public float getGPA() {
	return GPA;
}
public void setGPA(float gPA) {
	GPA = gPA;
}
public String getLoaiHb() {
	return LoaiHb;
}
public void setLoaiHb(String loaiHb) {
	LoaiHb = loaiHb;
}

}
