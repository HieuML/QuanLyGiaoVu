package StudentManager;

public class Khoa {
private String MaKhoa;
private String TenKhoa;
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
public Khoa(String maKhoa, String tenKhoa) {
	super();
	MaKhoa = maKhoa;
	TenKhoa = tenKhoa;
}
public Khoa(String maKhoa) {
	super();
	MaKhoa = maKhoa;
}

}
