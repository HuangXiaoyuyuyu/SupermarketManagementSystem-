package hxy2017.AdUI;

import hxy2017.CoUI.CommonMainFrame;
import hxy2017.dao.IBaseDao;
import hxy2017.dao.IUserDao;
import hxy2017.dao.UserDaoForDBImp;
import hxy2017.entry.Goods;
import hxy2017.entry.User;
import hxy2017.service.GoodsServiceImp;
import hxy2017.service.IUserService;
import hxy2017.service.UserServiceImp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;

public class Logon extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPassword;
	
	private boolean isOKClose = false;
	private User user=null;
	
	UserServiceImp service = new UserServiceImp();
	IUserDao dao = new UserDaoForDBImp();
	 
	 
	
	public boolean isOkClose(){
		return isOKClose;
	}
	
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
		try {
			Logon dialog = new Logon();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
	


	/**
	 * Create the dialog.
	 */
	
	public Logon() {
		setTitle("登录界面");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(50, 100, 72, 18);
		contentPanel.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(187, 98, 122, 24);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u53E3\u4EE4\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(50, 150, 86, 18);
		contentPanel.add(lblNewLabel_1);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(187, 148, 122, 24);
		contentPanel.add(textFieldPassword);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(187, 55, 122, 24);
		contentPanel.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237ID\uFF1A");
		lblNewLabel_2.setBounds(50, 50, 72, 18);
		contentPanel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//注册
				 dispose();
				 Regist regist = new Regist();
				 regist.setVisible(true);
			}
		});
		btnNewButton.setBounds(319, 54, 99, 27);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				
				okButton.addActionListener(new ActionListener() {
					@Override
					
					public void actionPerformed(ActionEvent e) {
					
						
						service.setDao(dao);
						// TODO Auto-generated method stub
						//取界面上用户输入的数据
						//String username = textFieldName.getText().toString();
						//String password = textFieldPassword.getText();
						 
						//判断数据是否有效
						if(textFieldId.getText().equals("")||textFieldName.getText().equals("")||textFieldPassword.getText().equals("")){
							JOptionPane.showConfirmDialog(null, "用户名或口令不能为空！","警告",JOptionPane.CLOSED_OPTION);
							textFieldId.setText(null);
							textFieldName.setText(null);
							textFieldPassword.setText(null);
							return;
						}
						//用户名与口令有效
						else {
							user = getUser();
							if(service.logon(user)){
								if(Integer.parseInt(textFieldId.getText())==11111 && 
										textFieldName.getText().equals("admin") && 
										textFieldPassword.getText().equals("admin"))
								{
									JOptionPane.showConfirmDialog(null,"管理员登录成功！","友情提醒",JOptionPane.CLOSED_OPTION);
									dispose();
									MainFrame mainFrame = new MainFrame();
									mainFrame.setVisible(true);
									}
									
									else{
										JOptionPane.showConfirmDialog(null,"普通用户登录成功！","友情提醒",JOptionPane.CLOSED_OPTION);
										dispose();
										CommonMainFrame commonMainFrame = new CommonMainFrame();
										commonMainFrame.setVisible(true);
									}
									
								}else  
								{
									JOptionPane.showConfirmDialog(null,"您输入的用户名或密码有误，请重新输入！","友情提醒",JOptionPane.CLOSED_OPTION);
									textFieldId.setText(null);
									textFieldName.setText(null);
									textFieldPassword.setText(null);
								}
							
					}
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
