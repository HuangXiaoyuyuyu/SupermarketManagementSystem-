package hxy2017.AdUI;

import hxy2017.dao.IUserDao;
import hxy2017.dao.UserDaoForDBImp;
import hxy2017.entry.User;
import hxy2017.service.UserServiceImp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JPasswordField textFieldPassword;
	
	UserServiceImp service = new UserServiceImp();
	IUserDao dao = new UserDaoForDBImp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administor frame = new Administor();
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
	public Administor() {
		setTitle("用户管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel.setBounds(50, 50, 72, 18);
		contentPane.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(150, 47, 131, 24);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(50, 100, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(150, 97, 131, 24);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setBounds(50, 150, 86, 18);
		contentPane.add(lblNewLabel_2);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(150, 147, 131, 24);
		contentPane.add(textFieldPassword);
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPassword.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
				   User	user=new User(Integer.parseInt(textFieldId.getText()) ,
						  		textFieldName.getText(),
						  		textFieldPassword.getText()
					);
				
					if(service.insert(user)){
						JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "添加失败", "提示", JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				 
			}
		});
			 
		btnNewButton.setBounds(9, 226, 77, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPassword.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
				   User	user=new User(Integer.parseInt(textFieldId.getText()) ,
						  		textFieldName.getText(),
						  		textFieldPassword.getText()
					);
				
					if(service.delete(Integer.parseInt(textFieldId.getText()))){
						JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				 
			}
		});
		btnNewButton_1.setBounds(125, 226, 72, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u66F4\u65B0");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//更新
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPassword.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
				   User	user=new User(Integer.parseInt(textFieldId.getText()) ,
						  		textFieldName.getText(),
						  		textFieldPassword.getText()
					);
				
					if(service.update(user)){
						JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "更新失败", "提示", JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				 
			}
		});
		btnNewButton_2.setBounds(241, 226, 72, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u53D6\u6D88");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(360, 226, 72, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u67E5\u8BE2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.setDao(dao);
				
				   User user = new User();
				   user= service.findById(Integer.parseInt(textFieldId.getText()));
				   textFieldName.setText(user.getName());
				   textFieldPassword.setText(user.getPassword()+"");	    
			}
		});
		btnNewButton_4.setBounds(295, 46, 113, 27);
		contentPane.add(btnNewButton_4);
	}
}
