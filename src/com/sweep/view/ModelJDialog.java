package com.sweep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.sweep.model.SweepMap;
import com.sweep.service.SweepTimeService;

import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModelJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField row;
	private JTextField con;
	private JRadioButton diy;
	private JRadioButton hard;
	private JRadioButton easy;
	private JRadioButton com;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField num;
	MainFrame mainFrame;

	public ModelJDialog(MainFrame mainFrame) {
		super(mainFrame, true);
		this.mainFrame = mainFrame;
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setUndecorated(true);
		setBounds(100, 100, 424, 303);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		easy = new JRadioButton("\u7B80\u5355");
		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose();
			}
		});
		buttonGroup.add(easy);
		easy.setFont(new Font("华文行楷", Font.PLAIN, 23));
		easy.setBounds(48, 97, 86, 51);
		contentPanel.add(easy);

		com = new JRadioButton("\u666E\u901A");
		com.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose();
			}
		});
		buttonGroup.add(com);
		com.setFont(new Font("华文行楷", Font.PLAIN, 23));
		com.setBounds(158, 97, 86, 51);
		contentPanel.add(com);

		hard = new JRadioButton("\u56F0\u96BE");
		hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose();
			}
		});
		buttonGroup.add(hard);
		hard.setFont(new Font("华文行楷", Font.PLAIN, 23));
		hard.setBounds(268, 97, 86, 51);
		contentPanel.add(hard);

		diy = new JRadioButton("\u81EA\u5B9A\u4E49");
		diy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diyActionPerformed(e);
			}
		});
		buttonGroup.add(diy);
		diy.setFont(new Font("华文行楷", Font.PLAIN, 23));
		diy.setBounds(48, 175, 101, 48);
		contentPanel.add(diy);

		row = new JTextField();
		row.setEditable(false);
		row.setBounds(208, 160, 66, 21);
		contentPanel.add(row);
		row.setColumns(10);

		con = new JTextField();
		con.setEditable(false);
		con.setBounds(208, 190, 66, 21);
		contentPanel.add(con);
		con.setColumns(10);

		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u6E38\u620F\u96BE\u5EA6");
		label.setFont(new Font("华文行楷", Font.PLAIN, 34));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(48, 25, 285, 58);
		contentPanel.add(label);

		num = new JTextField();
		num.setEditable(false);
		num.setBounds(208, 220, 66, 21);
		contentPanel.add(num);
		num.setColumns(10);

		JLabel label_1 = new JLabel("\u5BBD\u5EA6\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 15));
		label_1.setBounds(158, 160, 45, 22);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("\u9AD8\u5EA6\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("华文行楷", Font.PLAIN, 15));
		label_2.setBounds(158, 190, 45, 22);
		contentPanel.add(label_2);

		JLabel label_3 = new JLabel("\u96F7\u6570\uFF1A");
		label_3.setFont(new Font("华文行楷", Font.PLAIN, 15));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(158, 220, 45, 22);
		contentPanel.add(label_3);

		JLabel lblMax = new JLabel("min : 9, max : 30");
		lblMax.setHorizontalAlignment(SwingConstants.CENTER);
		lblMax.setBounds(279, 163, 112, 15);
		contentPanel.add(lblMax);

		JLabel lblMin = new JLabel("min : 9, max : 16");
		lblMin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMin.setBounds(279, 193, 112, 15);
		contentPanel.add(lblMin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						okButtonActionPerformed(arg0);
					}
				});
				okButton.setBackground(new Color(238, 238, 238));
				okButton.setFont(new Font("宋体", Font.PLAIN, 15));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setFont(new Font("宋体", Font.PLAIN, 15));
				cancelButton.addActionListener(new ActionListener() {
					/**
					 * 取消按钮事件处理
					 */
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(238, 238, 238));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setLocationRelativeTo(null);
		int a = SweepMap.getSize2();
		if (a == 9) {
			easy.setSelected(true);
		} else if (a == 16) {
			com.setSelected(true);
		} else if (a == 30) {
			hard.setSelected(true);
		} else {
			diy.setSelected(true);
			row.setEditable(true);
			con.setEditable(true);
			num.setEditable(true);
		}
		this.setVisible(true);
	}

	public void okCliec() {
		if (easy.isSelected()) {
			SweepMap.setSize1(9);
			SweepMap.setSize2(9);
			SweepMap.setNum(10);
			mainFrame.setBounds(100, 100, 519, 514);
			mainFrame.setLocationRelativeTo(null);
		} else if (hard.isSelected()) {
			SweepMap.setSize1(16);
			SweepMap.setSize2(30);
			SweepMap.setNum(99);
			mainFrame.setBounds(100, 100, 1300, 765);
			mainFrame.setLocationRelativeTo(null);
		} else if (com.isSelected()) {
			SweepMap.setSize1(16);
			SweepMap.setSize2(16);
			SweepMap.setNum(40);
			mainFrame.setBounds(100, 100, 750, 750);
			mainFrame.setLocationRelativeTo(null);
		} else if (diy.isSelected()) {
			try {
				int a = Integer.valueOf(row.getText());
				int b = Integer.valueOf(con.getText());
				int c = Integer.valueOf(num.getText());
				if (b < 9 || a < 9 || a > 16 || b > 30 || c > a * b || c < 1) {
					JOptionPane.showMessageDialog(null, "请输入正确的值！");
					row.setText("");
					con.setText("");
					num.setText("");
					return;
				}
				SweepMap.setSize1(a);
				SweepMap.setSize2(b);
				SweepMap.setNum(c);
				mainFrame.setBounds(100, 100, 1300, 760);
				mainFrame.setLocationRelativeTo(null);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "请输入正确的值！");
				row.setText("");
				con.setText("");
				num.setText("");
				return;
			}
		}
		dispose();
	}

	/**
	 * ok事件点击事件处理
	 * 
	 * @param arg0
	 */
	private void okButtonActionPerformed(ActionEvent arg0) {
		if (SweepMap.isTimeb()) {
			SweepMap.setTimeb(false);
			;
			int n = JOptionPane.showConfirmDialog(null, "当前游戏还在继续是否开始新游戏！", "提示", JOptionPane.YES_NO_OPTION);
			if (n == 0) {
				okCliec();
				SweepMap.setTime(0);
				mainFrame.resStar();
			} else {
				SweepTimeService sweepTime = new SweepTimeService(mainFrame);
				sweepTime.resThread();
			}

		} else {
			okCliec();
			if (mainFrame.istB()) {
				SweepMap.setTime(0);
			}
			mainFrame.resStar();
		}
	}

	private void choose() {
		row.setEditable(false);
		con.setEditable(false);
		num.setEditable(false);
	}

	/**
	 * 自定义单选框点击事件
	 * 
	 * @param e
	 */
	private void diyActionPerformed(ActionEvent e) {
		row.setEditable(true);
		con.setEditable(true);
		num.setEditable(true);
	}
}
