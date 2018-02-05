package hxy2017.CoUI;

import hxy2017.AdUI.About;
import hxy2017.AdUI.Info;
import hxy2017.AdUI.Logon;
import hxy2017.AdUI.Operation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonMainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CommonMainFrame frame = new CommonMainFrame();
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
	public CommonMainFrame() {
		setTitle("用户管理界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u5546\u54C1\u83DC\u5355");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6DFB\u52A0 \u4FEE\u6539 \u5220\u9664");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 CoOperation operation = new CoOperation();
				 operation.setVisible(true);
			}
		});
		 
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("\u67E5\u770B\u5546\u54C1\u4FE1\u606F");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CoInfo info = new CoInfo();
				info.setVisible(true);
			}
		});
		mnNewMenu.add(mntmExit);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logon logon = new Logon();
				logon.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu menu_1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_1);
		
		JMenuItem about_1 = new JMenuItem("\u5173\u4E8E");
		about_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AAbout about = new AAbout();
				about.setVisible(true);
			}
		});
		menu_1.add(about_1);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBackground(Color.CYAN);
		textField.setForeground(Color.RED);
		textField.setFont(new Font("宋体", Font.PLAIN, 35));
		textField.setText("       \u8BA4\u771F\u5DE5\u4F5C\uFF01");
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
