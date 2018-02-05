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
		conn = MySQLHelper.getConnect();//与数据库进行连接
	}
	 
	public User findById(int id) {
		User user = null;
		//PreparedStatement是一个接口，动态的执行SQL语句
		//通过它的实例执行的动态SQL语句，将被预编译保存到PreparedStatement实例中
		//从而可以反复执行
		PreparedStatement ps = null; //对该接口的实例进行初始化
		try {
			String sql = "select * from users where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
	    //在PreparedStatement对象中执行SQL语句，并返回该查询生成的ResultSet对象
		//ResultSet相当于一个临时表，其实例具有指向当前数据行的指针
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
