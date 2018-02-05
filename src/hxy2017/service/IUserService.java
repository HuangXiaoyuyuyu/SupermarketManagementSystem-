package hxy2017.service;

import hxy2017.entry.User;

public interface IUserService extends IService {
 
	public abstract boolean regist(User user);
	public abstract boolean logon(User user);
	public abstract User findById(int id);
	public abstract User findByName(String name);
}
 
