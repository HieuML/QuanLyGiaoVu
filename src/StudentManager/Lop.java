package StudentManager;

public class Lop {
private String MaLop;
private String TenLop;
private String MaKhoa;
public String getMaLop() {
	return MaLop;
}
public void setMaLop(String maLop) {
	MaLop = maLop;
}
public String getTenLop() {
	return TenLop;
}
public void setTenLop(String tenLop) {
	TenLop = tenLop;
}
public String getMaKhoa() {
	return MaKhoa;
}
public Lop(String maLop) {
	super();
	MaLop = maLop;
}
public Lop(String maLop, String tenLop, String maKhoa) {
	super();
	MaLop = maLop;
	TenLop = tenLop;
	MaKhoa = maKhoa;
}
public void setMaKhoa(String maKhoa) {
	MaKhoa = maKhoa;
}

}
