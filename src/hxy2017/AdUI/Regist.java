package hxy2017.AdUI;

import hxy2017.dao.IUserDao;
import hxy2017.dao.UserDaoForDBImp;
import hxy2017.entry.User;
import hxy2017.service.UserServiceImp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	
	private User user=null;
	UserServiceImp service = new UserServiceImp();
	IUserDao dao = new UserDaoForDBImp();

	public int getUserId(){
		return Integer.parseInt(textFieldId.getText());
	}
	public void setUserId(){
		textFieldId.setText("");
	}
	
	public String getUserName(){
		return textFieldName.getText();
	}
	public void setUserName(){
		textFieldName.setText("");
	}
	
	
	public String getUserPassword(){
		return textFieldPassword.getText();
	}
	public void setUserPassword(){
		textFieldPassword.setText("");
	}
	
	
	public User getUser(){
		return new User(
				Integer.parseInt(textFieldId.getText()),
				textFieldName.getText(),
				textFieldPassword.getText());
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
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
	public Regist() {
		setTitle("用户注册界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel.setBounds(80, 50, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(80, 110, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u53E3\u4EE4:");
		lblNewLabel_2.setBounds(80, 170, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(192, 47, 152, 24);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(192, 107, 152, 24);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(192, 167, 152, 24);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//注册
				
				service.setDao(dao);
				// TODO Auto-generated method stub
				//取界面上用户输入的数据
				//String username = textFieldName.getText().toString();
				//String password = textFieldPassword.getText();
				 
				//判断数据是否有效
				if(textFieldId.getText().equals("")||textFieldName.getText().equals("")||textFieldPassword.getText().equals("")){
					JOptionPane.showConfirmDialog(null, "用户名或口令不能为空！","警告",JOptionPane.CLOSED_OPTION);
					textFieldName.setText(null);
					textFieldPassword.setText(null);
					return;
				}
				//用户名与口令有效
				else {
					user = getUser();
					if(service.register(user)){
					JOptionPane.showConfirmDialog(null,"注册成功！","友情提醒",JOptionPane.CLOSED_OPTION);
					dispose();
					Logon logon = new Logon();
					logon.setVisible(true);
				}
				else  {
					JOptionPane.showConfirmDialog(null,"注册失败，重新注册","友情提醒",JOptionPane.CLOSED_OPTION);
					textFieldId.setText(null);
					textFieldName.setText(null);
					textFieldPassword.setText(null);
				}
			}
			}
		});
		button.setBounds(137, 226, 113, 27);
		contentPane.add(button);
	}

}
