package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class frmDangKy extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JPasswordField rePasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDoiMatKhau frame = new frmDoiMatKhau();
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
	public frmDangKy() {
		setTitle("\u0110\u0103ng k\u00FD t\u00E0i kho\u1EA3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lable2 = new JLabel("Th\u00F4ng tin");
		lable2.setBounds(131, 40, 63, 13);
		contentPane.add(lable2);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel_1.setBounds(209, 64, 101, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u ");
		lblNewLabel_2.setBounds(209, 98, 72, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_3.setBounds(209, 131, 101, 13);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Quyền ");
		lblNewLabel_5.setBounds(209, 165, 85, 13);
		contentPane.add(lblNewLabel_5);

		JComboBox cbQuyen = new JComboBox();
		cbQuyen.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Member"}));
		cbQuyen.setBounds(312, 165, 185, 21);
		contentPane.add(cbQuyen);

		JLabel lable1 = new JLabel("TH\u00D4NG TIN T\u00C0I KHO\u1EA2N");
		lable1.setForeground(Color.RED);
		lable1.setBackground(Color.WHITE);
		lable1.setBounds(244, 21, 163, 13);
		contentPane.add(lable1);

		userNameField = new JTextField();
		userNameField.setBounds(312, 61, 185, 19);
		contentPane.add(userNameField);
		userNameField.setColumns(10);

		JButton button1 = new JButton("Ok");
		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
				String password = passwordField.getText();
				String rePassword = rePasswordField.getText();
				int quyen = cbQuyen.getSelectedIndex();
				if(password.equals(rePassword))
				{
					try {
							Connection connection = ConnJDBC.getConnection();
							PreparedStatement testUserName = connection.prepareStatement("SELECT * from login where TenDN  IN (?);");
							PreparedStatement testQuyen = connection.prepareStatement("SELECT * from login where Quyen  IN (?);");
							testUserName.setString(1, userName);
							testQuyen.setInt(1, 0);
							ResultSet rs1 = testUserName.executeQuery();
							ResultSet rs2 = testQuyen.executeQuery();

							if (rs1.next()) {
								JOptionPane.showMessageDialog(button1, "Tên người dùng đã tồn tại");
							}
							else if(rs2.next()&&quyen==0)
							{
								JOptionPane.showMessageDialog(button1, "Đã tồn tại Admin");

							}
							else
							{
								PreparedStatement signup = connection.prepareStatement("Insert into login(TenDN,MatKhau,Quyen) values(?,?,?)");
								signup.setString(1, userName);
								signup.setString(2, password);
								signup.setInt(3, quyen);

								signup.executeUpdate();
								JOptionPane.showMessageDialog(button1, "Đăng ký thành công");
								dispose();
		                        frmDangNhap ah = new frmDangNhap();
		                        ah.setVisible(true);
							}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(button1, "Mật khẩu không chính xác");
				}
					
			
			}

				
		});
		button1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\correct.png"));
		button1.setBounds(209, 209, 93, 39);
		contentPane.add(button1);

		JButton button2 = new JButton("Tho\u00E1t");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frmDangNhap ah = new frmDangNhap();
                ah.setVisible(true);
			}
		});
		button2.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThoat.Image.png"));
		button2.setBounds(390, 208, 107, 41);
		contentPane.add(button2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(312, 95, 185, 19);
		contentPane.add(passwordField);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(312, 128, 185, 19);
		contentPane.add(rePasswordField);
	}

}
