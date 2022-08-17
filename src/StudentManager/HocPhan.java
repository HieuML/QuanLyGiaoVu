package StudentManager;

public class HocPhan {
		private String MaHocPhan;
		private String TenHocPhan;
		private int SoTin;
		private String MaKhoa;
		public String getMaHocPhan() {
			return MaHocPhan;
		}
		public void setMaHocPhan(String maHocPhan) {
			MaHocPhan = maHocPhan;
		}
		public String getTenHocPhan() {
			return TenHocPhan;
		}
		public void setTenHocPhan(String tenHocPhan) {
			TenHocPhan = tenHocPhan;
		}
		public int getSoTin() {
			return SoTin;
		}
		public void setSoTin(int soTin) {
			SoTin = soTin;
		}
	
		public String getMaKhoa() {
			return MaKhoa;
		}
		public void setMaKhoa(String maKhoa) {
			MaKhoa = maKhoa;
		}
		public HocPhan(String maHocPhan, String tenHocPhan, int soTin, String maKhoa) {
			super();
			MaHocPhan = maHocPhan;
			TenHocPhan = tenHocPhan;
			SoTin = soTin;
			MaKhoa = maKhoa;
		}
		public HocPhan(String maHocPhan) {
			super();
			MaHocPhan = maHocPhan;
		}
	
		
}
