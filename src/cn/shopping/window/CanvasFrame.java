package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CanvasFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanvasFrame frame = new CanvasFrame();
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
	public CanvasFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		LineCanvas lineCanvas = new LineCanvas();
		lineCanvas.setPreferredSize(new Dimension(200, 200));
		lineCanvas.setBackground(null);                     
		contentPane.add(lineCanvas);
		setContentPane(contentPane);
	}
	
	class LineCanvas extends Canvas {
		public void paint(Graphics g) {
			
//			AttributedString attributedString = new AttributedString("гд40");
//			attributedString.addAttribute(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
////			attributedString.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//			g.drawString(attributedString.getIterator(), 0, 100);
			g.setColor(Color.RED);
			g.drawString("гд40", 0, 100);
			
			g.setColor(Color.BLACK);
			g.drawLine(0, 95, 200, 95);
		}
	}
	

}
