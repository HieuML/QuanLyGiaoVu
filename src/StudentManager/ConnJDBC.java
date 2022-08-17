package StudentManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnJDBC {
	
	static String url = "jdbc:mysql://localhost:3306/studentmanager";
	static String user = "root";
	static String password = "123456789";

	public static Connection getConnection() {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static List<User>findAllUser(){
			List<User> userList = new ArrayList<>();
			String query = "select * from login order by quyen";
			try {
				Connection connection = getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					User user = new User(rs.getString("TenDN"), rs.getString("MatKhau"),rs.getInt("Quyen"));
					userList.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return userList;
		}
	
	
	public static List<GiangVien>findAllGV(){
		List<GiangVien> giangVienList = new ArrayList<>();
		String query = "select * from giang_vien";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				GiangVien giangVien = new GiangVien(rs.getString("MaGV"), rs.getString("TenGV"), rs.getInt("GioiTinh"), rs.getString("Phone"), rs.getString("Email"),rs.getString("PhanLoaiGV"),rs.getString("TenDN"));
				giangVienList.add(giangVien);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giangVienList;
	}
	
	public static List<HocPhan>findAllHocPhan(){
		List<HocPhan>hocPhanList = new ArrayList<>();
		String query = "select * from HocPhan";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				HocPhan hocPhan = new HocPhan(rs.getString("MaHocPhan"), rs.getString("TenHocPhan"), rs.getInt("SoTin"), rs.getString("MaKhoa"));
				hocPhanList.add(hocPhan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hocPhanList;
	}
	public static List<Khoa>findAllKhoa(){
		List<Khoa> khoaList = new ArrayList<>();
		String query = "select * from khoa";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Khoa khoa = new Khoa(rs.getString("MaKhoa"), rs.getString("TenKhoa"));
				khoaList.add(khoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khoaList;
	}
	
	public static List<Lop>findAllLop(){
		List<Lop>lopList = new ArrayList<>();
		String query = "select * from lop";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Lop lop = new Lop(rs.getString("MaLop"), rs.getString("TenLop"), rs.getString("MaKhoa"));
				lopList.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lopList;
	}
	
	public static List<SinhVien>findAllSV(){
		List<SinhVien> svList = new ArrayList<>();
		String query = "select * from sinh_vien";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				SinhVien sv = new SinhVien(rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("NgaySinh"), rs.getInt("GioiTinh"), rs.getString("DiaChi"), rs.getString("MaLop"), rs.getString("TenDN"));
				svList.add(sv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return svList;
	}
	
	public static List<Diem>findAllDiem(){
		List<Diem> diemList = new ArrayList<>();
		String query = "select * from diem";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Diem diem = new Diem(rs.getString("MaSV"), rs.getString("MaHocPhan"), rs.getString("HocKi"), rs.getFloat("DiemGK"), rs.getFloat("DiemCK"), rs.getFloat("DiemTong"), rs.getString("DiemChu"), rs.getString("GhiChu"));
				diemList.add(diem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diemList;
	}

	public static List<HocPhan_GV>findAllGvHp(){
		List<HocPhan_GV> GvHpList = new ArrayList<>();
		String query = "select * from hocphan_gv";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				HocPhan_GV hp_gv = new HocPhan_GV(rs.getString("MaHocPhan"), rs.getString("MaGV"), rs.getString("HocKi"), rs.getInt("SoLop"));
				GvHpList.add(hp_gv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return GvHpList;
	}
	public static void insertUser(User user) {
		String query = "Insert into login(TenDN,MatKhau,Quyen) values(?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, user.getTenDN());
			pstmt.setString(2, user.getMatKhau());
			pstmt.setInt(3, user.getQuyen());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertGV(GiangVien giangVien) {
		String query = "Insert into giang_vien(MaGV,TenGV,GioiTinh,Phone,Email,PhanLoaiGV,TenDN) values(?,?,?,?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, giangVien.getMaGV());
			pstmt.setString(2, giangVien.getTenGV());
			pstmt.setInt(3, giangVien.getGioiTinh());
			pstmt.setString(4, giangVien.getPhone());
			pstmt.setString(5, giangVien.getEmail());
			pstmt.setString(6, giangVien.getPhanLoaiGV());
			pstmt.setString(7, giangVien.getTenDN());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertHocPhan(HocPhan hocPhan) {
		String query = "Insert into HocPhan(MaHocPhan,TenHocPhan,SoTin,MaKhoa) values(?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, hocPhan.getMaHocPhan());
			pstmt.setString(2, hocPhan.getTenHocPhan());
			pstmt.setInt(3, hocPhan.getSoTin());
			pstmt.setString(4, hocPhan.getMaKhoa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void insertKhoa(Khoa khoa) {
		String query = "Insert into khoa(MaKhoa,TenKhoa) values(?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, khoa.getMaKhoa());
			pstmt.setString(2, khoa.getTenKhoa());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertLop(Lop lop) {
		String query = "Insert into lop(MaLop,TenLop, MaKhoa) values(?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, lop.getMaLop());
			pstmt.setString(2, lop.getTenLop());
			pstmt.setString(3, lop.getMaKhoa());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertSV(SinhVien sv) {
		String query = "Insert into sinh_vien(MaSV,HoTen,NgaySinh,GioiTinh,DiaChi,MaLop,TenDN) values(?,?,?,?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, sv.getMaSV());
			pstmt.setString(2, sv.getHoTen());
			pstmt.setString(3, sv.getNgaySinh());
			pstmt.setInt(4, sv.getGioiTinh());
			pstmt.setString(5, sv.getDiaChi());
			pstmt.setString(6, sv.getMaLop());
			pstmt.setString(7, sv.getTenDN());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertDiem(Diem diem) {
		String query = "Insert into diem(MaSV,MaHocPhan,HocKi,DiemGK,DiemCK,DiemTong,DiemChu,GhiChu) values(?,?,?,?,?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, diem.getMaSV());
			pstmt.setString(2, diem.getMaHocPhan());
			pstmt.setString(3, diem.getHocKi());
			pstmt.setFloat(4, diem.getDiemGK());
			pstmt.setFloat(5, diem.getDiemCK());
			pstmt.setFloat(6, diem.getDiemTong());
			pstmt.setString(7, diem.getDiemChu());
			pstmt.setString(8, diem.getGhiChu());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertGvHp(HocPhan_GV hp_gv) {
		String query = "Insert into hocphan_gv(MaHocPhan,MaGV,HocKi,SoLop) values(?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, hp_gv.getMaHocPhan());
			pstmt.setString(2, hp_gv.getMaGV());
			pstmt.setString(3, hp_gv.getHocKi());
			pstmt.setInt(4, hp_gv.getSoLop());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(User user) {
		String query = "delete from login where TenDN = '" + user.getTenDN() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteGV(GiangVien giangVien) {
		String query = "delete from giang_vien where MaGV = '" + giangVien.getMaGV() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteHocPhan(HocPhan hocPhan) {
		String query = "delete from hocPhan where MaHocPhan = '" + hocPhan.getMaHocPhan() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteKhoa(Khoa khoa) {
		String query = "delete from khoa where MaKhoa = '" + khoa.getMaKhoa() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteLop(Lop lop) {
		String query = "delete from lop where MaLop = '" + lop.getMaLop() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteSV(SinhVien sv) {
		String query = "delete from sinh_vien where MaSV = '" + sv.getMaSV() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deleteDiem(Diem diem) {
		String query = "delete from diem where MaSV = '" + diem.getMaSV() +"' and MaHocPhan = '" + diem.getMaHocPhan() + "' and HocKi = '" + diem.getHocKi() + "';";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteGvHp(HocPhan_GV hp_gv) {
		String query = "delete from hocphan_gv where MaHocPhan = '" + hp_gv.getMaHocPhan() + "'" +" and MaGV = '" + hp_gv.getMaGV() + "'" + " and HocKi = '" + hp_gv.getHocKi() +"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateUser(User user) {
		String query = "Update login set MatKhau = ?, Quyen = ? where TenDN = '" + user.getTenDN() +"'" ;

		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, user.getMatKhau());
			pstmt.setInt(2, user.getQuyen());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateGV(GiangVien giangVien) {
		String query = "Update giang_vien set TenGV = ?, GioiTinh = ?, Phone = ?, Email = ?, PhanLoaiGV = ?, TenDN = ? where MaGV = '" + giangVien.getMaGV() +"'" ;

		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, giangVien.getTenGV());
			pstmt.setInt(2, giangVien.getGioiTinh());
			pstmt.setString(3, giangVien.getPhone());
			pstmt.setString(4, giangVien.getEmail());
			pstmt.setString(5, giangVien.getPhanLoaiGV());
			pstmt.setString(6, giangVien.getTenDN());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateHocPhan(HocPhan hocPhan) {
		String query = "Update hocPhan set TenHocPhan = ?, SoTin = ?, MaKhoa = ? where MaHocPhan = '" + hocPhan.getMaHocPhan() +"'" ;

		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, hocPhan.getTenHocPhan());
			pstmt.setInt(2, hocPhan.getSoTin());
			pstmt.setString(3, hocPhan.getMaKhoa());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateKhoa(Khoa khoa) {
		String query = "Update khoa set TenKhoa = ? where MaKhoa = '" + khoa.getMaKhoa() +"'" ;

		try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, khoa.getTenKhoa());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		public static void updateLop(Lop lop) {
			String query = "Update lop set TenLop = ?, MaKhoa = ? where MaLop = '" + lop.getMaLop() +"'" ;

			try {
				Connection connection = getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setString(1, lop.getTenLop());
				pstmt.setString(2, lop.getMaKhoa());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
		public static void updateSV(SinhVien sv) {
			String query = "Update sinh_vien set HoTen = ?, NgaySinh = ?, GioiTinh = ?, DiaChi = ?, MaLop = ?, TenDN = ? where MaSV = '" + sv.getMaSV() +"'" ;

			try {
				Connection connection = getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setString(1, sv.getHoTen());
				pstmt.setString(2, sv.getNgaySinh());
				pstmt.setInt(3, sv.getGioiTinh());
				pstmt.setString(4, sv.getDiaChi());
				pstmt.setString(5, sv.getMaLop());
				pstmt.setString(6, sv.getTenDN());

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		public static void updateDiem(Diem diem) {
			String query = "Update diem set DiemGK = ?, DiemCK = ?, DiemTong = ?, DiemChu = ?, GhiChu = ? where MaSV = '" + diem.getMaSV() +"' and MaHocPhan = '" + diem.getMaHocPhan() + "' and HocKi = '" + diem.getHocKi() + "';";

			try {
				Connection connection = getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setFloat(1, diem.getDiemGK());
				pstmt.setFloat(2, diem.getDiemCK());
				pstmt.setFloat(3, diem.getDiemTong());
				pstmt.setString(4, diem.getDiemChu());
				pstmt.setString(5, diem.getGhiChu());

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		public static void updateGvHp(HocPhan_GV hp_gv) {
			String query = "Update hocphan_gv set SoLop = ? where MaHocPhan = '" + hp_gv.getMaHocPhan() + "'" +" and MaGV = '" + hp_gv.getMaGV() + "'" + " and HocKi = '" + hp_gv.getHocKi() + "'";

			try {
				Connection connection = getConnection();
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setInt(1, hp_gv.getSoLop());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
