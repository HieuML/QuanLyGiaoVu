package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class frmQLSV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtMaLop;
	private JTextField txtNgaySinh;
	private JTable table;
	private JTextField txtTenDN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQLSV frame = new frmQLSV();
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
	public frmQLSV() {
		setTitle("Quản lý sinh viên Đại Học Bách Khoa Hà Nội");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1156, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ THÔNG TIN SINH VIÊN");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(531, 10, 214, 13);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 132, 291, 372);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin chi tiết");
		lblNewLabel_1.setBounds(10, 0, 108, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u00E3 sinh vi\u00EAn");
		lblNewLabel_2.setBounds(10, 35, 94, 13);
		panel.add(lblNewLabel_2);

		txtMaSV = new JTextField();
		txtMaSV.setColumns(10);
		txtMaSV.setBounds(114, 29, 139, 19);
		panel.add(txtMaSV);

		JLabel lblNewLabel_2_1 = new JLabel("H\u1ECD T\u00EAn");
		lblNewLabel_2_1.setBounds(10, 73, 63, 13);
		panel.add(lblNewLabel_2_1);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(114, 67, 139, 19);
		panel.add(txtHoTen);

		JLabel lblNewLabel_2_2 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_2_2.setBounds(10, 199, 45, 13);
		panel.add(lblNewLabel_2_2);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(114, 193, 139, 19);
		panel.add(txtDiaChi);

		JLabel lblNewLabel_2_3 = new JLabel("M\u00E3 l\u1EDBp");
		lblNewLabel_2_3.setBounds(10, 242, 45, 13);
		panel.add(lblNewLabel_2_3);

		txtMaLop = new JTextField();
		txtMaLop.setColumns(10);
		txtMaLop.setBounds(114, 236, 139, 19);
		panel.add(txtMaLop);

		JLabel lblNewLabel_2_4 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_2_4.setBounds(10, 155, 70, 13);
		panel.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_2_5.setBounds(10, 114, 70, 13);
		panel.add(lblNewLabel_2_5);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(114, 108, 139, 19);
		panel.add(txtNgaySinh);

		JComboBox cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] { "Nam", "N\u1EEF" }));
		cbGender.setBounds(114, 152, 63, 21);
		panel.add(cbGender);

		JLabel lblNewLabel_2_3_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_2_3_1.setBounds(10, 283, 94, 13);
		panel.add(lblNewLabel_2_3_1);

		txtTenDN = new JTextField();
		txtTenDN.setColumns(10);
		txtTenDN.setBounds(114, 277, 139, 19);
		panel.add(txtTenDN);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(372, 129, 638, 375);
		contentPane.add(panel_1);

		JLabel lblNewLabel_3 = new JLabel("Danh sách");
		lblNewLabel_3.setBounds(10, 0, 84, 13);
		panel_1.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 618, 342);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "MaSv", "HoTen", "NgaySinh", "GioiTinh", "DiaChi", "MaLop",
						"T\u00EAn \u0111\u0103ng nh\u1EADp" }));
		table.getColumnModel().getColumn(6).setPreferredWidth(91);
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaSV.setText("");
				txtHoTen.setText("");
				txtNgaySinh.setText("");
				txtDiaChi.setText("");
				txtMaLop.setText("");
				txtTenDN.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\refresh.png"));
		btnNewButton_1.setBounds(1020, 132, 112, 41);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{	
					try {
						Connection connection = ConnJDBC.getConnection();

						PreparedStatement testMaSV = connection.prepareStatement("SELECT * from sinh_vien where MaSV = ?;");

						PreparedStatement testExistTenDN = connection
								.prepareStatement("SELECT * from login where TenDN IN(?);");

						// Kiểm tra xem tên DN này đã được gán cho ai chưa ?
						PreparedStatement testSVTenDN = connection
								.prepareStatement("SELECT * from sinh_vien where TenDN IN(?) ;");
						PreparedStatement testSVTenDN1 = connection
								.prepareStatement("SELECT * from giang_vien where TenDN IN(?);");

						PreparedStatement testMaLop = connection.prepareStatement("SELECT * from lop where MaLop = ?;");

						testMaSV.setString(1, txtMaSV.getText());
						ResultSet rs1 = testMaSV.executeQuery();

						testExistTenDN.setString(1, txtTenDN.getText());
						ResultSet rs2 = testExistTenDN.executeQuery();

						testSVTenDN.setString(1, txtTenDN.getText());

						ResultSet rs3 = testSVTenDN.executeQuery();

						testSVTenDN1.setString(1, txtTenDN.getText());

						ResultSet rs4 = testSVTenDN1.executeQuery();

						testMaLop.setString(1, txtMaLop.getText());
						ResultSet rs5 = testMaLop.executeQuery();

						if (rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");
						}

						else if (txtMaLop.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã lớp");
						} else if (!rs5.next()) {
							JOptionPane.showMessageDialog(null, "Mã lớp không tồn tại");

						} else if (txtTenDN.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền tên đăng nhập");
						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
						} else if (rs3.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập này của người khác");
						} else if (rs4.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập này của người khác");
						} else {
							SinhVien sv = new SinhVien(txtMaSV.getText(), txtHoTen.getText(), txtNgaySinh.getText(),
									cbGender.getSelectedIndex(), txtDiaChi.getText(), txtMaLop.getText(),
									txtTenDN.getText());
							ConnJDBC.insertSV(sv);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							showData(ConnJDBC.findAllSV());
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
			}
		});
		btnNewButton
				.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThemmoi.Image.png"));
		btnNewButton.setBounds(1020, 204, 112, 41);
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();

						PreparedStatement testMaSV = connection.prepareStatement("SELECT * from sinh_vien where MaSV = ?;");

						PreparedStatement testExistTenDN = connection
								.prepareStatement("SELECT * from login where TenDN IN(?);");

						// Kiểm tra xem tên DN này có phải của MaSV này k?
						PreparedStatement testSVTenDN = connection
								.prepareStatement("SELECT * from sinh_vien where MaSV = ? and TenDN IN(?) ;");

						PreparedStatement testMaLop = connection.prepareStatement("SELECT * from lop where MaLop = ?;");
						// Kiểm tra xem đã có sv nào sở hữu tên DN này chưa
						PreparedStatement testSVTenDN1 = connection.prepareStatement(
								"SELECT * from sinh_vien where TenDN IN(?) ;");
						// Kiểm tra xem đã có gv nào sở hữu tên DN này chưa
						PreparedStatement testSVTenDN2 = connection.prepareStatement(
								"SELECT * from giang_vien where TenDN IN(?) ;");
						testMaSV.setString(1, txtMaSV.getText());
						ResultSet rs1 = testMaSV.executeQuery();

						testExistTenDN.setString(1, txtTenDN.getText());
						ResultSet rs2 = testExistTenDN.executeQuery();

						testSVTenDN.setString(1, txtMaSV.getText());
						testSVTenDN.setString(2, txtTenDN.getText());

						ResultSet rs3 = testSVTenDN.executeQuery();

						testMaLop.setString(1, txtMaLop.getText());
						ResultSet rs4 = testMaLop.executeQuery();
						
						testSVTenDN1.setString(1, txtTenDN.getText());
						ResultSet rs5 = testSVTenDN1.executeQuery();
						
						testSVTenDN2.setString(1, txtTenDN.getText());
						ResultSet rs6 = testSVTenDN2.executeQuery();

						if (txtMaSV.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã sinh viên muốn sửa");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
						} else if (txtMaLop.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã lớp");
						}else if (!rs4.next()) {
						JOptionPane.showMessageDialog(null, "Mã lớp không tồn tại");
						}else if (txtTenDN.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền tên đăng nhập");
						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
						} else if ((rs5.next() || rs6.next())&& !rs3.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập này của người khác");
						
						} else {
							SinhVien sv = new SinhVien(txtMaSV.getText(), txtHoTen.getText(), txtNgaySinh.getText(),
									cbGender.getSelectedIndex(), txtDiaChi.getText(), txtMaLop.getText(),
									txtTenDN.getText());
							ConnJDBC.updateSV(sv);
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							showData(ConnJDBC.findAllSV());
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
				
			}
		});
		btnSa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnSua.Image.png"));
		btnSa.setBounds(1020, 268, 112, 41);
		contentPane.add(btnSa);

		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaSV = connection.prepareStatement("SELECT * from sinh_vien where MaSV = ?;");
						testMaSV.setString(1, txtMaSV.getText());
						ResultSet rs1 = testMaSV.executeQuery();
						if (txtMaSV.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã sinh viên muốn xoá");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã sinh viên không tồn tại");
						} else {
							SinhVien sv = new SinhVien(txtMaSV.getText());

							ConnJDBC.deleteSV(sv);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
							showData(ConnJDBC.findAllSV());
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
			}
		});
		btnXo.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnXoa.Image.png"));
		btnXo.setBounds(1020, 331, 112, 41);
		contentPane.add(btnXo);

		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnThot.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThoat.Image.png"));
		btnThot.setBounds(1020, 463, 112, 41);
		contentPane.add(btnThot);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 38, 894, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("T\u00ECm ki\u1EBFm");
		lblNewLabel_4.setBounds(10, 10, 68, 13);
		panel_2.add(lblNewLabel_4);
		String getMaKhoa = "select MaKhoa from khoa";
		List<String> maKhoaList = new ArrayList();
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(getMaKhoa);
			while (rs.next()) {
				maKhoaList.add(rs.getString("MaKhoa"));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		String[] maKhoaArray = maKhoaList.toArray(new String[0]);

		JLabel lblNewLabel_5_1 = new JLabel("L\u1EDBp h\u1ECDc");
		lblNewLabel_5_1.setBounds(53, 24, 63, 13);
		panel_2.add(lblNewLabel_5_1);

		JComboBox cbMaLop = new JComboBox();
		String getMaLop = "select MaLop from lop";
		List<String> maLopList = new ArrayList();
		try {
			Connection connection = ConnJDBC.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(getMaLop);
			while (rs.next()) {
				maLopList.add(rs.getString("MaLop"));
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String[] maLopArray = maLopList.toArray(new String[0]);
		cbMaLop.setModel(new DefaultComboBoxModel(maLopArray));
		cbMaLop.setBounds(115, 20, 120, 21);
		panel_2.add(cbMaLop);
		JButton btnTm = new JButton("Tìm");
		btnTm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<SinhVien> svList = new ArrayList<>();
				String query = "select * from sinh_vien where MaLop = '" + maLopArray[cbMaLop.getSelectedIndex()]
						+ "';";
				try {
					Connection connection = ConnJDBC.getConnection();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						SinhVien sv = new SinhVien(rs.getString("MaSV"), rs.getString("HoTen"),
								rs.getString("NgaySinh"), rs.getInt("GioiTinh"), rs.getString("DiaChi"),
								rs.getString("MaLop"), rs.getString("TenDN"));
						svList.add(sv);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				showData(svList);

			}
		});
		btnTm.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\search.png"));
		btnTm.setBounds(1020, 397, 112, 41);
		contentPane.add(btnTm);
		showData(ConnJDBC.findAllSV());

	}

	public void showData(List<SinhVien> svL) {
		List<SinhVien> svList = new ArrayList<>();
		svList = svL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		svList.forEach((sv) -> {
			String gioiTinh;
			if (sv.getGioiTinh() == 0)
				gioiTinh = "Nam";
			else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] { sv.getMaSV(), sv.getHoTen(), sv.getNgaySinh(), gioiTinh, sv.getDiaChi(),
					sv.getMaLop(), sv.getTenDN() });
		});
	}
}
