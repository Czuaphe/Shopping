package cn.shopping.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cn.shopping.entites.Goods;
import cn.shopping.utils.AppData;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class BuyPanel extends JPanel implements MouseListener, ChangeListener{
	
	private AppData appData = AppData.getInstance();
	private Map<Goods, Integer> shoppingCart = appData.getShoppingCart();
	
	private Goods goods;
	private JLabel buyTitle_lbl;
	private ShopFrame shopFrame;
	private JButton delete_btn = new JButton("\u5220\u9664");
	private SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
	private JSpinner nums = new JSpinner();

	/**
	 * Create the panel.
	 */
	public BuyPanel(Goods goods, int num, ShopFrame shopFrame) {
		
		this.goods = goods;
		this.shopFrame = shopFrame;
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(Color.YELLOW);
		this.setSize(150, 120);
		this.setMaximumSize(new Dimension(200, 145));
//		this.setMinimumSize(new Dimension(120, 120));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel BuyTitle = new JPanel();
		BuyTitle.setBorder(new EmptyBorder(5, 0, 0, 0));
		add(BuyTitle);
		BuyTitle.setLayout(new BoxLayout(BuyTitle, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		BuyTitle.add(horizontalGlue);
		
		buyTitle_lbl = new JLabel(goods.getName());
		BuyTitle.add(buyTitle_lbl);
		buyTitle_lbl.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		BuyTitle.add(horizontalGlue_1);
		
		JPanel PictrueAndOthers = new JPanel();
		add(PictrueAndOthers);
		PictrueAndOthers.setLayout(new BoxLayout(PictrueAndOthers, BoxLayout.X_AXIS));
		
		JPanel Pictrue = new JPanel();
		PictrueAndOthers.add(Pictrue);
		Pictrue.setBorder(new EmptyBorder(5, 5, 5, 5));
		Pictrue.setMinimumSize(new Dimension(110, 110));
		Pictrue.setLayout(new BoxLayout(Pictrue, BoxLayout.X_AXIS));
		
		JLabel pic = new JLabel();
		Pictrue.add(pic);
		pic.setOpaque(true);
		pic.setBackground(Color.PINK);
		ImageIcon icon = new ImageIcon(goods.getPath());
		icon.setImage(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		pic.setIcon(icon);
		pic.setMinimumSize(new Dimension(200, 100));
		
		JPanel PriceAndNums = new JPanel();
		PriceAndNums.setBorder(new EmptyBorder(0, 0, 0, 5));
		PictrueAndOthers.add(PriceAndNums);
		PriceAndNums.setLayout(new BoxLayout(PriceAndNums, BoxLayout.Y_AXIS));
		
		JPanel Price = new JPanel();
		Price.setBorder(new EmptyBorder(0, 0, 0, 0));
		PriceAndNums.add(Price);
		Price.setLayout(new BoxLayout(Price, BoxLayout.X_AXIS));
		
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		JLabel price_lbl = new JLabel("£¤" + decimalFormat.format((goods.getPrice() * goods.getDiscount())));
		price_lbl.setForeground(Color.RED);
		price_lbl.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		Price.add(price_lbl);
		
		JPanel Nums = new JPanel();
		Nums.setBorder(new EmptyBorder(5, 0, 5, 0));
		PriceAndNums.add(Nums);
		Nums.setLayout(new BoxLayout(Nums, BoxLayout.X_AXIS));
		
		
		spinnerNumberModel.setValue(shoppingCart.get(goods).intValue());
		spinnerNumberModel.setStepSize(1);
		spinnerNumberModel.setMaximum(goods.getNums());
		spinnerNumberModel.setMinimum(1);
		nums.setModel(spinnerNumberModel);
		nums.addChangeListener(this);
		Nums.add(nums);
		nums.setMaximumSize(new Dimension(70, 20));
		nums.setMinimumSize(new Dimension(70, 20));
		
		JPanel DeleteButton = new JPanel();
		DeleteButton.setBorder(new EmptyBorder(5, 0, 0, 0));
		PriceAndNums.add(DeleteButton);
		DeleteButton.setLayout(new BoxLayout(DeleteButton, BoxLayout.X_AXIS));
		
		
		delete_btn.setMaximumSize(new Dimension(70, 30));
		delete_btn.addMouseListener(this);
		DeleteButton.add(delete_btn);
		
		
		
		


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == delete_btn) {
			
			shoppingCart.remove(goods);
			
			shopFrame.RefreshAllData();
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

	@Override
	public void stateChanged(ChangeEvent e) {
		int num = (int) spinnerNumberModel.getValue();
//		System.out.println(num);
		// ¸üÐÂÊý¾Ý
		shoppingCart.put(goods, num);
		
		shopFrame.RefreshAllData();
		
	}

}
