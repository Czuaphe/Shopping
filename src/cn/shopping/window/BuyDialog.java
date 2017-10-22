package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.entites.Goods;
import cn.shopping.entites.User;
import cn.shopping.utils.AppData;

import javax.swing.JLabel;

public class BuyDialog extends JDialog implements MouseListener{

	private final JPanel contentPanel = new JPanel();
	private AppData appData = AppData.getInstance();
	private ShopFrame shopFrame;
	
	private JLabel label = new JLabel();
	private JButton okButton = new JButton("\u8D2D\u4E70");
	private JButton cancelButton = new JButton("\u518D\u60F3\u60F3");
	

	/**
	 * Create the dialog.
	 */
	public BuyDialog(ShopFrame shopFrame) {
		
		this.shopFrame = shopFrame;
		
		setBounds(100, 100, 333, 124);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			Map<Goods, Integer> shoppingCart = appData.getShoppingCart();
			Set<Goods> goodsSet = shoppingCart.keySet();
			double sumPrice = 0;
			for (Goods goods : goodsSet) {
				sumPrice += (goods.getPrice() * goods.getDiscount() * shoppingCart.get(goods));
			}
			
			
			label.setText("确定支付：" + sumPrice + "元！");
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				okButton.setActionCommand("OK");
				okButton.addMouseListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				
				cancelButton.setActionCommand("Cancel");
				cancelButton.addMouseListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == okButton) {
			Map<Goods, Integer> shoppingCart = appData.getShoppingCart();
			List<Goods> goodsList = appData.getGoodsList();
			Set<Goods> goodsSet = shoppingCart.keySet();
			double sumPrice = 0;
			for (Goods buyGoods : goodsSet) {
				sumPrice += (buyGoods.getPrice() * buyGoods.getDiscount() * shoppingCart.get(buyGoods));
			}
			
			User user = appData.getUser();
			
			if (user.getMoney() < sumPrice) {
				label.setForeground(Color.red);
				label.setText("钱不够");
				
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
				// 清空购物车
				shoppingCart.clear();
				
				this.dispose();
				// 刷新主页面的数据
				shopFrame.RefreshAllData();
				
			}
			
		}
		
		if (e.getSource() == cancelButton) {
			this.dispose();
//			shopFrame.RefreshAllData();
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
