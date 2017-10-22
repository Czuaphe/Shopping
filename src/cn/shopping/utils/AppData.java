package cn.shopping.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.shopping.entites.Goods;
import cn.shopping.entites.User;

public class AppData {
	
	private static AppData appData = new AppData();  // 单例模式
	
	private User user;    // 当前正在使用的用户，登录之前为空
	
	private List<User> userList;  // 所有用户，获得实例时自动加载
	
	private List<Goods> goodsList;  // 所有商品，获得实例时自动加载

	private Map<Goods, Integer> shoppingCart = new HashMap<>();  // 购物车，用户正在购物的情况
	
	private String userPath = "./data/user.txt";  // 用户文件路径
	
	private String goodsPath = "./data/goods.txt";  // 商品文件路径
	
	private AppData() {
		// 从文件中读取所有的用户和商品
		userList = getAllUser();
		goodsList = getAllGoods();
		
	}
	
	public static AppData getInstance() {
		return appData;
	}
	
	public static void main(String[] args) {
		AppData appData = AppData.getInstance();
		List<Goods> goodsList = appData.getGoodsList();
		for (Goods goods : goodsList) {
			System.out.println(goods.getName());
			System.out.println(goods.getPath());
		}
		
	}
	
	public User getUser() {
		return user;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}
	
	public Map<Goods, Integer> getShoppingCart() {
		
		return shoppingCart;
	}

	public List<User> getUserList() {
		return userList;
	}
	// 从用户文件中读取所有用户
	private List<User> getAllUser() {
		List<User> userList = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(new File(userPath));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data = null;
			while((data = bufferedReader.readLine())!= null) {
				String[] elements = data.split(",");
				userList.add(new User(elements[0], elements[1], Double.parseDouble(elements[2]), Integer.parseInt(elements[3])));
				data = null;
			}
			bufferedReader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	// 从商品文件中读取所有商品
	private List<Goods> getAllGoods() {
		
		List<Goods> goodsList = new ArrayList<>();
		
		try {
			FileReader fileReader = new FileReader(new File(goodsPath));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data = null;
			while((data = bufferedReader.readLine()) != null) {
				String[] elements = data.split(",");
				goodsList.add(new Goods(elements[0], elements[1], Double.parseDouble(elements[2]), Integer.parseInt(elements[3]), Double.parseDouble(elements[4]), elements[5], elements[6]));
			}
			bufferedReader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return goodsList;
	}
	
	public Boolean saveUser() {
		
		try {
			FileWriter fileWriter = new FileWriter(new File(userPath));
			
			for (User user : userList) {
				fileWriter.write(user.getName() + "," + user.getPassword() + "," + user.getMoney() + "," + user.getPoint() + "\n");
			}
			
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	// 保存所有商品数据
	public boolean saveGoods() {
		
		try {
			FileWriter fileWriter = new FileWriter(new File(goodsPath));
			
			for (Goods goods : goodsList) {
				fileWriter.write(goods.getId() + "," + goods.getName() + "," + goods.getPrice() + "," + goods.getNums() + "," + goods.getDiscount() + "," + goods.getDetails() + "," +goods.getPath() + "\n");
			}
			
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	// 登录功能
	public String login(String userName, String password) {
		String status = null;
		// 从userList中搜索userName
		for (User user : userList) {
			if (user.getName().equals(userName)) {
				if(user.getPassword().equals(password)) {
					// 登录成功，将此用户设置为正在使用的用户
					this.user = user;
					status = "Success";
				} else {
					status = "PasswordError";
				}
				break;
			} else {
				status = "NotSuchUser";
			}
		}
//		System.out.println(userName);
//		System.out.println(password);
		return status;
	}
	
	// 注册之前的检查数据
	public String checkInfo(String userName, String password) {
		
		// TODO 用户名必须在3-8位之间，密码在8位以上
		String status = null;
		
		if(!userName.equals("") && !password.equals("") ) {
			status = "Success";
		} else {
			status = "NotNull";
		}
		
		
		return status;
	}
	
	// 注册功能
	public String signup(String userName, String password, String password_again) {
		String status = null;
		
		for (User user : userList) {
			if (user.getName().equals(userName)) {
				status = "HasSuchUser";
				break;
			}
		}
		
		if(status == null) {
			if (password.equals(password_again)) {
				User user = new User(userName, password, 0, 0);
				userList.add(user);
				status = "Success";
				// 注册新用户成功，保存数据
				saveUser(); 
			} else {
				status = "PasswordNotSame";
			}
		}
		
		return status;
	}
	

}
