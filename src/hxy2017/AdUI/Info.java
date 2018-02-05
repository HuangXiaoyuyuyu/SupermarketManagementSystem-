package hxy2017.AdUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import hxy2017.CoUI.CommonMainFrame;
import hxy2017.dao.GoodsDaoForDBImp;
import hxy2017.dao.IGoodsDao;
import hxy2017.entry.Goods;
import hxy2017.service.GoodsServiceImp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextPane;



public class Info extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextPane textPane;
	
	GoodsServiceImp service = new GoodsServiceImp();
	IGoodsDao dao = new GoodsDaoForDBImp();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
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
	public Info() {
		setTitle("超市商品信息统计");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.setBounds(338, 226, 94, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		textPane = new JTextPane();
		textPane.setBounds(0, 0, 430, 220);
		JScrollPane js= new JScrollPane(textPane,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js.setVisible(true);
		js.setBounds(0, 0, 430, 220);
//		contentPane.add(textPane);
		contentPane.add(js);
		
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			//查询
			public void actionPerformed(ActionEvent e) {
				service.setDao(dao);
				String string = "";
				List<Goods> al = new ArrayList<>();
				al = service.findAll();
				for(Goods t : al){
					string = t.toString()+string;
				}
				textPane.setText(string);
			}
		});
		btnNewButton_1.setBounds(235, 226, 89, 27);
		contentPane.add(btnNewButton_1);
		
		 
	}
}
