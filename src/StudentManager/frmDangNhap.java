package StudentManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class frmDangNhap extends JFrame {
	private static int loggedRole;
	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangNhap frame = new frmDangNhap();
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
	public frmDangNhap() {
		setForeground(Color.BLACK);
		setTitle("\u0110\u0103ng nh\u1EADp h\u1EC7 th\u1ED1ng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("\u0110\u0102NG NH\u1EACP H\u1EC6 TH\u1ED0NG");
		label1.setForeground(Color.RED);
		label1.setBackground(Color.WHITE);
		label1.setBounds(266, 36, 162, 13);
		contentPane.add(label1);
		
		JLabel lable2 = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lable2.setBounds(198, 72, 92, 13);
		contentPane.add(lable2);
		
		JLabel lable3 = new JLabel("M\u1EADt kh\u1EA9u");
		lable3.setBounds(198, 110, 79, 13);
		contentPane.add(lable3);
		
		userNameField = new JTextField();
		userNameField.setBounds(287, 69, 151, 19);
		contentPane.add(userNameField);
		userNameField.setColumns(10);
		
		JButton button1 = new JButton("\u0110\u0103ng nh\u1EADp");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userNameField.getText();
                String password = passwordField.getText();
        		try {
        			Connection connection = ConnJDBC.getConnection();
					PreparedStatement st = connection.prepareStatement("Select TenDN, MatKhau from login where TenDN=? and MatKhau=?");
					PreparedStatement getQuyen = connection.prepareStatement("Select Quyen from login where TenDN=? and MatKhau=?");
					st.setString(1, userName);
                    st.setString(2, password);
					getQuyen.setString(1, userName);
					getQuyen.setString(2, password);
                    ResultSet rs1 = st.executeQuery();
                    ResultSet rs2 = getQuyen.executeQuery();
                    if (rs1.next()) {
                        dispose();
                        if(rs2.next()) {
                        	frmDangNhap.setLoggedRole(rs2.getInt(1));
                        }
                        frmMain ah = new frmMain();
                        ah.setVisible(true);              
                        JOptionPane.showMessageDialog(button1, "Đăng nhập thành công");
                        
                    } else {
                        JOptionPane.showMessageDialog(button1, "Tên người dùng hoặc mật khẩu sai");
                    }
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\log-in.png"));
		button1.setBounds(137, 156, 140, 41);
		contentPane.add(button1);
		
		JButton button2 = new JButton("\u0110\u0103ng k\u00FD");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				frmDangKy ah = new frmDangKy();
                ah.setVisible(true);
			}
		});
		button2.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\Eclipse_workspace\\BTL\\add-user.png"));
		button2.setBounds(309, 156, 119, 41);
		contentPane.add(button2);
		
		JButton button3 = new JButton("Tho\u00E1t");
		button3.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThoat.Image.png"));
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button3.setBounds(456, 156, 114, 41);
		contentPane.add(button3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(287, 107, 151, 19);
		contentPane.add(passwordField);
	}


	public static void setLoggedRole(int loggedRole) {
		frmDangNhap.loggedRole = loggedRole;
	}

	public static int getLoggedRole() {
		// TODO Auto-generated method stub
		return loggedRole;
	}


}
