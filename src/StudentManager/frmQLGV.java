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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frmQLGV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaGV;
	private JTextField txtHoTen;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtPhanLoaiGV;
	private JTable table;
	private JTextField txtTenDN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQLGV frame = new frmQLGV();
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
	public frmQLGV() {
		setTitle("Th\u00F4ng tin gi\u1EA3ng vi\u00EAn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDanhSchGing = new JLabel("DANH SÁCH GIẢNG VIÊN");
		lblDanhSchGing.setForeground(Color.RED);
		lblDanhSchGing.setBounds(454, 38, 214, 13);
		contentPane.add(lblDanhSchGing);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(371, 71, 592, 375);
		contentPane.add(panel_1);

		JLabel lblNewLabel_3 = new JLabel("Danh sách");
		lblNewLabel_3.setBounds(10, 0, 84, 13);
		panel_1.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 23, 572, 342);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, "", null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "MaGV", "TenGV", "GioiTinh", "Phone", "Email", "PhanLoaiGV", "TenDN" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(37);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(47);
		table.getColumnModel().getColumn(3).setPreferredWidth(65);
		table.getColumnModel().getColumn(4).setPreferredWidth(133);
		table.getColumnModel().getColumn(5).setPreferredWidth(64);
		table.getColumnModel().getColumn(5).setMinWidth(37);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(34, 71, 312, 372);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Thông tin chi tiết");
		lblNewLabel_1.setBounds(10, 0, 98, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u00E3 gi\u1EA3ng vi\u00EAn");
		lblNewLabel_2.setBounds(10, 35, 87, 13);
		panel.add(lblNewLabel_2);

		txtMaGV = new JTextField();
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(100, 29, 139, 19);
		panel.add(txtMaGV);

		JLabel lblNewLabel_4 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel_4.setBounds(10, 73, 63, 13);
		panel.add(lblNewLabel_4);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(100, 67, 139, 19);
		panel.add(txtHoTen);

		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setBounds(10, 173, 63, 13);
		panel.add(lblNewLabel_5);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(100, 167, 139, 19);
		panel.add(txtPhone);

		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(10, 216, 45, 13);
		panel.add(lblNewLabel_6);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 210, 139, 19);
		panel.add(txtEmail);

		JLabel lblNewLabel_7 = new JLabel("Ph\u00E2n lo\u1EA1i GV");
		lblNewLabel_7.setBounds(10, 261, 77, 13);
		panel.add(lblNewLabel_7);

		txtPhanLoaiGV = new JTextField();
		txtPhanLoaiGV.setColumns(10);
		txtPhanLoaiGV.setBounds(100, 255, 139, 19);
		panel.add(txtPhanLoaiGV);

		JLabel lblNewLabel_8 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_8.setBounds(10, 129, 77, 13);
		panel.add(lblNewLabel_8);

		JComboBox cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] { "Nam", "N\u1EEF" }));
		cbGender.setBounds(102, 125, 54, 21);
		panel.add(cbGender);

		JLabel lblNewLabel_7_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_7_1.setBounds(10, 301, 87, 13);
		panel.add(lblNewLabel_7_1);

		txtTenDN = new JTextField();
		txtTenDN.setColumns(10);
		txtTenDN.setBounds(100, 295, 139, 19);
		panel.add(txtTenDN);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaGV.setText("");
				txtHoTen.setText("");
				txtPhone.setText("");
				txtEmail.setText("");
				txtPhanLoaiGV.setText("");
				txtTenDN.setText("");

			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\refresh.png"));
		btnRefresh.setBounds(989, 71, 112, 41);
		contentPane.add(btnRefresh);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{	
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaGV = connection
								.prepareStatement("SELECT * from giang_vien where MaGV = ?;");
						PreparedStatement testExistTenDN = connection
								.prepareStatement("SELECT * from login where TenDN IN(?);");
						// Kiểm tra xem có sinh vien nào có tên dn đó k
						PreparedStatement testGVTenDN1 = connection
								.prepareStatement("SELECT * from sinh_vien where TenDN IN(?) ;");
						PreparedStatement testGVTenDN2 = connection
								.prepareStatement("SELECT * from giang_vien where TenDN IN(?) ;");
						testMaGV.setString(1, txtMaGV.getText());
						ResultSet rs1 = testMaGV.executeQuery();
						testExistTenDN.setString(1, txtTenDN.getText());
						ResultSet rs2 = testExistTenDN.executeQuery();

						testGVTenDN1.setString(1, txtTenDN.getText());

						ResultSet rs3 = testGVTenDN1.executeQuery();
						
						testGVTenDN2.setString(1, txtTenDN.getText());

						ResultSet rs4 = testGVTenDN2.executeQuery();

						if (rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã giáo viên đã tồn tại");
						} else if (txtTenDN.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền tên đăng nhập");
						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
						} else if (rs3.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập này của người khác");
						} else if (rs4.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập này của người khác");
						} else {
							GiangVien giangVien = new GiangVien(txtMaGV.getText(), txtHoTen.getText(),
									cbGender.getSelectedIndex(), txtPhone.getText(), txtEmail.getText(),
									txtPhanLoaiGV.getText(), txtTenDN.getText());
							ConnJDBC.insertGV(giangVien);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							showData(ConnJDBC.findAllGV());
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
		btnThem.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThemmoi.Image.png"));
		btnThem.setBounds(989, 137, 112, 41);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{						
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaGV = connection
								.prepareStatement("SELECT * from giang_vien where MaGV = ?;");

						PreparedStatement testExistTenDN = connection
								.prepareStatement("SELECT * from login where TenDN IN(?);");

						// Kiểm tra xem tên DN này có phải của MaGV này k?
						PreparedStatement testGVTenDN = connection
								.prepareStatement("SELECT * from giang_vien where MaGV = ? and TenDN IN(?) ;");
						// Kiểm tra xem đã có sv nào sở hữu tên DN này chưa
						PreparedStatement testGVTenDN1 = connection.prepareStatement(
								"SELECT * from sinh_vien where TenDN IN(?) ;");
						// Kiểm tra xem đã có gv nào sở hữu tên DN này chưa
						PreparedStatement testGVTenDN2 = connection.prepareStatement(
								"SELECT * from giang_vien where TenDN IN(?) ;");

						testMaGV.setString(1, txtMaGV.getText());
						ResultSet rs1 = testMaGV.executeQuery();

						testExistTenDN.setString(1, txtTenDN.getText());
						ResultSet rs2 = testExistTenDN.executeQuery();

						testGVTenDN.setString(1, txtMaGV.getText());
						testGVTenDN.setString(2, txtTenDN.getText());

						ResultSet rs3 = testGVTenDN.executeQuery();

						testGVTenDN1.setString(1, txtTenDN.getText());

						ResultSet rs4 = testGVTenDN1.executeQuery();
						
						testGVTenDN2.setString(1, txtTenDN.getText());

						ResultSet rs5 = testGVTenDN2.executeQuery();

						if (txtMaGV.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã giảng viên muốn sửa");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã giảng viên không tồn tại");
						} else if (txtTenDN.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền tên đăng nhập");
						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
						} else if ((rs5.next() || rs4.next()) && !rs3.next()) {
							JOptionPane.showMessageDialog(null, "Tên đăng nhập này của người khác");
						
						} else {
							GiangVien giangVien = new GiangVien(txtMaGV.getText(), txtHoTen.getText(),
									cbGender.getSelectedIndex(), txtPhone.getText(), txtEmail.getText(),
									txtPhanLoaiGV.getText(), txtTenDN.getText());
							ConnJDBC.updateGV(giangVien);
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							showData(ConnJDBC.findAllGV());
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
		btnSua.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnSua.Image.png"));
		btnSua.setBounds(989, 201, 112, 41);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{						
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaGV = connection
								.prepareStatement("SELECT * from giang_vien where MaGV = ?;");
						testMaGV.setString(1, txtMaGV.getText());
						ResultSet rs1 = testMaGV.executeQuery();
						if (txtMaGV.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã giảng viên muốn xoá");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã giảng viên không tồn tại");
						} else {
							GiangVien giangVien = new GiangVien(txtMaGV.getText());

							ConnJDBC.deleteGV(giangVien);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
							showData(ConnJDBC.findAllGV());
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
		btnXoa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnXoa.Image.png"));
		btnXoa.setBounds(989, 264, 112, 41);
		contentPane.add(btnXoa);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnThoat.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThoat.Image.png"));
		btnThoat.setBounds(989, 328, 112, 41);
		contentPane.add(btnThoat);
		showData(ConnJDBC.findAllGV());

	}

	public void showData(List<GiangVien> giangVienL) {
		List<GiangVien> giangVienList = new ArrayList<>();
		giangVienList = giangVienL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		giangVienList.forEach((giangVien) -> {
			String gioiTinh;
			if (giangVien.getGioiTinh() == 0)
				gioiTinh = "Nam";
			else {
				gioiTinh = "Nữ";
			}
			tableModel.addRow(new Object[] { giangVien.getMaGV(), giangVien.getTenGV(), gioiTinh, giangVien.getPhone(),
					giangVien.getEmail(), giangVien.getPhanLoaiGV(), giangVien.getTenDN() });
		});
	}
}
