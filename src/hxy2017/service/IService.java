package hxy2017.service;

 
import java.util.List;

public interface IService <T,Integer>{
 
	public abstract boolean insert(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj);
	public abstract List findAll();
}
 
