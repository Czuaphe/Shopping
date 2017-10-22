package cn.shopping.entites;
/**
 * ��Ʒ��
 * @author admin
 *
 */
public class Goods {
	
	private String id;      // ���
	private String name;	// ����
	private double price;   // �۸�
	private int nums;       // ʣ�����
	private double discount;// �ۿۣ�0~1֮��
	private String details; // ��ϸ����
	private String path;    // ͼƬ��·��
	
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
