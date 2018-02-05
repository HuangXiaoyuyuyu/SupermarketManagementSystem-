package hxy2017.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import hxy2017.Conn.MySQLHelper;
import hxy2017.entry.User;

public class UserDaoForDBImp implements IUserDao <User,Integer>{
 
	private Connection conn;
	 
	public UserDaoForDBImp(){
		conn = MySQLHelper.getConnect();//�����ݿ��������
	}
	 
	public User findById(int id) {
		User user = null;
		//PreparedStatement��һ���ӿڣ���̬��ִ��SQL���
		//ͨ������ʵ��ִ�еĶ�̬SQL��䣬����Ԥ���뱣�浽PreparedStatementʵ����
		//�Ӷ����Է���ִ��
		PreparedStatement ps = null; //�Ըýӿڵ�ʵ�����г�ʼ��
		try {
			String sql = "select * from users where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
	    //��PreparedStatement������ִ��SQL��䣬�����ظò�ѯ���ɵ�ResultSet����
		//ResultSet�൱��һ����ʱ����ʵ������ָ��ǰ�����е�ָ��
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		return user;
	}
	 
	/**
	 * @see hxy2017.dao.IGoodsDao#findByName(java.lang.String)
	 */
	public User findByName(String name) {
		User user = null;
		PreparedStatement ps = null;
		try {
			String  sql = "select * from users where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		return user;
	}
	
	public boolean insert(User user){
		boolean flag = false;
		
		PreparedStatement ps = null;
		
		String sql = "insert into users(id,name,password)value(?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,user.getId());
			ps.setString(2,user.getName());
			ps.setString(3,user.getPassword());
			//System.out.println(ps);
			int result = ps.executeUpdate();
			if(result >= 1){
				flag = true;
			}
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			//System.out.println(e);
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		return  flag;
	}
	
	public boolean delete(Integer id){
		boolean flag = false;
		
		PreparedStatement ps = null;
		try {
			String sql = "delete from users where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int result = ps.executeUpdate();
			if(result >=1){
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		return flag;
	}
	 public boolean update(User user){
		 boolean flag = false;
		 
		 PreparedStatement ps = null;
		 try {
			String sql = "update users set name=?,password=?where id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,user.getName());
			ps.setString(2,user.getPassword());
			ps.setInt(3,user.getId());
			//System.out.println(ps);
			int result = ps.executeUpdate();
			if (result >= 1) {
				flag = true;
				System.out.println(flag);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//System.out.println(e);
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		 return flag;
	 }
	 public List<User> queryAll(){
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 List<User> list = new ArrayList<User>();
		 try {
			String sql = "select * from users";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			User user = null;
			while(rs.next()){
				user = new User(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("password"));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MySQLHelper.closeResult(rs);
			MySQLHelper.closePreparedStatement(ps);
			
		}
		 return list;
	 }
}
