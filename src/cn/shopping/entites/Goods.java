package cn.shopping.entites;
/**
 * 商品类
 * @author admin
 *
 */
public class Goods {
	
	private String id;      // 编号
	private String name;	// 名称
	private double price;   // 价格
	private int nums;       // 剩余件数
	private double discount;// 折扣，0~1之间
	private String details; // 详细介绍
	private String path;    // 图片的路径
	
	public Goods() {
		super();
	}
	
	public Goods(String id, String name, double price, int nums, double discount, String details, String path) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.nums = nums;
		this.discount = discount;
		this.details = details;
		this.path = path;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
