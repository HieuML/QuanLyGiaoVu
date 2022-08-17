package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class frmLop extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JTextField txtMaKhoa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLop frame = new frmLop();
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
	public frmLop() {
		setTitle("Qu\u1EA3n l\u00FD l\u1EDBp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 953, 511);
		contentPane.add(contentPane_1);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ LỚP");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(442, 32, 92, 13);
		contentPane_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(46, 54, 306, 403);
		contentPane_1.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Lựa chọn");
		lblNewLabel_1.setBounds(10, 10, 60, 13);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("M\u00E3 l\u1EDBp");
		lblNewLabel_3.setBounds(25, 51, 45, 13);
		panel.add(lblNewLabel_3);

		txtMaLop = new JTextField();
		txtMaLop.setColumns(10);
		txtMaLop.setBounds(87, 48, 140, 19);
		panel.add(txtMaLop);

		JLabel lblNewLabel_3_1 = new JLabel("T\u00EAn l\u1EDBp");
		lblNewLabel_3_1.setBounds(25, 93, 45, 13);
		panel.add(lblNewLabel_3_1);

		txtTenLop = new JTextField();
		txtTenLop.setColumns(10);
		txtTenLop.setBounds(87, 90, 140, 19);
		panel.add(txtTenLop);

		JLabel lblNewLabel_3_1_1 = new JLabel("T\u00EAn khoa");
		lblNewLabel_3_1_1.setBounds(25, 134, 60, 13);
		panel.add(lblNewLabel_3_1_1);

		txtMaKhoa = new JTextField();
		txtMaKhoa.setColumns(10);
		txtMaKhoa.setBounds(87, 131, 140, 19);
		panel.add(txtMaKhoa);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(418, 55, 365, 403);
		contentPane_1.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("Danh sách");
		lblNewLabel_2.setBounds(10, 10, 54, 13);
		panel_1.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 345, 358);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, "", null }, { null, null, null }, { null, null, null },
								{ null, null, null }, { null, null, null }, },
						new String[] { "MaLop", "TenLop", "MaKhoa" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaLop.setText("");
				txtTenLop.setText("");
				txtMaKhoa.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\refresh.png"));
		btnNewButton_1.setBounds(817, 92, 112, 41);
		contentPane_1.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaLop = connection.prepareStatement("SELECT * from lop where MaLop = ?;");
						PreparedStatement testMaKhoa = connection.prepareStatement("SELECT * from Khoa where MaKhoa = ?;");
						testMaLop.setString(1, txtMaLop.getText());
						testMaKhoa.setString(1, txtMaKhoa.getText());
						ResultSet rs1 = testMaLop.executeQuery();
						ResultSet rs2 = testMaKhoa.executeQuery();

						if (rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã lớp đã tồn tại");
						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Mã khoa không tồn tại");

						} else {
							Lop lop = new Lop(txtMaLop.getText(), txtTenLop.getText(), txtMaKhoa.getText());
							ConnJDBC.insertLop(lop);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							showData(ConnJDBC.findAllLop());
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
		btnNewButton.setBounds(817, 158, 112, 41);
		contentPane_1.add(btnNewButton);

		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaLop = connection.prepareStatement("SELECT * from lop where MaLop = ?;");
						PreparedStatement testMaKhoa = connection.prepareStatement("SELECT * from Khoa where MaKhoa = ?;");
						testMaLop.setString(1, txtMaLop.getText());
						testMaKhoa.setString(1, txtMaKhoa.getText());
						ResultSet rs1 = testMaLop.executeQuery();
						ResultSet rs2 = testMaKhoa.executeQuery();
						if (txtMaLop.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã lớp muốn sửa");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã lớp không tồn tại");

						} else if (!rs2.next()) {
							JOptionPane.showMessageDialog(null, "Mã khoa không tồn tại");

						} else {
							Lop lop = new Lop(txtMaLop.getText(), txtTenLop.getText(), txtMaKhoa.getText());
							ConnJDBC.updateLop(lop);
							JOptionPane.showMessageDialog(null, "Cập nhật thành công");
							showData(ConnJDBC.findAllLop());
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

		btnSa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnSua.Image.png"));
		btnSa.setBounds(817, 222, 112, 41);
		contentPane_1.add(btnSa);

		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaLop = connection.prepareStatement("SELECT * from lop where MaLop = ?;");
						testMaLop.setString(1, txtMaLop.getText());
						ResultSet rs1 = testMaLop.executeQuery();
						if (txtMaLop.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chưa điền mã lớp muốn xoá");
						} else if (!rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã lớp không tồn tại");

						} else {
							Lop lop = new Lop(txtMaLop.getText());
							ConnJDBC.deleteLop(lop);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
							showData(ConnJDBC.findAllLop());
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
		btnXo.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnXoa.Image.png"));
		btnXo.setBounds(817, 285, 112, 41);
		contentPane_1.add(btnXo);

		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThoat.Image.png"));
		btnThot.setBounds(817, 349, 112, 41);
		contentPane_1.add(btnThot);
		showData(ConnJDBC.findAllLop());
	}

	public void showData(List<Lop> lopL) {
		List<Lop> lopList = new ArrayList<>();
		lopList = lopL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		lopList.forEach((lop) -> {

			tableModel.addRow(new Object[] { lop.getMaLop(), lop.getTenLop(), lop.getMaKhoa() });
		});
	}
}
