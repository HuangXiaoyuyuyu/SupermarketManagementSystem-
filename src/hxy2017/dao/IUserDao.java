package hxy2017.dao;

import hxy2017.entry.User;

public interface IUserDao<T,Integer> extends IBaseDao<T,Integer> {
 
	public abstract User findById(int id);
	public abstract User findByName(String name);
}
 
