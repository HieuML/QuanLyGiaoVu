package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class frmQLDiem extends JFrame {

	private JPanel contentPane;
	private JTextField txtGhiChu;
	private JTextField txtMaSV;
	private JTextField txtMaHP;
	private JTable table;
	private JTextField txtDiemCK;
	private JTextField txtDiemGK;
	private JTextField txtHocKi;
	private Float DiemGK ;
	private Float DiemCK ;
	private Float DiemTong;
	private String DiemChu;
	List<Diem> diemList;
	int i = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQLDiem frame = new frmQLDiem();
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
	public frmQLDiem() {
		setTitle("Nh\u1EADp \u0111i\u1EC3m sinh vi\u00EAn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00D4NG TIN \u0110I\u1EC2M SINH VI\u00CAN");
		lblNewLabel.setBounds(461, 44, 170, 13);
		lblNewLabel.setForeground(Color.RED);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\refresh.png"));
		btnNewButton_1.setBounds(955, 102, 141, 41);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 75, 378, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Th??ng tin chi ti???t");
		lblNewLabel_1.setBounds(10, 10, 109, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("M?? Sinh Vi??n");
		lblNewLabel_2_1.setBounds(10, 68, 83, 13);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("H\u1ECDc k\u00EC");
		lblNewLabel_2_2.setBounds(212, 71, 45, 13);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("M?? h???c ph???n");
		lblNewLabel_3.setBounds(10, 105, 83, 13);
		panel.add(lblNewLabel_3);
		
		txtMaSV = new JTextField();
		txtMaSV.setBounds(102, 65, 83, 19);
		panel.add(txtMaSV);
		txtMaSV.setColumns(10);
		
		txtMaHP = new JTextField();
		txtMaHP.setColumns(10);
		txtMaHP.setBounds(103, 102, 83, 19);
		panel.add(txtMaHP);
		
		
		JLabel lblNewLabel_3_4 = new JLabel("??i???m GK");
		lblNewLabel_3_4.setBounds(211, 111, 63, 13);
		panel.add(lblNewLabel_3_4);
		
		txtDiemGK = new JTextField();
		txtDiemGK.setColumns(10);
		txtDiemGK.setBounds(284, 108, 83, 19);
		panel.add(txtDiemGK);
		
		JLabel lblNewLabel_3_2 = new JLabel("??i???m CK");
		lblNewLabel_3_2.setBounds(10, 139, 63, 13);
		panel.add(lblNewLabel_3_2);
		
		txtDiemCK = new JTextField();
		txtDiemCK.setColumns(10);
		txtDiemCK.setBounds(102, 136, 83, 19);
		panel.add(txtDiemCK);
		
		txtHocKi = new JTextField();
		txtHocKi.setColumns(10);
		txtHocKi.setBounds(284, 68, 83, 19);
		panel.add(txtHocKi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(445, 75, 482, 151);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Th??m");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaSV = connection
								.prepareStatement("SELECT * from sinh_vien where MaSV = ?;");
						PreparedStatement testMaHP = connection
								.prepareStatement("SELECT * from hocphan where MaHocPhan = ?;");
						PreparedStatement testDiem = connection
								.prepareStatement("SELECT * from diem where MaSV = ? and MaHocPhan = ? and HocKi = ?");
						testMaSV.setString(1, txtMaSV.getText());
						ResultSet rs1 = testMaSV.executeQuery();
						
						testMaHP.setString(1, txtMaHP.getText());
						ResultSet rs2 = testMaHP.executeQuery();
						
						testDiem.setString(1, txtMaSV.getText());
						testDiem.setString(2, txtMaHP.getText());
						testDiem.setString(3, txtHocKi.getText());

						ResultSet rs3 = testDiem.executeQuery();
						
						if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "M?? sinh vi??n kh??ng t???n t???i");
						}
						else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "M?? h???c ph???n kh??ng t???n t???i");
						}
						else if (rs3.next()) {
							JOptionPane.showMessageDialog(null, "??i???m n??y ???? ???????c nh???p r???i");
						}
						else {
							tinhDiemTongVaDiemChu(txtDiemGK,txtDiemCK);
							Diem diem = new Diem(txtMaSV.getText(),txtMaHP.getText(),txtHocKi.getText(),DiemGK, DiemCK, DiemTong,DiemChu,txtGhiChu.getText());
							ConnJDBC.insertDiem(diem);
							JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng");
							showData(ConnJDBC.findAllDiem());
						}
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "B???n kh??ng c?? quy???n th???c hi???n ch???c n??ng n??y! ");
				}
			
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThemmoi.Image.png"));
		btnNewButton.setBounds(955, 174, 141, 41);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("S???a");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testDiem = connection
								.prepareStatement("SELECT * from diem where MaSV = ? and MaHocPhan = ? and HocKi = ?");
						testDiem.setString(1, txtMaSV.getText());
						testDiem.setString(2, txtMaHP.getText());
						testDiem.setString(3, txtHocKi.getText());

						ResultSet rs1 = testDiem.executeQuery();
						if(txtMaSV.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Ch??a ??i???n m?? sinh vi??n mu???n s???a");

						}
						else if(txtMaHP.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Ch??a ??i???n m?? h???c ph???n mu???n s???a");

						}
						else if(txtHocKi.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Ch??a ??i???n h???c k??? ph???n mu???n s???a");

						}
						else if(!rs1.next())
						{
							JOptionPane.showMessageDialog(null, "??i???m n??y kh??ng t???n t???i");

						}
						else {
							tinhDiemTongVaDiemChu(txtDiemGK,txtDiemCK);
							Diem diem = new Diem(txtMaSV.getText(),txtMaHP.getText(),txtHocKi.getText(),DiemGK, DiemCK, DiemTong,DiemChu,txtGhiChu.getText());
							ConnJDBC.updateDiem(diem);
							JOptionPane.showMessageDialog(null, "S???a th??nh c??ng");
							showData(ConnJDBC.findAllDiem());
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "B???n kh??ng c?? quy???n th???c hi???n ch???c n??ng n??y! ");
				}
				
			}
		});
		btnSa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnSua.Image.png"));
		btnSa.setBounds(955, 238, 141, 41);
		contentPane.add(btnSa);
		
		JButton btnXo = new JButton("Xo??");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testDiem = connection
								.prepareStatement("SELECT * from diem where MaSV = ? and MaHocPhan = ? and HocKi = ?");
						testDiem.setString(1, txtMaSV.getText());
						testDiem.setString(2, txtMaHP.getText());
						testDiem.setString(3, txtHocKi.getText());

						ResultSet rs1 = testDiem.executeQuery();
						if(txtMaSV.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Ch??a ??i???n m?? sinh vi??n mu???n xo??");

						}
						else if(txtMaHP.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Ch??a ??i???n m?? h???c ph???n mu???n xo??");

						}
						else if(txtHocKi.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Ch??a ??i???n h???c k??? ph???n mu???n xo??");

						}
						else if(!rs1.next())
						{
							JOptionPane.showMessageDialog(null, "??i???m n??y kh??ng t???n t???i");

						}
						else {
							Diem diem = new Diem(txtMaSV.getText(),txtMaHP.getText(),txtHocKi.getText());
							ConnJDBC.deleteDiem(diem);
							JOptionPane.showMessageDialog(null, "Xo?? th??nh c??ng");
							showData(ConnJDBC.findAllDiem());
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "B???n kh??ng c?? quy???n th???c hi???n ch???c n??ng n??y! ");
				}
				
			}
		});
		btnXo.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnXoa.Image.png"));
		btnXo.setBounds(955, 301, 141, 41);
		contentPane.add(btnXo);
		
		JButton btnThot = new JButton("Tho??t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnThot.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThoat.Image.png"));
		btnThot.setBounds(955, 513, 141, 41);
		contentPane.add(btnThot);
		
		
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Ghi ch??");
		lblNewLabel_1_1.setBounds(10, 10, 45, 13);
		panel_1.add(lblNewLabel_1_1);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setBounds(10, 28, 462, 113);
		panel_1.add(txtGhiChu);
		txtGhiChu.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(35, 309, 892, 298);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Danh s??ch");
		lblNewLabel_3_1.setBounds(10, 0, 84, 13);
		panel_1_1.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 23, 862, 265);
		panel_1_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 sinh vi\u00EAn", "M\u00E3 h\u1ECDc ph\u1EA7n", "H\u1ECDc k\u1EF3", "\u0110i\u1EC3m GK", "\u0110i\u1EC3m CK", "\u0110i\u1EC3m T\u1ED5ng", "\u0110i\u1EC3m ch\u1EEF", "Ghi ch\u00FA"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnInBngim = new JButton("In B??i???m");
		btnInBngim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				    try {
				    	//Khai b??o t??n file mu???n t???o
				      String filename = "BangDiem.xls";
				      //t???o m???t ?????i t?????ng c???a l???p HSSFWorkbook
				      HSSFWorkbook workbook = new HSSFWorkbook();
				      //g???i ph????ng th???c creatSheet() v?? truy???n t??n file mu???n t???o
				      HSSFSheet sheet = workbook.createSheet(filename);
				     //T???o h??ng 0 s??? d???ng ph????ng th???c createRow()
				      HSSFRow rowhead = sheet.createRow((short) 0);
				      //T???o ?? b???ng c??ch s??? d???ng ph????ng th???c createCell() v?? thi???t l???p gi?? tr??? cho ?? b???ng c??ch s??? d???ng ph????ng th???c setCellValue()
				      rowhead.createCell(0).setCellValue("M?? sinh vi??n");
				      rowhead.createCell(1).setCellValue("M?? h???c ph???n");
				      rowhead.createCell(2).setCellValue("H???c k???");
				      rowhead.createCell(3).setCellValue("??i???m GK");
				      rowhead.createCell(4).setCellValue("??i???m CK");
				      rowhead.createCell(5).setCellValue("??i???m T???ng");
				      rowhead.createCell(6).setCellValue("??i???m Ch???");
				      rowhead.createCell(7).setCellValue("Ghi ch???");
				      
				      diemList.forEach((diem) -> {
				    	  HSSFRow row = sheet.createRow( i++);
				    	 
						      row.createCell(0).setCellValue(diem.getMaSV());
						      row.createCell(1).setCellValue(diem.getMaHocPhan());
						      row.createCell(2).setCellValue(diem.getHocKi());
						      row.createCell(3).setCellValue(diem.getDiemGK());
						      row.createCell(4).setCellValue(diem.getDiemCK());
						      row.createCell(5).setCellValue(diem.getDiemTong());
						      row.createCell(6).setCellValue(diem.getDiemChu());
						      row.createCell(7).setCellValue(diem.getGhiChu());
					        											
						});
				      i = 1;
				    	
					      

				      
				      FileOutputStream fileOut = new FileOutputStream(filename);
				      workbook.write(fileOut);
				      //????ng stream
				      fileOut.close();
				      //????ng workbook
				      workbook.close();
				      //in th??ng b??o t???o th??nh c??ng
				      System.out.println("File Excel ???? ???????c t???o th??nh c??ng.");
				    } catch (Exception e1) {
				      e1.printStackTrace();
				    }
				  }
				
			
		});
		
		btnInBngim.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\printer.png"));
		btnInBngim.setBounds(955, 442, 141, 41);
		contentPane.add(btnInBngim);
		
		JButton btnTmKim = new JButton("T??m ki???m");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diemList = new ArrayList<>();
				String query = null;
				
				if(!txtMaSV.getText().equals("") && !txtMaHP.getText().equals("") && !txtHocKi.getText().equals(""))
				{
					 query = "select * from diem where MaSV = '" + txtMaSV.getText() +"' and MaHocPhan = '" + txtMaHP.getText() + "' and HocKi = '" + txtHocKi.getText() + "';";
				}
				else if(txtMaSV.getText().equals("") && !txtMaHP.getText().equals("") && !txtHocKi.getText().equals(""))
				{
					 query = "select * from diem where MaHocPhan = '" + txtMaHP.getText() + "' and HocKi = '" + txtHocKi.getText() + "';";

				}
				else if(!txtMaSV.getText().equals("") && txtMaHP.getText().equals("") && txtHocKi.getText().equals(""))
				{
					query = "select * from diem where MaSV = '" + txtMaSV.getText() + "' order by HocKi;";
				}

				try {
					Connection connection = ConnJDBC.getConnection();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						Diem diem = new Diem(rs.getString("MaSV"), rs.getString("MaHocPhan"),
								rs.getString("HocKi"), rs.getFloat("DiemGK"), rs.getFloat("DiemCK"),
								rs.getFloat("DiemTong"), rs.getString("DiemChu"),rs.getString("GhiChu"));
						diemList.add(diem);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				showData(diemList);
			}
		});
		btnTmKim.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\search.png"));
		btnTmKim.setBounds(955, 371, 141, 41);
		contentPane.add(btnTmKim);
		showData(ConnJDBC.findAllDiem());

	}
	public void showData(List<Diem> diemL) {
		diemList = new ArrayList<>();
		diemList = diemL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		diemList.forEach((diem) -> {
			
			tableModel.addRow(new Object[] {diem.getMaSV(),diem.getMaHocPhan(),diem.getHocKi(),diem.getDiemGK(),diem.getDiemCK(),diem.getDiemTong(),diem.getDiemChu(),diem.getGhiChu()});
			
			
		});
	}
	public void tinhDiemTongVaDiemChu(JTextField txtDiemGK,JTextField txtDiemCK) {
		//Tinh diem tong dua tren diem tong
		if(!txtDiemGK.getText().equals("") && !txtDiemCK.getText().equals(""))
		{
		DiemGK = DiemGK.parseFloat(txtDiemGK.getText());
		
		DiemCK = DiemCK.parseFloat(txtDiemCK.getText());
		
		DiemTong = (float) (DiemGK*0.3 + DiemCK*0.7);

		if(DiemTong < 4)
		{
			DiemChu = "F";
		}
		else if (DiemTong < 5)
		{
			DiemChu = "D";
		}
		else if (DiemTong < 5.5)
		{
			DiemChu = "D+";
		}
		else if (DiemTong < 6.5)
		{
			DiemChu = "C";
		}
		else if (DiemTong < 7)
		{
			DiemChu = "C+";
		}
		else if (DiemTong < 8)
		{
			DiemChu = "B";
		}
		else if (DiemTong < 8.5)
		{
			DiemChu = "B+";
		}
		else if (DiemTong < 9.5)
		{
			DiemChu = "A";
		}
		else 
		{
			DiemChu = "A+";
		}
		
		}
	}
}
