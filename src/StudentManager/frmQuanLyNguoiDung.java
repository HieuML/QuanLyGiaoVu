package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class frmQuanLyNguoiDung extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private static JTable table;
	private JPasswordField txtPassword;
	private JPasswordField txtRePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmQuanLyNguoiDung frame = new frmQuanLyNguoiDung();
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
	public frmQuanLyNguoiDung() {
		setTitle("Quản lý người dùng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		String data[][] = { { "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" } };
		String column[] = { "TenDN", "MatKhau", "HoTen", "GioiTinh", "Phone", "Email" };
		contentPane.setSize(300, 400);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(69, 85, 354, 196);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblThngTinChi = new JLabel("Th\u00F4ng tin chi ti\u1EBFt");
		lblThngTinChi.setBounds(10, 10, 112, 13);
		panel.add(lblThngTinChi);

		JLabel lblNewLabel_2_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel_2_1.setBounds(10, 51, 89, 13);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_3_1.setBounds(10, 87, 85, 13);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("\u0110\u00E1nh l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNewLabel_4_1.setBounds(10, 121, 112, 13);
		panel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("Quy\u1EC1n");
		lblNewLabel_5_1.setBounds(10, 160, 45, 13);
		panel.add(lblNewLabel_5_1);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(121, 41, 161, 19);
		panel.add(txtUsername);

		JComboBox cbQuyen = new JComboBox();
		cbQuyen.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Member" }));
		cbQuyen.setBounds(121, 152, 161, 21);
		panel.add(cbQuyen);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(121, 84, 161, 19);
		panel.add(txtPassword);
		
		txtRePassword = new JPasswordField();
		txtRePassword.setBounds(121, 121, 161, 19);
		panel.add(txtRePassword);

		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD NG\u01AF\u1EDCI D\u00D9NG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(340, 45, 177, 13);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 342, 434, 155);
		contentPane.add(scrollPane);
		
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
						{null, null, null},
					},
					new String[] {
						"TenDN", "MatKhau", "Quyen"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(72);

		JButton btnNewButton = new JButton("Th\u00EAm");
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThemmoi.Image.png"));
		if(frmDangNhap.getLoggedRole()==0) {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection connection = ConnJDBC.getConnection();
					PreparedStatement testUserName = connection
							.prepareStatement("SELECT * from login where TenDN  IN(?);");
					PreparedStatement testQuyen = connection
							.prepareStatement("SELECT * from login where Quyen  = ?;");
					testQuyen.setInt(1, 0);
					testUserName.setString(1, txtUsername.getText());
					ResultSet rs1 = testUserName.executeQuery();
					ResultSet rs2 = testQuyen.executeQuery();
	

					if (rs1.next()) {
						JOptionPane.showMessageDialog(null, "Tên người dùng đã tồn tại");
					} else if (txtPassword.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa điền mật khẩu");

					} else if (!txtPassword.getText().equals(txtRePassword.getText())) {
						JOptionPane.showMessageDialog(null, "Điền lại mật khẩu sai");

					} else if (rs2.next() && cbQuyen.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại Admin");

					} else {
						User user = new User(txtUsername.getText(), txtPassword.getText(),cbQuyen.getSelectedIndex());
						ConnJDBC.insertUser(user);
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						showData(ConnJDBC.findAllUser());

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		}
		btnNewButton.setBounds(607, 151, 123, 41);
		contentPane.add(btnNewButton);

		JButton btnSa = new JButton("S\u1EEDa");
	
	

		if(frmDangNhap.getLoggedRole()==0) {
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = ConnJDBC.getConnection();
					PreparedStatement testUserName = connection
							.prepareStatement("SELECT * from login where TenDN  IN(?);");
					PreparedStatement testQuyen = connection.prepareStatement("SELECT * from login where Quyen = ?;");
					PreparedStatement testQuyenUser = connection.prepareStatement("SELECT * from login where TenDN IN(?) and Quyen = ?;");
					testQuyen.setInt(1, 0);
					ResultSet rs1 = testQuyen.executeQuery();
					testQuyenUser.setString(1, txtUsername.getText());
					testQuyenUser.setInt(2, 0);
					ResultSet rs2 = testQuyenUser.executeQuery();
					testUserName.setString(1, txtUsername.getText());
					ResultSet rs3 = testUserName.executeQuery();
					
					if (txtUsername.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa điền tên người dùng muốn sửa");
					}
					else if (!rs3.next()) {
						JOptionPane.showMessageDialog(null, "Tên người dùng không tồn tại");
					}
					else if (txtPassword.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa điền mật khẩu");
					}
					else if (!txtPassword.getText().equals(txtRePassword.getText())) {
						JOptionPane.showMessageDialog(null, "Điền lại mật khẩu sai");
					}
					else if (rs1.next() && cbQuyen.getSelectedIndex() == 0 && !rs2.next()) {
						JOptionPane.showMessageDialog(null, "Đã tồn tại Admin");

					} else {
						User user = new User(txtUsername.getText(), txtPassword.getText(),cbQuyen.getSelectedIndex());
						ConnJDBC.updateUser(user);
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						showData(ConnJDBC.findAllUser());

					}
					

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		}
		btnSa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnSua.Image.png"));
		btnSa.setBounds(607, 215, 123, 41);
		contentPane.add(btnSa);

		JButton btnXo = new JButton("Xo\u00E1");
		if(frmDangNhap.getLoggedRole()==0) {
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = ConnJDBC.getConnection();
					PreparedStatement testUserName = connection
							.prepareStatement("SELECT * from login where TenDN  IN(?);");
					testUserName.setString(1, txtUsername.getText());
					ResultSet rs1 = testUserName.executeQuery();
					if (txtUsername.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa điền tên người dùng muốn xoá");
					}
					else if (!rs1.next()) {
						JOptionPane.showMessageDialog(null, "Tên người dùng không tồn tại");
					}
					else {
				User user = new User(txtUsername.getText());
				ConnJDBC.deleteUser(user);
				JOptionPane.showMessageDialog(null, "Xoá thành công");
				showData(ConnJDBC.findAllUser());
					}
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		}
		btnXo.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnXoa.Image.png"));
		btnXo.setBounds(607, 278, 123, 41);
		contentPane.add(btnXo);

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnThot.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThoat.Image.png"));
		btnThot.setBounds(607, 342, 123, 41);
		contentPane.add(btnThot);

		JLabel lblDanhSch = new JLabel("Danh s\u00E1ch");
		lblDanhSch.setBounds(69, 307, 85, 13);
		contentPane.add(lblDanhSch);

		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\refresh.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				txtPassword.setText("");
				txtRePassword.setText("");
			}
		});
		btnNewButton_1.setBounds(607, 85, 123, 41);
		contentPane.add(btnNewButton_1);
		contentPane.setVisible(true);
		showData(ConnJDBC.findAllUser());
	}

	public void showData(List<User> userl) {
		List<User> userList = new ArrayList<>();
		userList = userl;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		userList.forEach((user) -> {
			String quyen;
			if (user.getQuyen() == 0)
				quyen = "Admin";
			else {
				quyen = "Member";
			}
			tableModel.addRow(new Object[] { user.getTenDN(), user.getMatKhau(), quyen });
		});
	}
}
