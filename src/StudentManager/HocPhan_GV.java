package StudentManager;

public class HocPhan_GV {
private String MaHocPhan;
private String MaGV;
private String HocKi;
private int SoLop;
public HocPhan_GV(String maHocPhan, String maGV, String hocKi, int soLop) {
	super();
	MaHocPhan = maHocPhan;
	MaGV = maGV;
	HocKi = hocKi;
	SoLop = soLop;
}
public String getMaHocPhan() {
	return MaHocPhan;
}
public void setMaHocPhan(String maHocPhan) {
	MaHocPhan = maHocPhan;
}
public HocPhan_GV(String maHocPhan, String maGV, String hocKi) {
	super();
	MaHocPhan = maHocPhan;
	MaGV = maGV;
	HocKi = hocKi;
}
public String getMaGV() {
	return MaGV;
}
public void setMaGV(String maGV) {
	MaGV = maGV;
}
public String getHocKi() {
	return HocKi;
}
public void setHocKi(String hocKi) {
	HocKi = hocKi;
}
public int getSoLop() {
	return SoLop;
}
public void setSoLop(int soLop) {
	SoLop = soLop;
}

}
