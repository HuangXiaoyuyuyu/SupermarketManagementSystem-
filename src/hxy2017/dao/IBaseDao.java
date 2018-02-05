package hxy2017.dao;


import java.util.List;

public interface IBaseDao<T,Integer> {
 
	public abstract boolean insert(T obj);
	public abstract boolean delete(Integer id);
	public abstract boolean update(T obj);
	public abstract List queryAll();
}
 
