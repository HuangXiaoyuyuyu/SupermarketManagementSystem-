package hxy2017.service;

import java.util.List;

import hxy2017.dao.IGoodsDao;
import hxy2017.dao.UserDaoForDBImp;
import hxy2017.entry.Goods;

public class GoodsServiceImp implements IGoodsService {
		 
		private IGoodsDao dao;
		 
		public void setDao(IGoodsDao dao) {
		 this.dao = dao;
		}
	 
		 
		public Goods findById(int id) {
			return dao.findById(id);
		}
		 
		/**
		 * @see hxy2017.service.IGoodsService#findByName(java.lang.String)
		 */
		public Goods  findByName(String name) {
			return dao.findByName(name);
		}
		
		public boolean insert(Goods obj){
			return dao.insert(obj);
		}
		
		public boolean delete(Integer obj){
			return  dao.delete(obj);
		}
		
		public boolean update(Goods obj){
			return  dao.update(obj);
		}
		
		public List<Goods> findAll(){
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
		 
	}
	 
