package StudentManager;

public class Diem {
private String MaSV;
private String MaHocPhan;
private String HocKi;
private float DiemGK;
private float DiemCK;
private float DiemTong;
private String DiemChu;
private String GhiChu;
public Diem(String maSV, String maHocPhan, String hocKi, float diemGK, float diemCK, float diemTong, String diemChu,
		String ghiChu) {
	super();
	MaSV = maSV;
	MaHocPhan = maHocPhan;
	HocKi = hocKi;
	DiemGK = diemGK;
	DiemCK = diemCK;
	DiemTong = diemTong;
	DiemChu = diemChu;
	GhiChu = ghiChu;
}
public Diem(String maSV, String maHocPhan, String hocKi) {
	super();
	MaSV = maSV;
	MaHocPhan = maHocPhan;
	HocKi = hocKi;
}
public String getMaSV() {
	return MaSV;
}
public void setMaSV(String maSV) {
	MaSV = maSV;
}
public String getMaHocPhan() {
	return MaHocPhan;
}
public void setMaHocPhan(String maHocPhan) {
	MaHocPhan = maHocPhan;
}
public String getHocKi() {
	return HocKi;
}
public void setHocKi(String hocKi) {
	HocKi = hocKi;
}
public float getDiemGK() {
	return DiemGK;
}
public void setDiemGK(float diemGK) {
	DiemGK = diemGK;
}
public float getDiemCK() {
	return DiemCK;
}
public void setDiemCK(float diemCK) {
	DiemCK = diemCK;
}
public float getDiemTong() {
	return DiemTong;
}
public void setDiemTong(float diemTong) {
	DiemTong = diemTong;
}

public String getDiemChu() {
	return DiemChu;
}
public void setDiemChu(String diemChu) {
	DiemChu = diemChu;
}
public String getGhiChu() {
	return GhiChu;
}
public void setGhiChu(String ghiChu) {
	GhiChu = ghiChu;
}



}
