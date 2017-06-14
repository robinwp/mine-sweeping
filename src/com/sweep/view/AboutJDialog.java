package com.sweep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sweep.util.OpenUrlOnDefBs;

public class AboutJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;

	/**
	 * Create the dialog.
	 */

	public AboutJDialog() {
		setUndecorated(true);
		setBounds(100, 100, 354, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u626B\u96F7");
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 30));
		lblNewLabel.setIcon(new ImageIcon(AboutJDialog.class.getResource("/images/ssl.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(85, 30, 153, 46);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("<html><u>by 墨迹</u><html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(125, 115, 259, 25);
		lblNewLabel_1.setForeground(Color.blue);
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					OpenUrlOnDefBs.opUrl(null);
				}
			}
		});
		contentPanel.add(lblNewLabel_1);

		JLabel lblv = new JLabel("\u7248\u672C\u53F7\uFF1AV1.1.2017.6.14");
		lblv.setFont(new Font("宋体", Font.PLAIN, 15));
		lblv.setHorizontalAlignment(SwingConstants.CENTER);
		lblv.setBounds(74, 86, 232, 34);
		contentPanel.add(lblv);
		okButton = new JButton("\u786E\u5B9A");
		okButton.setBounds(245, 170, 85, 25);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
		this.setLocationRelativeTo(null);
	}
}
