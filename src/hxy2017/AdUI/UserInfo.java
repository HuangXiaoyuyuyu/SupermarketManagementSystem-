package hxy2017.AdUI;

import hxy2017.CoUI.CommonMainFrame;
import hxy2017.dao.IUserDao;
import hxy2017.dao.UserDaoForDBImp;
import hxy2017.entry.User;
import hxy2017.service.UserServiceImp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	
	UserServiceImp serviceImp = new UserServiceImp();
	IUserDao dao = new UserDaoForDBImp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setTitle("用户信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 430, 220);
		JScrollPane js= new JScrollPane(textPane,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js.setVisible(true);
		js.setBounds(0, 0, 430, 220);
//		contentPane.add(textPane);
		contentPane.add(js);
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u6240\u6709\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询
				serviceImp.setDao(dao);
				String string= "";
				List<User> list = new ArrayList<>();
				list  = serviceImp.findAll();
				for(User l:list){
					string = l.toString()+string;
				}
				textPane.setText(string);
			}
		});
		btnNewButton.setBounds(190, 226, 128, 27);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 224);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame commonMainFrame = new MainFrame();
				commonMainFrame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(319, 226, 111, 27);
		contentPane.add(btnNewButton_1);
	}
}
