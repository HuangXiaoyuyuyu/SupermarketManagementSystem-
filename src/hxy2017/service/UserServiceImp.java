package hxy2017.service;

import hxy2017.dao.IUserDao;
import hxy2017.entry.User;

import java.util.List;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class UserServiceImp implements IUserService {
 
	private IUserDao dao;
	 
	public void setDao(IUserDao dao) {
	 this.dao = dao;
	}
	 
	/**
	 * @see hxy2017.service.IGoodsService#register(hxy2017.entry.Goods)
	 */
	public boolean register(User user) {
		return insert(user);
	}
	 
	/**
	 * @see hxy2017.service.IGoodsService#logon(hxy2017.entry.Goods)
	 */
	public boolean logon(User user) {
		boolean result = false;
		
		User user1 = dao.findByName(user.getName());
		if(user1!=null){
			if(user1.getId()==user.getId()){
				result=true;
			}
		}
		return result;
	}
	 
	/**
	 * @see hxy2017.service.IGoodsService#findById(int)
	 */
	public User findById(int id) {
		return dao.findById(id);
	}
	 
	/**
	 * @see hxy2017.service.IGoodsService#findByName(java.lang.String)
	 */
	public User  findByName(String name) {
		return dao.findByName(name);
	}
	
	public boolean insert(User obj){
		return dao.insert(obj);
	}
	
	public boolean delete(Integer obj){
		return  dao.delete(obj);
	}
	
	public boolean update(User obj){
		return  dao.update(obj);
	}
	
	public List<User> findAll(){
		return dao.queryAll();
	}

	@Override
	public boolean insert(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	 
}
 
