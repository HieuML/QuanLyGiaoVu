package StudentManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class frmGvHp extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHocPhan;
	private JTextField txtHocKi;
	private JTextField txtSoLop;
	private JTextField txtMaGV;
	private JTable table;
	private Integer SoLop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmGvHp frame = new frmGvHp();
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
	public frmGvHp() {
		setTitle("Thông tin học phần và giảng viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(38, 86, 509, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Th\u00F4ng tin chi ti\u1EBFt");
		lblNewLabel_1.setBounds(10, 10, 111, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E3 h\u1ECDc ph\u1EA7n");
		lblNewLabel_2.setBounds(10, 31, 77, 13);
		panel.add(lblNewLabel_2);
		
		txtMaHocPhan = new JTextField();
		txtMaHocPhan.setBounds(108, 28, 96, 19);
		panel.add(txtMaHocPhan);
		txtMaHocPhan.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("H\u1ECDc k\u1EF3");
		lblNewLabel_2_1.setBounds(10, 60, 77, 13);
		panel.add(lblNewLabel_2_1);
		
		txtHocKi = new JTextField();
		txtHocKi.setColumns(10);
		txtHocKi.setBounds(108, 57, 96, 19);
		panel.add(txtHocKi);
		
		JLabel lblNewLabel_2_2 = new JLabel("S\u1ED1 l\u1EDBp");
		lblNewLabel_2_2.setBounds(238, 57, 77, 13);
		panel.add(lblNewLabel_2_2);
		
		txtSoLop = new JTextField();
		txtSoLop.setColumns(10);
		txtSoLop.setBounds(336, 54, 96, 19);
		panel.add(txtSoLop);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("M\u00E3 gi\u00E1o vi\u00EAn");
		lblNewLabel_2_2_1.setBounds(238, 28, 77, 13);
		panel.add(lblNewLabel_2_2_1);
		
		txtMaGV = new JTextField();
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(336, 25, 96, 19);
		panel.add(txtMaGV);
		
		JLabel lblNewLabel = new JLabel("HỌC PHẦN - GIẢNG VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(361, 26, 143, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMaHocPhan.setText("");
				txtMaGV.setText("");
				txtHocKi.setText("");
				txtSoLop.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\refresh.png"));
		btnNewButton_1.setBounds(631, 85, 135, 41);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
				try {
					Connection connection = ConnJDBC.getConnection();
					PreparedStatement testMaHocPhan = connection
							.prepareStatement("SELECT * from hocphan where MaHocPhan = ?;");
					PreparedStatement testMaGV = connection
							.prepareStatement("SELECT * from giang_vien where MaGV = ?;");
					PreparedStatement testGvHp = connection
							.prepareStatement("SELECT * from hocphan_gv where MaHocPhan = ? and MaGV = ? and HocKi = ?;");

					testMaHocPhan.setString(1, txtMaHocPhan.getText());
					ResultSet rs1 = testMaHocPhan.executeQuery();

					testMaGV.setString(1, txtMaGV.getText());
					ResultSet rs2 = testMaGV.executeQuery();
                    
					testGvHp.setString(1, txtMaHocPhan.getText());
					testGvHp.setString(2, txtMaGV.getText());
					testGvHp.setString(3, txtHocKi.getText());

					ResultSet rs3 = testGvHp.executeQuery();

					if (!rs1.next()) {
						JOptionPane.showMessageDialog(null, "Mã học phần không tồn tại");
					}
					else if (!rs2.next()){
						JOptionPane.showMessageDialog(null, "Mã giảng viên không tồn tại");
					}
					else if (rs3.next()){
						JOptionPane.showMessageDialog(null, "Số lớp này đã được nhập");
					}
					else {
						SoLop = SoLop.parseInt(txtSoLop.getText());
						HocPhan_GV hp_gv = new HocPhan_GV(txtMaHocPhan.getText(),txtMaGV.getText(),txtHocKi.getText(), SoLop);
						ConnJDBC.insertGvHp(hp_gv);
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						showData(ConnJDBC.findAllGvHp());
					}
						
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");

				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThemmoi.Image.png"));
		btnNewButton.setBounds(631, 151, 135, 41);
		contentPane.add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
				     	Connection connection = ConnJDBC.getConnection();
						PreparedStatement testGvHp = connection
								.prepareStatement("SELECT * from hocphan_gv where MaHocPhan = ? and MaGV = ? and HocKi = ?");
						testGvHp.setString(1, txtMaHocPhan.getText());
						testGvHp.setString(2, txtMaGV.getText());
						testGvHp.setString(3, txtHocKi.getText());

						ResultSet rs1 = testGvHp.executeQuery();

						if(txtMaHocPhan.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Chưa điền mã học phần muốn sửa");

						}
						else if(txtMaGV.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Chưa điền mã giảng viên muốn sửa");

						}
						else if(txtHocKi.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Chưa điền học kì phần muốn sửa");

						}
						else if(!rs1.next())
						{
							JOptionPane.showMessageDialog(null, "Không tồn tại");

						}
						else {
							SoLop = SoLop.parseInt(txtSoLop.getText());

							HocPhan_GV hp_gv = new HocPhan_GV(txtMaHocPhan.getText(),txtMaGV.getText(),txtHocKi.getText(),SoLop);
							ConnJDBC.updateGvHp(hp_gv);
							JOptionPane.showMessageDialog(null, "Sửa thành công");
							showData(ConnJDBC.findAllGvHp());
						}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}	
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");

				}
				
			}
		});
		btnSa.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnSua.Image.png"));
		btnSa.setBounds(631, 215, 135, 41);
		contentPane.add(btnSa);
		
		JButton btnXo = new JButton("Xoá");
		btnXo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(frmDangNhap.getLoggedRole() == 0)
				{
					try {
				     	Connection connection = ConnJDBC.getConnection();
						PreparedStatement testGvHp = connection
								.prepareStatement("SELECT * from hocphan_gv where MaHocPhan = ? and MaGV = ? and HocKi = ?");
						testGvHp.setString(1, txtMaHocPhan.getText());
						testGvHp.setString(2, txtMaGV.getText());
						testGvHp.setString(3, txtHocKi.getText());

						ResultSet rs1 = testGvHp.executeQuery();
						if(txtMaHocPhan.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Chưa điền mã học phần muốn xoá");

						}
						else if(txtMaGV.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Chưa điền mã giảng viên muốn xoá");

						}
						else if(txtHocKi.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Chưa điền học kỳ muốn xoá");

						}
						else if(!rs1.next())
						{
							JOptionPane.showMessageDialog(null, "Không tồn tại");

						}
						else {
							
							HocPhan_GV hp_gv = new HocPhan_GV(txtMaHocPhan.getText(),txtMaGV.getText(),txtHocKi.getText());
							ConnJDBC.deleteGvHp(hp_gv);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
							showData(ConnJDBC.findAllGvHp());
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Bạn không có quyền thực hiện chức năng này! ");

				}
				
			}
		});
		btnXo.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnXoa.Image.png"));
		btnXo.setBounds(631, 278, 135, 41);
		contentPane.add(btnXo);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\btnThoat.Image.png"));
		btnThot.setBounds(631, 415, 135, 41);
		contentPane.add(btnThot);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(38, 205, 509, 234);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Danh s\u00E1ch");
		lblNewLabel_3.setBounds(10, 10, 67, 13);
		panel_1.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 489, 193);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 h\u1ECDc ph\u1EA7n", "M\u00E3 gi\u1EA3ng vi\u00EAn", "H\u1ECDc k\u00EC", "S\u1ED1 l\u1EDBp"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<HocPhan_GV> GvHpList = new ArrayList<>();
				String query = null;
				if(txtMaHocPhan.getText().equals("")) {
					 query = "select * from hocphan_gv where MaGV = '" + txtMaGV.getText() + "' and HocKi = '" + txtHocKi.getText() +"' order by HocKi;";
				}
				else if(txtMaGV.getText().equals(""))
				{
					 query = "select * from hocphan_gv where MaHocPhan = '" + txtMaHocPhan.getText() + "' and HocKi = '" + txtHocKi.getText() +"' order by HocKi;";
				} else {
					 query = "select * from hocphan_gv where MaGV = '" + txtMaGV.getText() +"' and MaHocPhan = '" + txtMaHocPhan.getText() + "' and HocKi = '" + txtHocKi.getText() +"' order by HocKi;";

				}
				try {
					Connection connection = ConnJDBC.getConnection();
					Statement stmt = connection.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while (rs.next()) {
						HocPhan_GV hp_gv = new HocPhan_GV(rs.getString("MaHocPhan"),rs.getString("MaGV"),rs.getString("HocKi"),rs.getInt("SoLop"));
						GvHpList.add(hp_gv);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				showData(GvHpList);
			}
		});
		btnTmKim.setIcon(new ImageIcon("C:\\Users\\Hieu\\Desktop\\LTNC\\BTL\\BTL\\search.png"));
		btnTmKim.setBounds(631, 347, 135, 41);
		contentPane.add(btnTmKim);
		showData(ConnJDBC.findAllGvHp());
	}
	public void showData(List<HocPhan_GV> HpGvL) {
		List<HocPhan_GV> HpGvList = new ArrayList<>();
		HpGvList = HpGvL;
		DefaultTableModel tableModel;
		table.getModel();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		HpGvList.forEach((hocphan_gv) -> {
			tableModel.addRow(new Object[] {hocphan_gv.getMaHocPhan(),hocphan_gv.getMaGV(),hocphan_gv.getHocKi(),hocphan_gv.getSoLop()});
		});
	}
}
