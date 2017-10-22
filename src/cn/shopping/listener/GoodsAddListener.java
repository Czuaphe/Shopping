package cn.shopping.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.JFrame;

import cn.shopping.entites.Goods;
import cn.shopping.utils.AppData;
import cn.shopping.window.ShopFrame;

public class GoodsAddListener implements MouseListener {
	
	private AppData appData = AppData.getInstance();
	private Goods goods;
	private ShopFrame shopFrame;
	
	public GoodsAddListener(ShopFrame frame, Goods goods) {
		this.goods = goods;
		this.shopFrame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		// 将商品加入购物车
		Map<Goods, Integer> shoppingCart = appData.getShoppingCart();
		if (!shoppingCart.containsKey(goods)) {
			shoppingCart.put(goods, 1);
		} 
		
		// 刷新主页面
		shopFrame.RefreshAllData();

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
