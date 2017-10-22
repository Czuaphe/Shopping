package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.entites.Goods;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class TestFrame extends JFrame implements MouseListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		getContentPane().setForeground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setBackground(Color.BLUE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		getContentPane().add(horizontalGlue);
		
		Goods commodity = new Goods();
		commodity.setId("123");
		commodity.setName("¡„ ≥-–°≥‘");
		commodity.setNums(2);
		commodity.setDiscount(0.8);
		commodity.setPath("./data/pic/goods_2.jpg");
		commodity.setPrice(34.34);
		
		GoodPanel goodPanel = new GoodPanel(commodity, this);
		getContentPane().add(goodPanel);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		getContentPane().add(horizontalGlue_1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
