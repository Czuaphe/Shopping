package cn.shopping.window;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.text.DecimalFormat;

public class DelelteLineCanvas extends Canvas {
	
	private double price;
	
	public DelelteLineCanvas(double price) {
		this.price= price;
	}
	
	public void paint(Graphics g) {
//		AttributedString attributedString = new AttributedString("£¤40.00");
//		attributedString.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
//		
		((Graphics2D) g).setStroke(new BasicStroke(2.0f)); 
		g.setColor(Color.BLACK);
		g.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		g.drawString("£¤" + decimalFormat.format(this.price), 0, 10);
		g.setColor(Color.RED);
		int endPointX = 0;
		if (price > 100) {
			endPointX = 50;
		} else if (price > 10) {
			endPointX = 45;
		} else {
			endPointX = 40;
		}
		g.drawLine(0, 5, endPointX, 5);
	}

}
