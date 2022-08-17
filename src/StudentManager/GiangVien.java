package StudentManager;

public class GiangVien {
private String MaGV;
private String TenGV;
private int GioiTinh;
private String Phone;
private String Email;
private String PhanLoaiGV;
private String TenDN;
public String getMaGV() {
	return MaGV;
}
public void setMaGV(String maGV) {
	MaGV = maGV;
}
public String getTenGV() {
	return TenGV;
}
public String getTenDN() {
	return TenDN;
}
public void setTenDN(String tenDN) {
	TenDN = tenDN;
}
public void setTenGV(String tenGV) {
	TenGV = tenGV;
}
public int getGioiTinh() {
	return GioiTinh;
}
public void setGioiTinh(int gioiTinh) {
	GioiTinh = gioiTinh;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPhanLoaiGV() {
	return PhanLoaiGV;
}
public void setPhanLoaiGV(String phanLoaiGV) {
	PhanLoaiGV = phanLoaiGV;
}

public GiangVien(String maGV, String tenGV, int gioiTinh, String phone, String email, String phanLoaiGV, String tenDN) {
	super();
	MaGV = maGV;
	TenGV = tenGV;
	GioiTinh = gioiTinh;
	Phone = phone;
	Email = email;
	PhanLoaiGV = phanLoaiGV;
	TenDN = tenDN;
}
public GiangVien(String maGV) {
	MaGV = maGV;
}



}
