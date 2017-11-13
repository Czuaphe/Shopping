package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.utils.AppData;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import java.awt.Color;

public class LoginFrame extends JFrame  implements MouseListener{

	private AppData appData = AppData.getInstance();
	
	private JPanel contentPane;
	private JPanel LoginTitle;
	private JPanel UserName;
	private JPanel Password;
	private JPanel ButtonPanel;
	private JLabel loginTitle;
	private JLabel password_lbl;
	private JButton signup_btn;
	private JButton login_btn;
	private Component verticalGlue;
	private Component verticalGlue_1;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component horizontalGlue_2;
	private Component horizontalGlue_3;
	private JPanel PasswordPanel;
	private JPanel UserNamePanel;
	private Component horizontalGlue_4;
	private Component horizontalGlue_5;
	private JLabel userName_lbl;
	private JTextField userName;
	private Component horizontalStrut;
	private JPanel LoginAndSignupButton;
	private JPanel ErrorInfo;
	private JLabel errorInfo;
	private JPasswordField password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(735, 390, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		verticalGlue = Box.createVerticalGlue();
		contentPane.add(verticalGlue);
		
		LoginTitle = new JPanel();
		LoginTitle.setBorder(new EmptyBorder(0, 0, 20, 0));
		contentPane.add(LoginTitle);
		LoginTitle.setLayout(new BoxLayout(LoginTitle, BoxLayout.X_AXIS));
		
		loginTitle = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u4E2D\u5317\u8D2D\u7269\u7CFB\u7EDF");
		loginTitle.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		LoginTitle.add(loginTitle);
		
		ErrorInfo = new JPanel();
		ErrorInfo.setBorder(new EmptyBorder(0, 0, 10, 0));
		contentPane.add(ErrorInfo);
		ErrorInfo.setLayout(new BoxLayout(ErrorInfo, BoxLayout.X_AXIS));
		
		errorInfo = new JLabel("");
		errorInfo.setFont(new Font("微软雅黑", Font.BOLD, 12));
		errorInfo.setForeground(Color.RED);
		ErrorInfo.add(errorInfo);
		
		UserName = new JPanel();
		UserName.setBorder(new EmptyBorder(0, 0, 20, 0));
		contentPane.add(UserName);
		UserName.setLayout(new BoxLayout(UserName, BoxLayout.X_AXIS));
		
		horizontalGlue_4 = Box.createHorizontalGlue();
		UserName.add(horizontalGlue_4);
		
		UserNamePanel = new JPanel();
		UserNamePanel.setMaximumSize(new Dimension(200, 30));
		UserName.add(UserNamePanel);
		UserNamePanel.setLayout(new BoxLayout(UserNamePanel, BoxLayout.X_AXIS));
		
		userName_lbl = new JLabel("\u7528\u6237\u540D\uFF1A");
		userName_lbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		UserNamePanel.add(userName_lbl);
		
		userName = new JTextField();
		UserNamePanel.add(userName);
		userName.setColumns(25);
		
		horizontalGlue_5 = Box.createHorizontalGlue();
		UserName.add(horizontalGlue_5);
		
		Password = new JPanel();
		Password.setBorder(new EmptyBorder(0, 0, 20, 0));
		contentPane.add(Password);
		Password.setLayout(new BoxLayout(Password, BoxLayout.X_AXIS));
		
		horizontalGlue_2 = Box.createHorizontalGlue();
		Password.add(horizontalGlue_2);
		
		PasswordPanel = new JPanel();
		PasswordPanel.setMaximumSize(new Dimension(300, 20));
		Password.add(PasswordPanel);
		PasswordPanel.setLayout(new BoxLayout(PasswordPanel, BoxLayout.X_AXIS));
		
		password_lbl = new JLabel("\u5BC6\u7801\uFF1A   ");
		password_lbl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		PasswordPanel.add(password_lbl);
		
		password = new JPasswordField();
		password.setColumns(25);
		PasswordPanel.add(password);
		
		horizontalGlue_3 = Box.createHorizontalGlue();
		Password.add(horizontalGlue_3);
		
		LoginAndSignupButton = new JPanel();
		contentPane.add(LoginAndSignupButton);
		LoginAndSignupButton.setLayout(new BoxLayout(LoginAndSignupButton, BoxLayout.X_AXIS));
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		LoginAndSignupButton.add(horizontalGlue_1);
		
		ButtonPanel = new JPanel();
		LoginAndSignupButton.add(ButtonPanel);
		ButtonPanel.setMaximumSize(new Dimension(200, 30));
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));
		
		signup_btn = new JButton("\u6CE8\u518C");
		signup_btn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		signup_btn.addMouseListener(this);
		ButtonPanel.add(signup_btn);
		
		horizontalStrut = Box.createHorizontalStrut(90);
		ButtonPanel.add(horizontalStrut);
		
		login_btn = new JButton("\u767B\u5F55");
		login_btn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		login_btn.addMouseListener(this);
		ButtonPanel.add(login_btn);
		
		horizontalGlue = Box.createHorizontalGlue();
		LoginAndSignupButton.add(horizontalGlue);
		
		verticalGlue_1 = Box.createVerticalGlue();
		contentPane.add(verticalGlue_1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("clicked");
		// 登录功能
		if(e.getSource() == login_btn) {
			String status = appData.login(userName.getText(), password.getText());
			// 对状态信息进行显示
			if (status.equals("Success")) {
				this.dispose();
				new ShopFrame().setVisible(true);
			} else {
				// 设置错误信息
				String message = null;
				switch (status) {
				case "NotSuchUser":
					message = "没有这样的用户！";
					break;
				case "PasswordError":
					message = "密码错误！";
					break;
				default:
					message = "未知错误！";
					break;
				}
				errorInfo.setText(message);
				// 将用户名和密码都清空
				userName.setText("");
				password.setText("");
			}
		}
		if (e.getSource() == signup_btn) {
			this.dispose();
			new SignupFrame().setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
