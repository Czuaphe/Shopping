import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cn.shopping.window.LoginFrame;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// 设置应用风格为Windows风格
		String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		UIManager.setLookAndFeel(lookAndFeel);
		// 启动登录页面
		new LoginFrame().setVisible(true);
	}
}
