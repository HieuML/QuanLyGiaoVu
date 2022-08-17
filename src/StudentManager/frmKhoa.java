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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
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

public class frmKhoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKhoa;
	private JTextField txtTenKhoa;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmKhoa frame = new frmKhoa();
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
	public frmKhoa() {
		setTitle("Qu\u1EA3n l\u00FD khoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHOA");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(428, 32, 92, 13);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 54, 306, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("L\u1EF1a ch\u1ECDn");
		lblNewLabel_1.setBounds(10, 10, 91, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E3 khoa");
		lblNewLabel_3.setBounds(25, 51, 62, 13);
		panel.add(lblNewLabel_3);
		
		txtMaKhoa = new JTextField();
		txtMaKhoa.setBounds(87, 48, 140, 19);
		panel.add(txtMaKhoa);
		txtMaKhoa.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("T\u00EAn khoa");
		lblNewLabel_3_1.setBounds(25, 93, 62, 13);
		panel.add(lblNewLabel_3_1);
		
		txtTenKhoa = new JTextField();
		txtTenKhoa.setColumns(10);
		txtTenKhoa.setBounds(87, 90, 140, 19);
		panel.add(txtTenKhoa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(418, 55, 365, 403);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Danh s\u00E1ch");
		lblNewLabel_2.setBounds(10, 10, 54, 13);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 345, 358);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"MaKhoa", "TenKhoa"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaKhoa.setText("");
				txtTenKhoa.setText("");
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\refresh.png"));
		btnNewButton_1.setBounds(819, 90, 124, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
						Connection connection = ConnJDBC.getConnection();
						PreparedStatement testMaKhoa = connection
								.prepareStatement("SELECT * from khoa where MaKhoa = ?;");
						testMaKhoa.setString(1, txtMaKhoa.getText());
						ResultSet rs1 = testMaKhoa.executeQuery();
						if (rs1.next()) {
							JOptionPane.showMessageDialog(null, "Mã khoa đã tồn tại");
						}
						else {
							Khoa khoa = new Khoa(txtMaKhoa.getText(),txtTenKhoa.getText());
							ConnJDBC.insertKhoa(khoa);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							showData(ConnJDBC.findAllKhoa());
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThemmoi.Image.png"));
		btnNewButton.setBounds(819, 156, 124, 41);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
					Connection connection = ConnJDBC.getConnection();
					PreparedStatement testMaKhoa = connection
							.prepareStatement("SELECT * from khoa where MaKhoa = ?;");
					testMaKhoa.setString(1, txtMaKhoa.getText());
					ResultSet rs1 = testMaKhoa.executeQuery();
					
					if (txtMaKhoa.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa điền mã khoa muốn sửa");
					}
					else if (!rs1.next()) {
						JOptionPane.showMessageDialog(null, "Mã khoa không tồn tại");
					}
					else 
					{
						Khoa khoa = new Khoa(txtMaKhoa.getText(),txtTenKhoa.getText());
						ConnJDBC.updateKhoa(khoa);
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
						showData(ConnJDBC.findAllKhoa());
					}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");
				}
				
			}
		});
		btnSa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnSua.Image.png"));
		btnSa.setBounds(819, 220, 124, 41);
		contentPane.add(btnSa);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
					Connection connection = ConnJDBC.getConnection();
					PreparedStatement testMaKhoa = connection
							.prepareStatement("SELECT * from khoa where MaKhoa = ?;");
					testMaKhoa.setString(1, txtMaKhoa.getText());
					ResultSet rs1 = testMaKhoa.executeQuery();
					
					if (txtMaKhoa.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Chưa điền mã khoa muốn xoá");
					}
					else if (!rs1.next()) {
						JOptionPane.showMessageDialog(null, "Mã khoa không tồn tại");
					}
					else 
					{
						Khoa khoa = new Khoa(txtMaKhoa.getText());
						ConnJDBC.deleteKhoa(khoa);
						JOptionPane.showMessageDialog(null, "Xoá thành công");
						showData(ConnJDBC.findAllKhoa());
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
		btnXo.setBounds(819, 283, 124, 41);
		contentPane.add(btnXo);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\btnThoat.Image.png"));
		btnThot.setBounds(819, 347, 124, 41);
		contentPane.add(btnThot);
		showData(ConnJDBC.findAllKhoa());
	}
	public void showData(List<Khoa> khoaL) {
		List<Khoa> khoaList = new ArrayList<>();
		khoaList = khoaL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		khoaList.forEach((khoa) -> {
			tableModel.addRow(new Object[] {khoa.getMaKhoa(),khoa.getTenKhoa() });
		});
	}

}
