package hxy2017.AdUI;

import hxy2017.dao.GoodsDaoForDBImp;
import hxy2017.dao.IGoodsDao;
import hxy2017.entry.Goods;
import hxy2017.service.GoodsServiceImp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Operation extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldNum;
	GoodsServiceImp service = new GoodsServiceImp();
	IGoodsDao dao = new GoodsDaoForDBImp();
	 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operation frame = new Operation();
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
	public Operation() {
		setTitle("修改商品信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setBounds(50, 30, 90, 18);
		contentPane.add(lblNewLabel);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(184, 28, 124, 24);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D\u79F0\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(50, 80, 90, 18);
		contentPane.add(label);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(184, 78, 124, 24);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u4EF7\u683C\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		label_1.setBounds(50, 130, 90, 18);
		contentPane.add(label_1);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(184, 128, 124, 24);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5546\u54C1\u6570\u91CF\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		label_2.setBounds(50, 180, 90, 18);
		contentPane.add(label_2);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(183, 178, 125, 24);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//插入
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPrice.getText().equals("")||
						textFieldNum.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
				  Goods	goods=new Goods(Integer.parseInt(textFieldId.getText()) ,
						  		textFieldName.getText(),
						  		Integer.parseInt(textFieldPrice.getText()),
						  		Integer.parseInt(textFieldNum.getText()));
					if(service.insert(goods)){
						JOptionPane.showMessageDialog(null, "添加成功", "提示", JOptionPane.PLAIN_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "添加失败", "提示", JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				 
			}
		});
		btnNewButton.setBounds(24, 226, 77, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame mainFrame = new MainFrame();
				mainFrame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(341, 226, 77, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPrice.getText().equals("")||
						textFieldNum.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
				  Goods	goods=new Goods(Integer.parseInt(textFieldId.getText()) ,
						  		textFieldName.getText(),
						  		Integer.parseInt(textFieldPrice.getText()),
						  		Integer.parseInt(textFieldNum.getText()));
					if(service.delete(Integer.parseInt(textFieldId.getText()))){
						JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				 
			
			}
		});
		btnNewButton_2.setBounds(127, 226, 71, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u66F4\u65B0");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//更新
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPrice.getText().equals("")||
						textFieldNum.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
				  Goods	goods=new Goods(Integer.parseInt(textFieldId.getText()) ,
						  		textFieldName.getText(),
						  		Integer.parseInt(textFieldPrice.getText()),
						  		Integer.parseInt(textFieldNum.getText()));
					if(service.update(goods)){
						JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "更新失败", "提示", JOptionPane.PLAIN_MESSAGE);
					}
					
				}
				 
			
			}
		});
		btnNewButton_3.setBounds(218, 226, 90, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u663E\u793A");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询
				service.setDao(dao);
				if(textFieldId.getText().equals("")||
						textFieldName.getText().equals("")||
						textFieldPrice.getText().equals("")||
						textFieldNum.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "输入信息不完整！");
				}else {
					  Goods goods = new Goods();
					   goods= service.findById(Integer.parseInt(textFieldId.getText()));
					   textFieldName.setText(goods.getGoodsName());
					   textFieldPrice.setText(goods.getGoodsPrice()+"");
					   textFieldNum.setText(goods.getGoodsNum()+"");
				}
				
					   
			}
		});
		btnNewButton_4.setBounds(319, 27, 113, 27);
		contentPane.add(btnNewButton_4);
	}
}
