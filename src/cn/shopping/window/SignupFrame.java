package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.utils.AppData;

import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;

public class SignupFrame extends JFrame implements MouseListener{

	private AppData appData = AppData.getInstance();
	
	private JPanel contentPane;
	private JLabel signupError = new JLabel("");
	private JTextField userName;
	private JPasswordField password;
	private JPasswordField passwordAgain;
	private JButton signup_btn = new JButton("\u6CE8\u518C");
	private JButton clear_btn = new JButton("\u6E05\u7A7A");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					UIManager.setLookAndFeel(lookAndFeel);
					SignupFrame frame = new SignupFrame();
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
	public SignupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(660, 340, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		Component verticalGlue = Box.createVerticalGlue();
		contentPane.add(verticalGlue);
		
		JPanel Signup = new JPanel();
		contentPane.add(Signup);
		Signup.setLayout(new BoxLayout(Signup, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		Signup.add(horizontalGlue);
		
		JPanel SignupPanel = new JPanel();
		Signup.add(SignupPanel);
		SignupPanel.setLayout(new BoxLayout(SignupPanel, BoxLayout.Y_AXIS));
		
		JPanel SignupTitle = new JPanel();
		SignupTitle.setBorder(new EmptyBorder(0, 0, 20, 0));
		SignupPanel.add(SignupTitle);
		SignupTitle.setLayout(new BoxLayout(SignupTitle, BoxLayout.X_AXIS));
		
		JLabel signupTitle = new JLabel("\u6CE8\u518C\u7528\u6237");
		signupTitle.setFont(new Font("΢���ź�", Font.BOLD, 20));
		SignupTitle.add(signupTitle);
		
		JPanel SignupError = new JPanel();
		SignupError.setBorder(new EmptyBorder(0, 0, 5, 0));
		SignupPanel.add(SignupError);
		SignupError.setLayout(new BoxLayout(SignupError, BoxLayout.X_AXIS));
		
		signupError.setFont(new Font("΢���ź�", Font.BOLD, 12));
		signupError.setForeground(Color.RED);
		SignupError.add(signupError);
		
		JPanel SignupInput = new JPanel();
		SignupInput.setBorder(null);
		SignupPanel.add(SignupInput);
		SignupInput.setLayout(new BoxLayout(SignupInput, BoxLayout.Y_AXIS));
		
		JPanel UserNamePanel = new JPanel();
		UserNamePanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		UserNamePanel.setMaximumSize(new Dimension(250, 40));
		SignupInput.add(UserNamePanel);
		UserNamePanel.setLayout(new BoxLayout(UserNamePanel, BoxLayout.X_AXIS));
		
		JLabel userName_lbl = new JLabel("\u7528\u6237\u540D\uFF1A   ");
		userName_lbl.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		UserNamePanel.add(userName_lbl);
		
		userName = new JTextField();
		UserNamePanel.add(userName);
		userName.setColumns(30);
		
		JPanel PasswordPanel = new JPanel();
		PasswordPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		PasswordPanel.setMaximumSize(new Dimension(250, 40));
		SignupInput.add(PasswordPanel);
		PasswordPanel.setLayout(new BoxLayout(PasswordPanel, BoxLayout.X_AXIS));
		
		JLabel password_lbl = new JLabel("\u5BC6\u7801\uFF1A      ");
		password_lbl.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		PasswordPanel.add(password_lbl);
		
		password = new JPasswordField();
		PasswordPanel.add(password);
		
		JPanel PasswordAgainPanel = new JPanel();
		PasswordAgainPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		PasswordAgainPanel.setMaximumSize(new Dimension(250, 40));
		
		SignupInput.add(PasswordAgainPanel);
		PasswordAgainPanel.setLayout(new BoxLayout(PasswordAgainPanel, BoxLayout.X_AXIS));
		
		JLabel passwordAgain_lbl = new JLabel("\u91CD\u590D\u5BC6\u7801\uFF1A");
		passwordAgain_lbl.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		PasswordAgainPanel.add(passwordAgain_lbl);
		
		passwordAgain = new JPasswordField();
		PasswordAgainPanel.add(passwordAgain);
		
		JPanel SignupButton = new JPanel();
		SignupButton.setMaximumSize(new Dimension(240, 50));
		SignupPanel.add(SignupButton);
		SignupButton.setLayout(new BoxLayout(SignupButton, BoxLayout.X_AXIS));
		
		
		clear_btn.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		clear_btn.addMouseListener(this);
		SignupButton.add(clear_btn);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		SignupButton.add(horizontalGlue_2);
		
		
		signup_btn.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		signup_btn.addMouseListener(this);
		SignupButton.add(signup_btn);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		Signup.add(horizontalGlue_1);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		contentPane.add(verticalGlue_1);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// ��հ�ťʵ��
		if (e.getSource() == clear_btn) {
			userName.setText("");
			password.setText("");
			passwordAgain.setText("");
		}
		// ע�ᰴť����ʵ��
		if (e.getSource() == signup_btn) {
			// ע����Ϣ��ʽ���
			String statusInfo = appData.checkInfo(userName.getText(), password.getText());
			if (statusInfo.equals("Success")) {
				// ע����Ϣƥ����
				String status = appData.signup(userName.getText(), password.getText(), passwordAgain.getText());
				if (status.equals("Success")) {
					// ע��ɹ�����ת����¼ҳ��
					this.dispose();
					new LoginFrame().setVisible(true);
				} else {
					// ע���û�ʧ�ܣ����ݲ�ͬ�Ĵ���״̬���������Ϣ
					switch (status) {
					case "HasSuchUser":
						signupError.setText("���û��ѱ�ע�ᣡ");
						break;
					case "PasswordNotSame":
						signupError.setText("�������벻һ�£�");
						break;
					default:
						signupError.setText("δ֪ԭ��ע��ʧ�ܣ�");
						break;
					}
				}
				
			} else {
				// ע����Ϣ��ʽ�������������Ϣ
				
				switch (statusInfo) {
				case "NotNull":
					signupError.setText("ע����Ϣ����Ϊ�գ�");
					break;

				default:
					break;
				}
				
				
			}
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
