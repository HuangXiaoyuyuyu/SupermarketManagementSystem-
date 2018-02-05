package hxy2017.entry;

public class Goods {
 
	private int goodsId;
	 
	private int goodsPrice;
	 
	private String goodsName;
	 
	public Goods() {
		super();
	}
	private int goodsNum;
	 
	
	
	public Goods(int goodsId,  String goodsName, int goodsPrice,int goodsNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsNum = goodsNum;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	 
	public int getGoodsId() {
		return goodsId;
	}
	 
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	 
	public int getGoodsPrice() {
		return goodsPrice;
	}
	 
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	 
	public String getGoodsName() {
		return goodsName;
	}
	 
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	 
	public int getGoodsNum() {
		return goodsNum;
	}
	public String toString() {
		return "[" +"商品编号："+ goodsId + ", " +"商品名称："+
							goodsName + ", " +"商品价格："+
							goodsPrice + ", " +"商品数量"+
							goodsNum +"]"+"\n";
	} 
}
 
