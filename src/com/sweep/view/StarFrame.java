package com.sweep.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.sweep.util.OpenUrlOnDefBs;

public class StarFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarFrame frame = new StarFrame();
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
	public StarFrame() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "设置Windows界面风格失败！");
		}
		setTitle("\u626B\u96F7");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StarFrame.class.getResource("/images/ssl.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "是否退出游戏", "提示", JOptionPane.YES_NO_OPTION);
				if (n == 0) {
					System.exit(0);
				} else {
					StarFrame.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
			
		});
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(StarFrame.class.getResource("/images/sl.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 34));
		lblNewLabel.setBounds(29, 10, 301, 294);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u626B");
		lblNewLabel_1.setFont(new Font("华文行楷", Font.PLAIN, 99));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(340, 52, 124, 95);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u96F7");
		label.setFont(new Font("华文行楷", Font.BOLD, 99));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(340, 157, 124, 114);
		contentPane.add(label);

		JButton btnNewButton = new JButton("\u5F00\u59CB");
		btnNewButton.setBackground(new Color(238, 238, 238));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StarActionPerformed(arg0);
			}
		});
		btnNewButton.setBounds(114, 309, 93, 45);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setBackground(new Color(238, 238, 238));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelActionPerformed(e);
			}
		});
		btnNewButton_1.setBounds(295, 309, 93, 45);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("<html><u>by 墨迹</u><html>");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(349, 366, 245, 25);
		lblNewLabel_2.setForeground(Color.blue);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					OpenUrlOnDefBs.opUrl(null);
				}
			}
		});
		contentPane.add(lblNewLabel_2);
		this.setLocationRelativeTo(null);
	}

	private void cancelActionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(null, "是否退出游戏", "提示", JOptionPane.YES_NO_OPTION);
		if (n == 0) {
			System.exit(0);
		}
	}

	private void StarActionPerformed(ActionEvent arg0) {
		dispose();
		new MainFrame().setVisible(true);
	}
}
