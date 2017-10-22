package cn.shopping.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.entites.Goods;
import cn.shopping.utils.AppData;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class GoodPanel extends JPanel{
	
	private AppData appData = AppData.getInstance();
	
	private JPanel Pictrue = new JPanel();
	private JPanel NameAndPrice = new JPanel();
	private JPanel NumAndButton = new JPanel();
	private Goods goods;
	
	/**
	 * Create the panel.
	 */
	public GoodPanel(Goods goods, MouseListener mouseListener) {
		
		this.goods = goods;
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBackground(Color.YELLOW);
		this.setSize(220, 320);
		this.setMaximumSize(new Dimension(220,  300));
		this.setMinimumSize(new Dimension(220, 300));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		Pictrue.setBorder(new EmptyBorder(5, 5, 5, 5));
		Pictrue.setMinimumSize(new Dimension(210, 210));
		this.add(Pictrue);
		Pictrue.setLayout(new BoxLayout(Pictrue, BoxLayout.X_AXIS));
		
		JLabel pic = new JLabel();
		Pictrue.add(pic);
		pic.setOpaque(true);
		pic.setBackground(Color.PINK);
		
		ImageIcon icon = new ImageIcon(goods.getPath());
		icon.setImage(icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		
		pic.setIcon(icon);
		pic.setMinimumSize(new Dimension(200, 100));
		
		
		
		NameAndPrice.setBorder(new EmptyBorder(0, 0, 5, 0));
		
		NameAndPrice.setMaximumSize(new Dimension(210, 40));
		NameAndPrice.setMinimumSize(new Dimension(210, 40));
		this.add(NameAndPrice);
		NameAndPrice.setLayout(new BoxLayout(NameAndPrice, BoxLayout.X_AXIS));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		NameAndPrice.add(horizontalStrut_1);
		
		JLabel name_lbl = new JLabel("<html>" + goods.getName() +"</html>");
		name_lbl.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 12));
		NameAndPrice.add(name_lbl);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		NameAndPrice.add(horizontalGlue);
		
		JPanel Price = new JPanel();
		NameAndPrice.add(Price);
		Price.setBounds(50, 50, 300, 50);
//		Price.setMaximumSize(new Dimension(200, 35));
//		Price.setMinimumSize(new Dimension(200, 30));
		Price.setLayout(new BoxLayout(Price, BoxLayout.X_AXIS));
		
		if (goods.getDiscount() < 1) {
			
			
			// PricePanel start
			JPanel PricePanel = new JPanel();
			Price.add(PricePanel);
			PricePanel.setLayout(new BoxLayout(PricePanel, BoxLayout.Y_AXIS));
			
			Component verticalGlue_2 = Box.createVerticalGlue();
			PricePanel.add(verticalGlue_2);
			
			JPanel TotalPrice = new JPanel();
			TotalPrice.setBorder(new EmptyBorder(0, 0, 3, 0));
//			panel_2.setMinimumSize(new Dimension(100, 30));
			PricePanel.add(TotalPrice);
			TotalPrice.setLayout(new BoxLayout(TotalPrice, BoxLayout.X_AXIS));
			
			

			DelelteLineCanvas delelteLineCanvas = new DelelteLineCanvas(goods.getPrice());
			delelteLineCanvas.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
			delelteLineCanvas.setPreferredSize(new Dimension(50, 10));
			TotalPrice.add(delelteLineCanvas);
			
			JPanel Discount = new JPanel();
			PricePanel.add(Discount);
			Discount.setLayout(new BoxLayout(Discount, BoxLayout.X_AXIS));
			
			JLabel discount = new JLabel("   " + (goods.getDiscount() * 10) + "\u6298    ");
			discount.setForeground(Color.BLUE);
			discount.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 11));
			Discount.add(discount);
			
			Component verticalGlue_3 = Box.createVerticalGlue();
			PricePanel.add(verticalGlue_3);
			
			// PricePanel end
			
		}
		
		
		
		JPanel TruePricePanel = new JPanel();
		Price.add(TruePricePanel);
		TruePricePanel.setLayout(new BoxLayout(TruePricePanel, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		TruePricePanel.add(verticalGlue);
		
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		JLabel price_lbl = new JLabel("£¤" + decimalFormat.format(goods.getPrice() * goods.getDiscount()));
		TruePricePanel.add(price_lbl);
		price_lbl.setForeground(Color.RED);
		price_lbl.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		TruePricePanel.add(verticalGlue_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		NameAndPrice.add(horizontalStrut);
		
		
		NumAndButton.setBorder(new EmptyBorder(0, 0, 5, 0));
		
		NumAndButton.setMaximumSize(new Dimension(210, 40));
		this.add(NumAndButton);
		NumAndButton.setLayout(new BoxLayout(NumAndButton, BoxLayout.X_AXIS));
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		NumAndButton.add(horizontalGlue_6);
		
		JLabel nums_lbl = new JLabel(goods.getNums() > 3 ? goods.getNums() + "¼þ" : (goods.getNums() == 0 ? "ÒÑÊÛóÀ" : "½öÊ£" + goods.getNums() + "¼þ"));
		nums_lbl.setForeground( goods.getNums() > 3 ? Color.BLUE : Color.RED);
		nums_lbl.setFont(new Font("Î¢ÈíÑÅºÚ", goods.getNums() > 3 ? Font.PLAIN : Font.BOLD, 16));
		NumAndButton.add(nums_lbl);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		NumAndButton.add(horizontalGlue_5);
		
		JButton addCart_btn = new JButton("\u52A0\u5165\u8D2D\u7269\u8F66");
		addCart_btn.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		if (goods.getNums() == 0) {
			addCart_btn.setEnabled(false);
			addCart_btn.setText("µÈ´ý½ø»õÖÐ...");
		} else {
			if (appData.getShoppingCart().containsKey(goods)) {
				addCart_btn.setEnabled(false);
				addCart_btn.setText("ÒÑ¼ÓÈë");
			} else {
				addCart_btn.addMouseListener(mouseListener);
			}
		}
		
		
		
		NumAndButton.add(addCart_btn);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(10);
		NumAndButton.add(horizontalStrut_3);
		
	}

}
