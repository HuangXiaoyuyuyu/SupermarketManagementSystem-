package hxy2017.service;

import hxy2017.entry.Goods;

public interface IGoodsService extends IService {
 
	public abstract Goods findById(int id);
	public abstract Goods findByName(String name);
}
 
