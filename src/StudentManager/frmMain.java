package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class frmMain extends JFrame {

	/**
	 * Launch the application.
	 */

	List<DiemTb> diemTbList;
	List<DiemHb> diemHbList;
	int i = 1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setTitle("Qu\u1EA3n l\u00FD \u0111i\u1EC3m sinh vi\u00EAn \u0110\u1EA1i H\u1ECDc B\u00E1ch Khoa H\u00E0 N\u1ED9i");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("H\u1EC7 th\u1ED1ng");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmDangNhap ah = new frmDangNhap();
                ah.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDoiMatKhau ah = new frmDoiMatKhau();
                ah.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Qu\u1EA3n l\u00FD ng\u01B0\u1EDDi d\u00F9ng");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
				frmQuanLyNguoiDung ah = new frmQuanLyNguoiDung();
                ah.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("Danh m\u1EE5c");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("H\u1ECDc Ph\u1EA7n ");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQuanLyHocPhan ah = new frmQuanLyHocPhan();
                ah.setVisible(true);

			}
		});
		
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Khoa");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKhoa ah = new frmKhoa();
                ah.setVisible(true);

			}
		});
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("L\u1EDBp");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLop ah = new frmLop();
                ah.setVisible(true);

			}
		});
		JMenu mnNewMenu_3 = new JMenu("Qu\u1EA3n l\u00FD");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Sinh vi\u00EAn");
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQLSV ah = new frmQLSV();
                ah.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Gi\u1EA3ng vi\u00EAn");
		mnNewMenu_3.add(mntmNewMenuItem_10);
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQLGV ah = new frmQLGV();
                ah.setVisible(true);

			}
		});
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u0110i\u1EC3m m\u00F4n h\u1ECDc");
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmQLDiem ah = new frmQLDiem();
                ah.setVisible(true);

			}
		});
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Học phần - Giảng viên");
		mnNewMenu_3.add(mntmNewMenuItem_12);
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGvHp ah = new frmGvHp();
                ah.setVisible(true);

			}
		});
		
		JMenu mnNewMenu_5 = new JMenu("Th\u1ED1ng k\u00EA");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Danh s\u00E1ch SV");
		mnNewMenu_5.add(mntmNewMenuItem_15);
		
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement getDanhSachSv = connection
								.prepareStatement("SELECT sinh_vien.MaLop, lop.TenLop, khoa.MaKhoa, khoa.TenKhoa, sinh_vien.MaSv, sinh_vien.HoTen, sinh_vien.NgaySinh, sinh_vien.GioiTinh, sinh_vien.DiaChi from sinh_vien, lop, khoa where sinh_vien.MaLop = lop.MaLop and lop.MaKhoa = khoa.MaKhoa order by sinh_vien.MaLop");
						ResultSet rs1 = getDanhSachSv.executeQuery();	
						//Khai báo tên file muốn tạo
					      String filename = "BangDanhSachSV.xls";
					      //tạo một đối tượng của lớp HSSFWorkbook
					      HSSFWorkbook workbook = new HSSFWorkbook();
					      //gọi phương thức creatSheet() và truyền tên file muốn tạo
					      HSSFSheet sheet = workbook.createSheet(filename);
					     //Tạo hàng 0 sử dụng phương thức createRow()
					      HSSFRow rowhead = sheet.createRow((short) 0);
					      //Tạo ô bằng cách sử dụng phương thức createCell() và thiết lập giá trị cho ô bằng cách sử dụng phương thức setCellValue()
					      rowhead.createCell(0).setCellValue("Mã lớp");
					      rowhead.createCell(1).setCellValue("Tên lớp");
					      rowhead.createCell(2).setCellValue("Mã khoa");
					      rowhead.createCell(3).setCellValue("Tên khoa");
					      rowhead.createCell(4).setCellValue("Mã sinh viên");
					      rowhead.createCell(5).setCellValue("Họ và tên");
					      rowhead.createCell(6).setCellValue("Ngày sinh");
					      rowhead.createCell(7).setCellValue("Giới tính");		      
					      rowhead.createCell(8).setCellValue("Địa chỉ");
					      

					      while(rs1.next())
					      {
					    	  HSSFRow row = sheet.createRow( i++);
					    	  String gioiTinh;
					    	  if(rs1.getInt("GioiTinh") == 0) gioiTinh = "Nam";
					    	  else gioiTinh = "Nữ";
					    	  row.createCell(0).setCellValue(rs1.getString("MaLop"));
					    	  row.createCell(1).setCellValue(rs1.getString("TenLop"));
					    	  row.createCell(2).setCellValue(rs1.getString("MaKhoa"));
					    	  row.createCell(3).setCellValue(rs1.getString("TenKhoa"));
					    	  row.createCell(4).setCellValue(rs1.getString("MaSv"));
					    	  row.createCell(5).setCellValue(rs1.getString("HoTen"));
						      row.createCell(6).setCellValue(rs1.getString("NgaySinh"));
						      row.createCell(7).setCellValue(gioiTinh);
						      row.createCell(8).setCellValue(rs1.getString("DiaChi"));
					      }
					      i = 1;
					      FileOutputStream fileOut = new FileOutputStream(filename);
					      workbook.write(fileOut);
					      //đóng stream
					      fileOut.close();
					      //đóng workbook
					      workbook.close();
					      //in thông báo tạo thành công
					      System.out.println("File Excel đã được tạo thành công.");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
				
			
			}
		});
				
		
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Điểm của SV");
		mnNewMenu_5.add(mntmNewMenuItem_16);
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement getDiemSv = connection
								.prepareStatement("SELECT diem.MaSv, sinh_vien.HoTen, diem.HocKi, diem.MaHocPhan, hocphan.TenHocPhan,hocphan.SoTin, diem.DiemGK, diem.DiemCK, diem.DiemChu FROM diem, hocphan,sinh_vien where diem.MaSv = sinh_vien.MaSv and diem.MaHocPhan = hocphan.MaHocPhan order by diem.MaSv, diem.HocKi;");
						ResultSet rs1 = getDiemSv.executeQuery();
						//Khai báo tên file muốn tạo
					      String filename = "BangThongKeDiemSinhVien.xls";
					      //tạo một đối tượng của lớp HSSFWorkbook
					      HSSFWorkbook workbook = new HSSFWorkbook();
					      //gọi phương thức creatSheet() và truyền tên file muốn tạo
					      HSSFSheet sheet = workbook.createSheet(filename);
					     //Tạo hàng 0 sử dụng phương thức createRow()
					      HSSFRow rowhead = sheet.createRow((short) 0);
					      //Tạo ô bằng cách sử dụng phương thức createCell() và thiết lập giá trị cho ô bằng cách sử dụng phương thức setCellValue()
					      rowhead.createCell(0).setCellValue("Mã sinh viên");
					      rowhead.createCell(1).setCellValue("Họ và tên");
					      rowhead.createCell(2).setCellValue("Học kỳ");
					      rowhead.createCell(3).setCellValue("Mã học phần");
					      rowhead.createCell(4).setCellValue("Tên học phần");
					      rowhead.createCell(5).setCellValue("Số tín");
					      rowhead.createCell(6).setCellValue("Điểm giữa kỳ");
					      rowhead.createCell(7).setCellValue("Điểm cuối kỳ");		      
					      rowhead.createCell(8).setCellValue("Điểm chữ");
					      

					      while(rs1.next())
					      {
					    	  HSSFRow row = sheet.createRow( i++);
					    	 
					    	  row.createCell(0).setCellValue(rs1.getString("MaSv"));
					    	  row.createCell(1).setCellValue(rs1.getString("HoTen"));
					    	  row.createCell(2).setCellValue(rs1.getString("HocKi"));
					    	  row.createCell(3).setCellValue(rs1.getString("MaHocPhan"));
					    	  row.createCell(4).setCellValue(rs1.getString("TenHocPhan"));
					    	  row.createCell(5).setCellValue(rs1.getString("SoTin"));
						      row.createCell(6).setCellValue(rs1.getString("DiemGK"));
						      row.createCell(7).setCellValue(rs1.getString("DiemCK"));
						      row.createCell(8).setCellValue(rs1.getString("DiemChu"));
					      }
					      i = 1;
					      FileOutputStream fileOut = new FileOutputStream(filename);
					      workbook.write(fileOut);
					      //đóng stream
					      fileOut.close();
					      //đóng workbook
					      workbook.close();
					      //in thông báo tạo thành công
					      System.out.println("File Excel đã được tạo thành công.");
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
			
			}
			
		});
		
		
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Danh sách học bổng");
		mnNewMenu_5.add(mntmNewMenuItem_11);
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						 diemHbList = new ArrayList<>();
						 Connection connection = ConnJDBC.getConnection();
						 PreparedStatement getMaKhoa = connection	
								 .prepareStatement("Select distinct khoa.MaKhoa, diem.HocKi from diem, sinh_vien, lop, khoa where diem.MaSv = sinh_vien.MaSv and sinh_vien.MaLop = lop.MaLop and lop.MaKhoa = khoa.MaKhoa;");
						 
						 ResultSet rs1 = getMaKhoa.executeQuery();
						 
							while(rs1.next()) {
								//Dùng để sắp xếp trước khi cho vào listHb
								List<DiemHb> diemHbListTmp=  new ArrayList<>();
								
								String maKhoa = rs1.getString("MaKhoa");
								String hocKi = rs1.getString("HocKi");

								PreparedStatement getTenKhoa = connection	
										 .prepareStatement("Select TenKhoa from khoa where MaKhoa = '" + maKhoa + "';");
								
								ResultSet rs2 = getTenKhoa.executeQuery();
								
								String tenKhoa = null;
								if(rs2.next()) {
									tenKhoa = rs2.getString("TenKhoa");
								}

								
								
								PreparedStatement getMaSv = connection	
										 .prepareStatement("SELECT distinct diem.MaSv from diem, sinh_vien, lop, khoa where diem.MaSv = sinh_vien.MaSv and sinh_vien.MaLop = lop.MaLop and lop.MaKhoa = '" + maKhoa +"' and diem.HocKi = '" + hocKi +"';"); 		 		
								 ResultSet rs3 = getMaSv.executeQuery();
								 while(rs3.next()) {
									    String maSv = rs3.getString("MaSv");

									    PreparedStatement getHoTen = connection
												.prepareStatement("select HoTen from sinh_vien where MaSv ='" + maSv +"';");
										ResultSet rs4 = getHoTen.executeQuery();
										
										String hoTen = null;
										if(rs4.next()) {
											hoTen = rs4.getString("HoTen");
										}
												

										PreparedStatement getTongSoTin = connection
												.prepareStatement("Select sum(hocphan.SoTin) from diem , hocphan   where  diem.MaHocPhan = hocphan.MaHocPhan and diem.MaSv ='" + maSv + "'and diem.HocKi='" +  hocKi +"';");
										PreparedStatement getTongTichLuy= connection
												.prepareStatement("Select diem.DiemChu, hocphan.SoTin from diem , hocphan   where  diem.MaHocPhan = hocphan.MaHocPhan and diem.MaSv ='" + maSv + "'and diem.HocKi = '" +  hocKi +"';");
										
										ResultSet rs5 = getTongSoTin.executeQuery();
										int tongSoTin = 0;
										if(rs5.next())
										{
											tongSoTin = rs5.getInt(1);
										}
										ResultSet rs6 = getTongTichLuy.executeQuery();
										float TongDiemTichLuy = 0;
										while(rs6.next())
										{
											switch (rs6.getString("DiemChu")) {
											case "A+": {
												TongDiemTichLuy+=4*rs6.getInt("SoTin");
												break;
											}
											case "A": {
												TongDiemTichLuy+=4*rs6.getInt("SoTin");
												break;
											}
											case "B+": {
												TongDiemTichLuy+=3.5*rs6.getInt("SoTin");
												break;
											}
											case "B": {
												TongDiemTichLuy+=3*rs6.getInt("SoTin");
												break;
											}
											case "C+": {
												TongDiemTichLuy+=2.5*rs6.getInt("SoTin");
												break;
											}
											case "C": {
												TongDiemTichLuy+=2*rs6.getInt("SoTin");
												break;
											}
											case "D+": {
												TongDiemTichLuy+=1.5*rs6.getInt("SoTin");
												break;
											}
											case "D": {
												TongDiemTichLuy+=1*rs6.getInt("SoTin");
												break;
											}							
											default:
												TongDiemTichLuy+=0;	
										}
								 }
								float GPA = TongDiemTichLuy/tongSoTin;
								String loaiHb;
								if(GPA < 3.2) loaiHb = "C";
								else if(GPA < 3.6) loaiHb = "B";
								else loaiHb = "A";
										DiemHb diemHb = new DiemHb(maKhoa,tenKhoa,hocKi,maSv,hoTen,GPA,loaiHb);
										diemHbListTmp.add(diemHb);
							}
								 Collections.sort(diemHbListTmp,new DiemHbComparator());
								 for(int i = 0; i < 2; i++) {
									 diemHbList.add(diemHbListTmp.get(i));
								 }
							}
							//Khai báo tên file muốn tạo
						      String filename = "BangDanhSachHb.xls";
						      //tạo một đối tượng của lớp HSSFWorkbook
						      HSSFWorkbook workbook = new HSSFWorkbook();
						      //gọi phương thức creatSheet() và truyền tên file muốn tạo
						      HSSFSheet sheet = workbook.createSheet(filename);
						     //Tạo hàng 0 sử dụng phương thức createRow()
						      HSSFRow rowhead = sheet.createRow((short) 0);
						      //Tạo ô bằng cách sử dụng phương thức createCell() và thiết lập giá trị cho ô bằng cách sử dụng phương thức setCellValue()
						      rowhead.createCell(0).setCellValue("Mã Khoa");
						      rowhead.createCell(1).setCellValue("Tên Khoa");
						      rowhead.createCell(2).setCellValue("Học kỳ");
						      rowhead.createCell(3).setCellValue("Mã sinh viên");
						      rowhead.createCell(4).setCellValue("Họ và tên");
						      rowhead.createCell(5).setCellValue("GPA");
						      rowhead.createCell(6).setCellValue("Loại HB");



						      diemHbList.forEach((a) -> {
						    	  HSSFRow row = sheet.createRow( i++);
						    	 
								      row.createCell(0).setCellValue(a.getMaKhoa());
								      row.createCell(1).setCellValue(a.getTenKhoa());
								      row.createCell(2).setCellValue(a.getHocKi());
								      row.createCell(3).setCellValue(a.getMaSv());
								      row.createCell(4).setCellValue(a.getHoTen());	
								      row.createCell(5).setCellValue(a.getGPA());
								      row.createCell(6).setCellValue(a.getLoaiHb());
								});
						      i = 1;
						      FileOutputStream fileOut = new FileOutputStream(filename);
						      workbook.write(fileOut);
						      //đóng stream
						      fileOut.close();
						      //đóng workbook
						      workbook.close();
						      //in thông báo tạo thành công
						      System.out.println("File Excel đã được tạo thành công.");
							
							
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
				 
			}
		});
		
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u0110i\u1EC3m trung b\u00ECnh");
		mnNewMenu_5.add(mntmNewMenuItem_4);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\Anh\\AVATAR.jpg"));
		btnNewButton.setBounds(0, 0, 734, 513);
		getContentPane().add(btnNewButton);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						 diemTbList = new ArrayList<>();
						 Connection connection = ConnJDBC.getConnection();
							PreparedStatement getMaSvHocKi = connection
									.prepareStatement("SELECT distinct diem.MaSv, diem.HocKi from diem;");
							// Để lưu một masv làm cái so sánh
							PreparedStatement getMaSvHocKi1 = connection
									.prepareStatement("SELECT distinct diem.MaSv, diem.HocKi from diem;");
							ResultSet rs1 = getMaSvHocKi.executeQuery();
							ResultSet rs5 = getMaSvHocKi1.executeQuery();

							 float TongDiemTichLuyTatCaCacKi = 0;
							 int tongSoTinTatCaCacKi = 0;
							 String maSvTmp = null;
							 if(rs5.next())
							 {
								 maSvTmp = rs5.getString("MaSv");
							 }
							 
							while(rs1.next()) {
								
							String maSv = rs1.getString("MaSv");
							String hocKi = rs1.getString("HocKi");
							PreparedStatement getTongSoTin = connection
									.prepareStatement("Select sum(hocphan.SoTin) from diem , hocphan   where  diem.MaHocPhan = hocphan.MaHocPhan and diem.MaSv ='" + maSv + "'and diem.HocKi='" +  hocKi +"';");
							PreparedStatement getTongTichLuy= connection
									.prepareStatement("Select diem.DiemChu, hocphan.SoTin from diem , hocphan   where  diem.MaHocPhan = hocphan.MaHocPhan and diem.MaSv ='" + maSv + "'and diem.HocKi = '" +  hocKi +"';");
							PreparedStatement getHoTen = connection
									.prepareStatement("select sinh_vien.HoTen from sinh_vien where sinh_vien.MaSv ='" + maSv +"';");
							ResultSet rs2 = getTongSoTin.executeQuery();
							int tongSoTin = 0;
							if(rs2.next())
							{
								tongSoTin = rs2.getInt(1);
							}
							ResultSet rs3 = getTongTichLuy.executeQuery();
							float TongDiemTichLuy = 0;
							while(rs3.next())
							{
								switch (rs3.getString("DiemChu")) {
								case "A+": {
									TongDiemTichLuy+=4*rs3.getInt("SoTin");
									break;
								}
								case "A": {
									TongDiemTichLuy+=4*rs3.getInt("SoTin");
									break;
								}
								case "B+": {
									TongDiemTichLuy+=3.5*rs3.getInt("SoTin");
									break;
								}
								case "B": {
									TongDiemTichLuy+=3*rs3.getInt("SoTin");
									break;
								}
								case "C+": {
									TongDiemTichLuy+=2.5*rs3.getInt("SoTin");
									break;
								}
								case "C": {
									TongDiemTichLuy+=2*rs3.getInt("SoTin");
									break;
								}
								case "D+": {
									TongDiemTichLuy+=1.5*rs3.getInt("SoTin");
									break;
								}
								case "D": {
									TongDiemTichLuy+=1*rs3.getInt("SoTin");
									break;
								}							
								default:
									TongDiemTichLuy+=0;	
							}
							}
							if(maSvTmp.equals(maSv)) {
								TongDiemTichLuyTatCaCacKi +=TongDiemTichLuy;
								tongSoTinTatCaCacKi += tongSoTin;
								
							}
							else {
								TongDiemTichLuyTatCaCacKi = TongDiemTichLuy;
								tongSoTinTatCaCacKi = tongSoTin;
							}
							maSvTmp = maSv;
							
							ResultSet rs4 = getHoTen.executeQuery();
							String hoTen = null;
							if(rs4.next())
							{
								hoTen = rs4.getString("HoTen");
							}
							DiemTb diemTb = new DiemTb(maSv,hoTen,hocKi,TongDiemTichLuy/tongSoTin,TongDiemTichLuyTatCaCacKi/tongSoTinTatCaCacKi);
							
							diemTbList.add(diemTb);
							}
					    	//Khai báo tên file muốn tạo
					      String filename = "DiemTrungBinh.xls";
					      //tạo một đối tượng của lớp HSSFWorkbook
					      HSSFWorkbook workbook = new HSSFWorkbook();
					      //gọi phương thức creatSheet() và truyền tên file muốn tạo
					      HSSFSheet sheet = workbook.createSheet(filename);
					     //Tạo hàng 0 sử dụng phương thức createRow()
					      HSSFRow rowhead = sheet.createRow((short) 0);
					      //Tạo ô bằng cách sử dụng phương thức createCell() và thiết lập giá trị cho ô bằng cách sử dụng phương thức setCellValue()
					      rowhead.createCell(0).setCellValue("Mã sinh viên");
					      rowhead.createCell(1).setCellValue("Họ và tên");
					      rowhead.createCell(2).setCellValue("Học kỳ");
					      rowhead.createCell(3).setCellValue("GPA");
					      rowhead.createCell(4).setCellValue("CPA");

					      diemTbList.forEach((a) -> {
					    	  HSSFRow row = sheet.createRow( i++);
					    	 
							      row.createCell(0).setCellValue(a.getMaSV());
							      row.createCell(1).setCellValue(a.getHoTen());
							      row.createCell(2).setCellValue(a.getHocKi());
							      row.createCell(3).setCellValue(a.getGPA());
							      row.createCell(4).setCellValue(a.getCPA());					        											
							});
					      i = 1;
					      FileOutputStream fileOut = new FileOutputStream(filename);
					      workbook.write(fileOut);
					      //đóng stream
					      fileOut.close();
					      //đóng workbook
					      workbook.close();
					      //in thông báo tạo thành công
					      System.out.println("File Excel đã được tạo thành công.");
					    } catch (Exception e1) {
					      e1.printStackTrace();
					    }
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
				 
				  }	
		});
	}
}
