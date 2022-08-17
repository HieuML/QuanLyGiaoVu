package StudentManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class frmDoiMatKhau extends JFrame {

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
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
	public frmDoiMatKhau() {
		setTitle("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lable2 = new JLabel("Th\u00F4ng tin");
		lable2.setBounds(131, 42, 63, 13);
		contentPane.add(lable2);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n");
		lblNewLabel_1.setBounds(209, 66, 99, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u1EADt kh\u1EA9u c\u0169");
		lblNewLabel_2.setBounds(209, 100, 72, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_3.setBounds(209, 133, 99, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u0110\u00E1nh l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNewLabel_4.setBounds(209, 170, 99, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lable1 = new JLabel("TH\u00D4NG TIN T\u00C0I KHO\u1EA2N");
		lable1.setForeground(Color.RED);
		lable1.setBackground(Color.WHITE);
		lable1.setBounds(269, 24, 163, 13);
		contentPane.add(lable1);
		
		userNameField = new JTextField();
		userNameField.setBounds(312, 63, 185, 19);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
                String oldPassword = oldPasswordField.getText();
                String newPassword = newPasswordField.getText();
                String rePassword = rePasswordField.getText();
                PreparedStatement st;
				try {
        			Connection connection = ConnJDBC.getConnection();
					st = connection.prepareStatement("Select TenDN, MatKhau from login where TenDN=? and MatKhau=?");
					st.setString(1, userName);
	                st.setString(2, oldPassword);
	                ResultSet rs = st.executeQuery();
	                if (rs.next()) {
	                	if(newPassword.equals(rePassword))
	                	{
						st = connection.prepareStatement("UPDATE login SET MatKhau = ? WHERE TenDN = ? and MatKhau=?");
						st.setString(1, newPassword);
						st.setString(2, userName);
						st.setString(3, oldPassword);
						st.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton, "Đổi mật khẩu thành công");
						dispose();
	                	}
	                	else {
							JOptionPane.showMessageDialog(btnNewButton, "Đánh lại mật khẩu không chính xác");
	                	}
	                }
	                else
	                {
                        JOptionPane.showMessageDialog(btnNewButton, "Tên người dùng hoặc mật khẩu không chính xác");

	                }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\correct.png"));
		btnNewButton.setBounds(209, 214, 93, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tho\u00E1t");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThoat.Image.png"));
		btnNewButton_1.setBounds(394, 212, 107, 41);
		contentPane.add(btnNewButton_1);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(312, 97, 185, 19);
		contentPane.add(oldPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(312, 130, 185, 19);
		contentPane.add(newPasswordField);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(312, 167, 185, 19);
		contentPane.add(rePasswordField);
	}
}
