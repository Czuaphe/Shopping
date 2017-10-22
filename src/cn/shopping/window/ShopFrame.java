package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.entites.Goods;
import cn.shopping.entites.User;
import cn.shopping.listener.GoodsAddListener;
import cn.shopping.utils.AppData;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ShopFrame extends JFrame implements MouseListener {

	private AppData appData = AppData.getInstance();

	private JPanel AllGoodsPanel = new JPanel(); // 显示所有商品的面板
	private JPanel ShoppingCartPanel = new JPanel(); // 显示购物车的面板
	private JPanel contentPane;
	private JTextField searchKey;
	private JLabel userName = new JLabel();
	private JLabel userMoney = new JLabel();
	private JLabel userPoint = new JLabel();
	private JButton logout_btn = new JButton("\u6CE8\u9500");
	private JButton addMoney_btn = new JButton("\u5145\u503C");
	private JButton buy_btn = new JButton("\u8D2D\u4E70");
	private JButton clear_btn = new JButton("\u6E05\u7A7A");
	private JButton search_btn = new JButton("\u641C\u7D22");
	private JLabel CalcTypeAndNums_lbl = new JLabel(
			"\u603B\u8BA1\uFF1A\u79CD\u7C7B\uFF1A0\uFF0C\u4EF6\u6570\uFF1A0\uFF0C\u603B\u4EF7\uFF1A0");
	private JLabel pic = new JLabel();
	JButton pic_btn = new JButton("\u4E0A\u4F20");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);
					ShopFrame frame = new ShopFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShopFrame() {

		initData();

		setTitle("\u5728\u7EBF\u8D2D\u7269\u5E73\u53F0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(460, 240, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel UserAndShopping = new JPanel();
		UserAndShopping.setMaximumSize(new Dimension(1000, 355));
		UserAndShopping.setBorder(null);
		contentPane.add(UserAndShopping);
		UserAndShopping.setLayout(new BoxLayout(UserAndShopping, BoxLayout.X_AXIS));

		JPanel User = new JPanel();
		User.setBorder(null);
		User.setBackground(Color.BLUE);
		UserAndShopping.add(User);
		User.setLayout(new BoxLayout(User, BoxLayout.Y_AXIS));

		JPanel UserTitle = new JPanel();
		User.add(UserTitle);
		UserTitle.setLayout(new BoxLayout(UserTitle, BoxLayout.X_AXIS));

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		UserTitle.add(horizontalGlue_4);

		JLabel userTitle_lbl = new JLabel("\u7528\u6237\u4FE1\u606F");
		userTitle_lbl.setFont(new Font("微软雅黑", Font.BOLD, 20));
		UserTitle.add(userTitle_lbl);

		Component horizontalGlue_5 = Box.createHorizontalGlue();
		UserTitle.add(horizontalGlue_5);

		JPanel PictrueAndInfo = new JPanel();
		User.add(PictrueAndInfo);
		PictrueAndInfo.setLayout(new BoxLayout(PictrueAndInfo, BoxLayout.X_AXIS));

		JPanel Picture = new JPanel();
		PictrueAndInfo.add(Picture);
		Picture.setLayout(new BoxLayout(Picture, BoxLayout.Y_AXIS));

		JPanel PictrueTitle = new JPanel();
		Picture.add(PictrueTitle);
		PictrueTitle.setLayout(new BoxLayout(PictrueTitle, BoxLayout.X_AXIS));

		JLabel pic_lbl = new JLabel("\u5934\u50CF");
		PictrueTitle.add(pic_lbl);
		pic_lbl.setFont(new Font("微软雅黑", Font.BOLD, 15));

		JPanel PictruePanel = new JPanel();
		PictruePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PictruePanel.setBackground(Color.PINK);
		Picture.add(PictruePanel);

		
		
		PictruePanel.setLayout(new BoxLayout(PictruePanel, BoxLayout.Y_AXIS));
		PictruePanel.add(pic);

		JPanel PictrueButton = new JPanel();
		PictrueButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		Picture.add(PictrueButton);
		PictrueButton.setLayout(new BoxLayout(PictrueButton, BoxLayout.X_AXIS));

		
		PictrueButton.add(pic_btn);

		JPanel UserInfo = new JPanel();
		UserInfo.setBorder(null);
		PictrueAndInfo.add(UserInfo);
		UserInfo.setLayout(new BoxLayout(UserInfo, BoxLayout.Y_AXIS));

		JPanel UserName = new JPanel();
		UserName.setBorder(new EmptyBorder(5, 5, 5, 5));
		UserInfo.add(UserName);
		UserName.setLayout(new BoxLayout(UserName, BoxLayout.X_AXIS));

		JLabel userName_lbl = new JLabel("\u7528\u6237\uFF1A");
		userName_lbl.setFont(new Font("微软雅黑", Font.BOLD, 13));
		UserName.add(userName_lbl);

		userName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		UserName.add(userName);

		Component horizontalGlue_6 = Box.createHorizontalGlue();
		UserName.add(horizontalGlue_6);

		logout_btn.addMouseListener(this);
		UserName.add(logout_btn);

		JPanel UserMoney = new JPanel();
		UserMoney.setBorder(new EmptyBorder(5, 5, 5, 5));
		UserInfo.add(UserMoney);
		UserMoney.setLayout(new BoxLayout(UserMoney, BoxLayout.X_AXIS));

		JLabel userMoney_lbl = new JLabel("\u4F59\u989D\uFF1A");
		userMoney_lbl.setFont(new Font("微软雅黑", Font.BOLD, 13));
		UserMoney.add(userMoney_lbl);

		userMoney.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		UserMoney.add(userMoney);

		Component horizontalGlue_7 = Box.createHorizontalGlue();
		UserMoney.add(horizontalGlue_7);

		addMoney_btn.addMouseListener(this);
		UserMoney.add(addMoney_btn);

		JPanel UserPoint = new JPanel();
		UserPoint.setBorder(new EmptyBorder(5, 5, 5, 5));
		UserInfo.add(UserPoint);
		UserPoint.setLayout(new BoxLayout(UserPoint, BoxLayout.X_AXIS));

		JLabel userPoint_lbl = new JLabel("\u79EF\u5206\uFF1A");
		userPoint_lbl.setFont(new Font("微软雅黑", Font.BOLD, 13));
		UserPoint.add(userPoint_lbl);

		userPoint.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		UserPoint.add(userPoint);

		Component horizontalGlue_8 = Box.createHorizontalGlue();
		UserPoint.add(horizontalGlue_8);

		JPanel Record = new JPanel();
		User.add(Record);
		Record.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u8D2D\u7269\u8BB0\u5F55");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
		Record.add(lblNewLabel);

		// DefaultTableModel defaultTableModel = new DefaultTableModel();
		// defaultTableModel.addColumn("日期");
		// defaultTableModel.addColumn("金额");
		// defaultTableModel.addColumn("详细");
		// JButton button = new JButton("详细");
		// defaultTableModel.addRow(new Object[] {"2017-10-15", "1300", button});
		// table = new JTable(defaultTableModel);
		// panel_15.add(table);

		JPanel Shopping = new JPanel();
		Shopping.setMaximumSize(new Dimension(800, 355));
		UserAndShopping.add(Shopping);
		Shopping.setLayout(new BoxLayout(Shopping, BoxLayout.Y_AXIS));

		JPanel Search = new JPanel();
		Search.setBorder(new EmptyBorder(0, 0, 5, 0));
		Search.setMinimumSize(new Dimension(800, 40));
		Shopping.add(Search);
		Search.setLayout(new BoxLayout(Search, BoxLayout.X_AXIS));

		Component horizontalGlue = Box.createHorizontalGlue();
		Search.add(horizontalGlue);

		JLabel searchTitle_lbl = new JLabel("\u5546\u54C1\u9009\u62E9");
		searchTitle_lbl.setFont(new Font("微软雅黑", Font.BOLD, 18));
		Search.add(searchTitle_lbl);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		Search.add(horizontalGlue_1);

		searchKey = new JTextField();
		searchKey.setMaximumSize(new Dimension(200, 21));
		searchKey.setMinimumSize(new Dimension(200, 21));
		Search.add(searchKey);
		searchKey.setColumns(20);

		search_btn.addMouseListener(this);
		Search.add(search_btn);

		JScrollPane AllGoodsScroll = new JScrollPane();
		AllGoodsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Shopping.add(AllGoodsScroll);
		// AllGoodsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		AllGoodsScroll.setMaximumSize(new Dimension(800, 300));
		AllGoodsScroll.setMinimumSize(new Dimension(800, 300));
		AllGoodsScroll.setViewportBorder(null);

		Goods commodity = new Goods();
		commodity.setId("123");
		commodity.setName("零食-小吃");
		commodity.setNums(2);
		commodity.setPath("./src/p3.png");
		commodity.setPrice(34.34);

		AllGoodsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		AllGoodsPanel.setMinimumSize(new Dimension(800, 300));
		AllGoodsScroll.setViewportView(AllGoodsPanel);
		AllGoodsPanel.setLayout(new GridLayout(0, 3, 5, 5));

		// if (goodPanelList != null) {
		// for (GoodPanel goodPanel : goodPanelList) {
		// AllGoodsPanel.add(goodPanel);
		// }
		// }

		JPanel ShoppingCart = new JPanel();
		contentPane.add(ShoppingCart);
		ShoppingCart.setLayout(new BoxLayout(ShoppingCart, BoxLayout.Y_AXIS));

		JPanel Details = new JPanel();
		Details.setBorder(new EmptyBorder(5, 0, 5, 0));
		Details.setMaximumSize(new Dimension(1000, 50));
		ShoppingCart.add(Details);
		Details.setLayout(new BoxLayout(Details, BoxLayout.X_AXIS));

		CalcTypeAndNums_lbl.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		Details.add(CalcTypeAndNums_lbl);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		Details.add(horizontalStrut);

		Details.add(buy_btn);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		Details.add(horizontalStrut_1);

		Details.add(clear_btn);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		Details.add(horizontalGlue_3);

		JLabel shoppingCartTitle_lbl = new JLabel("\u8D2D\u7269\u8F66");
		shoppingCartTitle_lbl.setFont(new Font("微软雅黑", Font.BOLD, 20));
		Details.add(shoppingCartTitle_lbl);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		Details.add(horizontalGlue_2);

		JScrollPane ShoppingCartScroll = new JScrollPane(); // 购物车的滑动面板
		ShoppingCart.add(ShoppingCartScroll);
		ShoppingCartScroll.setMinimumSize(new Dimension(1000, 175));
		ShoppingCartScroll.setMaximumSize(new Dimension(1000, 175));
		ShoppingCartScroll.setViewportView(ShoppingCartPanel);

		ShoppingCartPanel.setBorder(null);
		ShoppingCartPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		// ShoppingCartScroll.removeAll();

	}

	private void initData() {

		initUser();
		initAllGoods();
		initShoppingCart();
	}

	private void initUser() {
		// 加载用户信息
		userName.setText(appData.getUser().getName());
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		userMoney.setText(String.valueOf(decimalFormat.format(appData.getUser().getMoney())));
		userPoint.setText(String.valueOf(appData.getUser().getPoint()));
		// 加载用户头像
		pic.setAlignmentX(Component.CENTER_ALIGNMENT);
		String defaultPath = "./data/pic/default.png";
		String picPath = "./data/pic/" + appData.getUser().getName() + ".png";
		ImageIcon icon;
		if (new File(picPath).exists()) {
			icon = new ImageIcon(picPath);
		} else {
			icon = new ImageIcon(defaultPath);
		}
		
		icon.setImage(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		pic.setIcon(icon);
		
	}

	private void initAllGoods() {
		// 加载商品信息
		List<Goods> goodsList = appData.getGoodsList();
		AllGoodsPanel.removeAll();
		if (goodsList != null) {
			for (Goods goods : goodsList) {
				AllGoodsPanel.add(new GoodPanel(goods, new GoodsAddListener(this, goods)));
			}
		}
	}

	private void initShoppingCart() {

		// 刷新两个按钮
		buy_btn.setText("购买");
		if (appData.getShoppingCart().isEmpty()) {
			buy_btn.setForeground(Color.GRAY);
			buy_btn.setEnabled(false);
			clear_btn.setEnabled(false);
		} else {
			buy_btn.setForeground(Color.BLACK);
			buy_btn.setEnabled(true);
			buy_btn.addMouseListener(this);
			clear_btn.setEnabled(true);
			clear_btn.addMouseListener(this);
		}

		// 刷新购物车信息
		Map<Goods, Integer> shoppingCart = appData.getShoppingCart();
		// System.out.println("购物车刷新");
		Set<Goods> goodsSet = shoppingCart.keySet();
		ShoppingCartPanel.removeAll();
		for (Goods goods : goodsSet) {
			int num = shoppingCart.get(goods);
			// System.out.println(goods.getName());
			// System.out.println(num);
			ShoppingCartPanel.add(new BuyPanel(goods, num, this));
		}

		// 刷新件数和总数
		int typeNum = goodsSet.size();
		int sumNum = 0;
		double sumPrice = 0;
		if (typeNum > 0) {
			for (Goods goods : goodsSet) {
				sumNum += shoppingCart.get(goods);
				sumPrice += goods.getPrice() * goods.getDiscount() * shoppingCart.get(goods);
			}
		}
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		CalcTypeAndNums_lbl.setText("总计：种类：" + typeNum + "，件数：" + sumNum + "，总价：" + decimalFormat.format(sumPrice));

	}

	private void initSearchGoods() {
		// 加载商品信息
		List<Goods> goodsList = appData.getGoodsList();
		String key = searchKey.getText();
		AllGoodsPanel.removeAll();
		if (goodsList != null) {
			for (Goods goods : goodsList) {
				if (goods.getName().contains(key)) {
					AllGoodsPanel.add(new GoodPanel(goods, new GoodsAddListener(this, goods)));
				}
			}
		}
	}

	public void RefreshAllData() {
		this.invalidate();

		initUser();
		if (searchKey.getText().equals("")) {
			initAllGoods();
		} else {
			initSearchGoods();
		}

		initShoppingCart();

		this.validate();

	}

	public void RefreshSearchGoods() {
		this.invalidate();
		
		initSearchGoods();
		
		this.validate();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// 搜索功能
		if (e.getSource() == search_btn) {

			if (searchKey.getText().equals("")) {
				RefreshAllData();
			} else {
				RefreshSearchGoods();
			}

		}

		// 注销功能
		if (e.getSource() == logout_btn) {
			// 保存所有数据
			appData.saveUser();
			appData.saveGoods();
			this.dispose();
			// 返回登录界面
			new LoginFrame().setVisible(true);

			return;
		}
		// 充值功能
		if (e.getSource() == addMoney_btn) {

			AddMoneyDialog dialog = new AddMoneyDialog(this);
			dialog.setModal(true);
			dialog.setVisible(true);

			this.RefreshAllData();

			// 保存所有数据
			appData.saveUser();
			appData.saveGoods();
			return;
		}
		// 清空购物车
		if (e.getSource() == clear_btn) {

			Map<Goods, Integer> shoppingCart = appData.getShoppingCart();

			shoppingCart.clear();
			// 刷新整个界面
			this.RefreshAllData();

			return;

		}
		// 结算功能
		if (e.getSource() == buy_btn) {
			// // 需要Dialog
			// BuyDialog buyDialog = new BuyDialog(this);
			// buyDialog.setModal(true);
			// buyDialog.setVisible(true);

			Map<Goods, Integer> shoppingCart = appData.getShoppingCart();
			List<Goods> goodsList = appData.getGoodsList();
			Set<Goods> goodsSet = shoppingCart.keySet();
			double sumPrice = 0;
			for (Goods buyGoods : goodsSet) {
				sumPrice += (buyGoods.getPrice() * buyGoods.getDiscount() * shoppingCart.get(buyGoods));
			}

			User user = appData.getUser();

			if (user.getMoney() < sumPrice) {
				buy_btn.setForeground(Color.red);
				buy_btn.setText("钱不够");

			} else {
				// 改变商品的件数
				for (Goods buyGoods : goodsSet) {
					for (Goods goods : goodsList) {
						if (buyGoods == goods) {
							int nums = goods.getNums();
							goods.setNums(nums - shoppingCart.get(buyGoods));
						}
					}
				}
				// 改变用户钱数
				user.setMoney(user.getMoney() - sumPrice);
				user.setPoint(user.getPoint() + (int) (sumPrice / 10));
				// 清空购物车
				shoppingCart.clear();

				// this.dispose();
				// 刷新主页面的数据
				this.RefreshAllData();

				// 保存所有数据
				appData.saveUser();
				appData.saveGoods();
			}
			return;

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
