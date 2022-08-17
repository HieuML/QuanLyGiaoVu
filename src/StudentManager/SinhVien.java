package StudentManager;

public class SinhVien {
private String MaSV;
private String HoTen;
private String NgaySinh;
private int GioiTinh;
private String DiaChi;
private String MaLop;
private String TenDN;

public String getMaSV() {
	return MaSV;
}
public String getTenDN() {
	return TenDN;
}
public void setTenDN(String tenDN) {
	TenDN = tenDN;
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
public String getNgaySinh() {
	return NgaySinh;
}
public void setNgaySinh(String ngaySinh) {
	NgaySinh = ngaySinh;
}
public SinhVien(String maSV) {
	super();
	MaSV = maSV;
}
public int getGioiTinh() {
	return GioiTinh;
}
public void setGioiTinh(int gioiTinh) {
	GioiTinh = gioiTinh;
}

public SinhVien(String maSV, String hoTen, String ngaySinh, int gioiTinh, String diaChi, String maLop, String tenDN) {
	super();
	MaSV = maSV;
	HoTen = hoTen;
	NgaySinh = ngaySinh;
	GioiTinh = gioiTinh;
	DiaChi = diaChi;
	MaLop = maLop;
	TenDN = tenDN;
}
public String getDiaChi() {
	return DiaChi;
}
public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
}
public String getMaLop() {
	return MaLop;
}
public void setMaLop(String maLop) {
	MaLop = maLop;
}


}
