import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import cn.shopping.window.LoginFrame;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		String lookAndFeel ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		UIManager.setLookAndFeel(lookAndFeel);
		
		new LoginFrame().setVisible(true);
	}
}
