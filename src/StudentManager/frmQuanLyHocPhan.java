package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class frmQuanLyHocPhan extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHocPhan;
	private JTextField txtTenHocPhan;
	private JTextField txtMaKhoa;
	private JTextField txtSoTin;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLyHocPhan frame = new frmQuanLyHocPhan();
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
	public frmQuanLyHocPhan() {
		setTitle("Qu\u1EA3n l\u00FD h\u1ECDc ph\u1EA7n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH MỤC HỌC PHẦN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(371, 30, 116, 13);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 312, 372);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Th\u00F4ng tin chi ti\u1EBFt");
		lblNewLabel_1.setBounds(10, 0, 112, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u00E3 h\u1ECDc ph\u1EA7n");
		lblNewLabel_2.setBounds(10, 35, 112, 13);
		panel.add(lblNewLabel_2);

		txtMaHocPhan = new JTextField();
		txtMaHocPhan.setBounds(100, 29, 139, 19);
		panel.add(txtMaHocPhan);
		txtMaHocPhan.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("T\u00EAn h\u1ECDc ph\u1EA7n");
		lblNewLabel_2_1.setBounds(10, 73, 87, 13);
		panel.add(lblNewLabel_2_1);

		txtTenHocPhan = new JTextField();
		txtTenHocPhan.setColumns(10);
		txtTenHocPhan.setBounds(100, 67, 139, 19);
		panel.add(txtTenHocPhan);

		JLabel lblNewLabel_2_4 = new JLabel("M\u00E3 khoa");
		lblNewLabel_2_4.setBounds(10, 174, 87, 13);
		panel.add(lblNewLabel_2_4);

		txtMaKhoa = new JTextField();
		txtMaKhoa.setColumns(10);
		txtMaKhoa.setBounds(100, 168, 139, 19);
		panel.add(txtMaKhoa);

		JLabel lblNewLabel_2_5 = new JLabel("Số tín");
		lblNewLabel_2_5.setBounds(10, 129, 45, 13);
		panel.add(lblNewLabel_2_5);

		txtSoTin = new JTextField();
		txtSoTin.setColumns(10);
		txtSoTin.setBounds(100, 123, 139, 19);
		panel.add(txtSoTin);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(332, 53, 443, 375);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Danh s\u00E1ch");
		lblNewLabel_3.setBounds(10, 0, 84, 13);
		panel_1.add(lblNewLabel_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 423, 342);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "MaHocPhan", "TenHocPhan", "SoTin", "MaKhoa" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(98);
		table.getColumnModel().getColumn(1).setPreferredWidth(168);
		scrollPane.setViewportView(table);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaHocPhan.setText("");
				txtTenHocPhan.setText("");
				txtSoTin.setText("");
				txtMaKhoa.setText("");
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\refresh.png"));
		btnRefresh.setBounds(805, 78, 132, 41);
		contentPane.add(btnRefresh);

		JButton btnThem = new JButton("Thêm");

		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frmDangNhap.getLoggedRole() == 0) {
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaHocPhan = connection
								.prepareStatement("SELECT * from HocPhan where MaHocPhan = ?;");
						PreparedStatement testMaKhoa = connection
								.prepareStatement("SELECT * from khoa where MaKhoa = ?;");
						testMaHocPhan.setString(1, txtMaHocPhan.getText());
						testMaKhoa.setString(1, txtMaKhoa.getText());
						ResultSet rs1 = testMaHocPhan.executeQuery();
						ResultSet rs2 = testMaKhoa.executeQuery();

						if (rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã học phần đã tồn tại");
						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Mã khoa không tồn tại");

						} else {
							HocPhan hocPhan = new HocPhan(txtMaHocPhan.getText(), txtTenHocPhan.getText(),
									Integer.valueOf(txtSoTin.getText()), txtMaKhoa.getText());
							ConnJDBC.insertHocPhan(hocPhan);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							showData(ConnJDBC.findAllHocPhan());
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
			}
		});

		btnThem.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThemmoi.Image.png"));
		btnThem.setBounds(805, 144, 132, 41);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frmDangNhap.getLoggedRole() == 0) {
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaHocPhan = connection
								.prepareStatement("SELECT * from HocPhan where MaHocPhan = ?;");

						PreparedStatement testMaKhoa = connection
								.prepareStatement("SELECT * from Khoa where MaKhoa = ?;");
						testMaHocPhan.setString(1, txtMaHocPhan.getText());
						testMaKhoa.setString(1, txtMaKhoa.getText());
						ResultSet rs1 = testMaHocPhan.executeQuery();
						ResultSet rs2 = testMaKhoa.executeQuery();
						if (txtMaHocPhan.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã học phần muốn sửa");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Ma học phần không tồn tại");

						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Mã khoa không tồn tại");

						} else {
							HocPhan hocPhan = new HocPhan(txtMaHocPhan.getText(), txtTenHocPhan.getText(),
									Integer.valueOf(txtSoTin.getText()), txtMaKhoa.getText());
							ConnJDBC.updateHocPhan(hocPhan);
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							showData(ConnJDBC.findAllHocPhan());
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
			}
		});

		btnSua.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnSua.Image.png"));
		btnSua.setBounds(805, 208, 132, 41);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frmDangNhap.getLoggedRole() == 0) {
					try {

						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaHocPhan = connection
								.prepareStatement("SELECT * from HocPhan where MaHocPhan = ?;");
						testMaHocPhan.setString(1, txtMaHocPhan.getText());
						ResultSet rs1 = testMaHocPhan.executeQuery();
						if (txtMaHocPhan.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã học phần muốn xoá");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Ma học phần không tồn tại");

						} else {
							HocPhan hocPhan = new HocPhan(txtMaHocPhan.getText());
							ConnJDBC.deleteHocPhan(hocPhan);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
							showData(ConnJDBC.findAllHocPhan());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");

				}

			}

		});

		btnXoa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnXoa.Image.png"));
		btnXoa.setBounds(805, 271, 132, 41);
		contentPane.add(btnXoa);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThoat.Image.png"));
		btnThoat.setBounds(805, 335, 132, 41);
		contentPane.add(btnThoat);
		showData(ConnJDBC.findAllHocPhan());

	}

	public void showData(List<HocPhan> hocPhanl) {
		List<HocPhan> hocPhanList = new ArrayList<>();
		hocPhanList = hocPhanl;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		hocPhanList.forEach((hocPhan) -> {
			tableModel.addRow(new Object[] { hocPhan.getMaHocPhan(), hocPhan.getTenHocPhan(), hocPhan.getSoTin(),
					hocPhan.getMaKhoa() });
		});
	}
}
