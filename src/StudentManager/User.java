package StudentManager;

public class User {
private String TenDN;
private String MatKhau;
private int Quyen;


public int getQuyen() {
	return Quyen;
}
public void setQuyen(int quyen) {
	Quyen = quyen;
}
public User(String tenDN) {
	TenDN = tenDN;
}
public User(String tenDN, String matKhau,int quyen) {
	super();
	TenDN = tenDN;
	MatKhau = matKhau;
	Quyen = quyen;
}
public String getTenDN() {
	return TenDN;
}
public void setTenDN(String tenDN) {
	TenDN = tenDN;
}
public String getMatKhau() {
	return MatKhau;
}
public void setMatKhau(String matKhau) {
	MatKhau = matKhau;
}

}
