package hxy2017.dao;

import hxy2017.entry.Goods;

public interface IGoodsDao<T,Integer> extends IBaseDao<T,Integer> {
 
	public abstract Goods findById(int id);
	public abstract Goods findByName(String name);
}
 
