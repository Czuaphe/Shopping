package cn.shopping.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.shopping.entites.User;
import cn.shopping.utils.AppData;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SpinnerNumberModel;

public class AddMoneyDialog extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(100, 1, 10000, 1);
	private ShopFrame shopFrame;

	private JButton okButton = new JButton("\u786E\u5B9A");
	private JButton cancelButton = new JButton("\u53D6\u6D88");

	/**
	 * Create the dialog.
	 */
	public AddMoneyDialog(ShopFrame shopFrame) {

		this.shopFrame = shopFrame;

		setBounds(760, 490, 400, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			Component verticalGlue = Box.createVerticalGlue();
			contentPanel.add(verticalGlue);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				panel.add(horizontalGlue);
			}
			{
				JLabel lblNewLabel = new JLabel("\u5145\u503C\u91D1\u989D\uFF1A");
				panel.add(lblNewLabel);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setModel(spinnerNumberModel);
				panel.add(spinner);
			}
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				panel.add(horizontalGlue);
			}
		}
		{
			Component verticalGlue = Box.createVerticalGlue();
			contentPanel.add(verticalGlue);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				okButton.setActionCommand("OK");
				okButton.addMouseListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

				cancelButton.setActionCommand("Cancel");
				cancelButton.addMouseListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == okButton) {
			int money = (int) spinnerNumberModel.getValue();

			AppData appData = AppData.getInstance();
			User user = appData.getUser();
			user.setMoney(user.getMoney() + money);

			this.dispose();

			shopFrame.RefreshAllData();
		}

		if (e.getSource() == cancelButton) {
			
			this.dispose();
			shopFrame.RefreshAllData();
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

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
