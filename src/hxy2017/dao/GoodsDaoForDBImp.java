package hxy2017.dao;

import hxy2017.entry.Goods;
import hxy2017.Conn.MySQLHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


//GoodDaoForDBImp实现IGoodsDao,而IGoodsDao继承IBaseDao，所以此类实现了上述接口的所有方法
public class GoodsDaoForDBImp implements IGoodsDao<Goods,Integer> {
 
	private Connection conn;//声明Connection对象
	 
	public GoodsDaoForDBImp(){
		conn = MySQLHelper.getConnect();//与数据库进行连接
	}
	/**
	 * @see hxy2017.dao.IGoodsDao#findById(int)
	 */
	public Goods findById(int id) {
		Goods goods = null;
		//PreparedStatement是一个接口，动态的执行SQL语句
		//通过它的实例执行的动态SQL语句，将被预编译保存到PreparedStatement实例中
		//从而可以反复执行
		PreparedStatement ps = null; //对该接口的实例进行初始化
		try {
			String sql = "select * from goodgood where goodsId=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
	    //在PreparedStatement对象中执行SQL语句，并返回该查询生成的ResultSet对象
		//ResultSet相当于一个临时表，其实例具有指向当前数据行的指针
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				goods = new Goods(rs.getInt("goodsId"),
						rs.getString("goodsName"),
						rs.getInt("goodsPrice"),
						rs.getInt("goodsNUm"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		return goods;
	}
	 
	/**
	 * @see hxy2017.dao.IGoodsDao#findByName(java.lang.String)
	 */
	public Goods findByName(String name) {
		Goods goods = null;
		PreparedStatement ps = null;
		try {
			String  sql = "select * from goodgood where goodsName=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				goods = new Goods(rs.getInt("goodsId"),
						rs.getString("goodsName"),
						rs.getInt("goodsPrice"),
						rs.getInt("goodsNUm"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			MySQLHelper.closePreparedStatement(ps);
		}
		return goods;
	}
	
	public boolean insert(Goods goods){
		boolean flag = false;
		
		PreparedStatement ps = null;
		
		String sql = "insert into goodgood(goodsId,goodsName,goodsPrice,goodsNum)value(?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,goods.getGoodsId());
			ps.setString(2, goods.getGoodsName());
			ps.setInt(3,goods.getGoodsPrice());
			ps.setInt(4, goods.getGoodsNum());
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
			String sql = "delete from goodgood where goodsId=?";
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
	 public boolean update(Goods goods){
		 boolean flag = false;
		 
		 PreparedStatement ps = null;
		 try {
			String sql = "update goodgood set goodsName=?,goodsPrice=?,goodsNum=? where goodsId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setInt(2,goods.getGoodsPrice());
			ps.setInt(3, goods.getGoodsNum());
			ps.setInt(4,goods.getGoodsId());
			System.out.println(ps);
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
	 public List<Goods> queryAll(){
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 List<Goods> list = new ArrayList<Goods>();
		 try {
			String sql = "select * from goodgood";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			Goods goods = null;
			while(rs.next()){
				goods = new Goods(rs.getInt("goodsId"),
						rs.getString("goodsName"),
						rs.getInt("goodsPrice"),
						rs.getInt("goodsNUm"));
						list.add(goods);
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
 
