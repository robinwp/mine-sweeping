package com.sweep.service;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sweep.model.SweepMap;
import com.sweep.view.MainFrame;
import com.sweep.view.StarFrame;

public class SweepService {
	private JLabel jbButton[][] = new JLabel[SweepMap.getSize1()][SweepMap.getSize2()];;
	private int arr[][] = new int[SweepMap.getSize1()][SweepMap.getSize2()];
	MainFrame mainFrame;
	boolean[][] b = new boolean[SweepMap.getSize1()][SweepMap.getSize2()];
	boolean bo = false;
	HashMap<Integer, URL> numMap = new HashMap<Integer, URL>();

	/**
	 * 构造函数
	 */
	public SweepService(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		SweepMap.setSweepnum(SweepMap.getNum());
		numMap.put(0, SweepMap.getNum0());
		numMap.put(1, SweepMap.getNum1());
		numMap.put(2, SweepMap.getNum2());
		numMap.put(3, SweepMap.getNum3());
		numMap.put(4, SweepMap.getNum4());
		numMap.put(5, SweepMap.getNum5());
		numMap.put(6, SweepMap.getNum6());
		numMap.put(7, SweepMap.getNum7());
		numMap.put(8, SweepMap.getNum8());
		numMap.put(9, SweepMap.getNum9());
		showSweepNum();
	}

	/**
	 * 游戏胜利的判断
	 */
	public void win() {
		String c = "", d = "";
		for (int i = 0; i < jbButton.length; i++)
			for (int j = 0; j < jbButton[i].length; j++) {
				if (arr[i][j] != -1 && arr[i][j] != 0) {
					c += String.valueOf(arr[i][j]);
					d += jbButton[i][j].getText();
				}
			}

		if (c.equals(d)) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == -1) {
						jbButton[i][j].setIcon(new ImageIcon(StarFrame.class.getResource("/images/ssl.png")));
					}
				}
			}
			bo = true;
			SweepTimeService.stopThread();
			SweepMap.setTime(0);
			JOptionPane.showMessageDialog(null, "游戏胜利！");
		}
	}

	/**
	 * 添加扫雷地图实例
	 * 
	 * @param sweepMap
	 * @return
	 */
	public JPanel input(JPanel jPanel) {
		jPanel.setLayout(new GridLayout(SweepMap.getSize1(), SweepMap.getSize2(), 1, 1));
		JLabel jbButton[][] = new JLabel[SweepMap.getSize1()][SweepMap.getSize2()];
		this.jbButton = jbButton;
		for (int i = 0; i < SweepMap.getSize1(); i++) {
			for (int j = 0; j < SweepMap.getSize2(); j++) {
				jbButton[i][j] = new JLabel();
				jbButton[i][j].setText("");
				jbButton[i][j].setBackground(new Color(45, 45, 255));
				jbButton[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				jbButton[i][j].setOpaque(true);
				jPanel.add(jbButton[i][j]);
				jbButton[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if (e.getButton() == 1) {
							jbButtonActionPerformed(e);
						} else if (e.getButton() == 3) {
							jbButtonMouseClicked(e);// 右击事件
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						jbButtonMouseEntered(e);
					}

					@Override
					public void mouseExited(MouseEvent e) {
						jbButtonMouseExited(e);
					}

				});
			}
		}
		setSweep(arr);

		return jPanel;
	}

	private void jbButtonMouseExited(MouseEvent e) {
		for (int i = 0; i < jbButton.length; i++) {
			for (int j = 0; j < jbButton[i].length; j++) {
				if (e.getSource() == jbButton[i][j]) {
					if (jbButton[i][j].getBackground() != Color.lightGray) {
						jbButton[i][j].setBackground(new Color(45, 45, 255));
					}
				}
			}
		}

	}

	/**
	 * 鼠标进入事件
	 * 
	 * @param e
	 */
	private void jbButtonMouseEntered(MouseEvent e) {
		for (int i = 0; i < jbButton.length; i++) {
			for (int j = 0; j < jbButton[i].length; j++) {
				if (e.getSource() == jbButton[i][j]) {
					if (jbButton[i][j].getBackground() != Color.lightGray) {
						jbButton[i][j].setBackground(new Color(111, 111, 255));
					}
				}
			}
		}

	}

	/**
	 * 显示当前地雷的数目
	 */
	public void showSweepNum() {
		int s = SweepMap.getSweepnum();
		int a = s / 100; // 百位
		int b = (s / 10) % 10; // 十位
		int c = (s % 10) % 10; // 个位
		mainFrame.getNum1().setIcon(new ImageIcon(numMap.get(a)));
		mainFrame.getNum2().setIcon(new ImageIcon(numMap.get(b)));
		mainFrame.getNum3().setIcon(new ImageIcon(numMap.get(c)));
	}

	/**
	 * 如果点到的是空白块，自动展开周围
	 * 
	 * @param x
	 * @param y
	 */
	public void isNull(int x, int y) {// 显示出,点击按钮之后周围不是雷的按钮
		for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, SweepMap.getSize1() - 1); i++)
			for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, SweepMap.getSize2() - 1); j++) {
				if (jbButton[i][j].getIcon() == null) {// -1代表不是雷
					if (jbButton[i][j].getBackground() != Color.lightGray) {
						if (arr[i][j] == 0) {
							jbButton[i][j].setBackground(Color.lightGray);
							isNull(i, j);
						} else {
							jbButton[i][j].setBackground(Color.lightGray);
							jbButton[i][j].setText(String.valueOf(arr[i][j]));
						}
					}

				}
			}
	}

	/**
	 * 游戏规则代码段
	 * 
	 * @param x
	 * @param y
	 */
	public void rule(int x, int y) {
		if (!b[x][y]) {
			if (arr[x][y] == 0) {
				isNull(x, y);
			} else if (arr[x][y] == -1) {
				jbButton[x][y].setIcon(new ImageIcon(SweepMap.getSweep()));
				jbButton[x][y].setBackground(Color.red);
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[i].length; j++) {
						if (arr[i][j] == -1 && (i != x || j != y)) {
							jbButton[i][j].setIcon(new ImageIcon(SweepMap.getSweep()));
						} else if (arr[i][j] != -1 && jbButton[i][j].getIcon() != null) {
							jbButton[i][j].setBackground(Color.white);
							jbButton[i][j].setIcon(new ImageIcon(SweepMap.getSsc()));
						}
					}
				}
				bo = true;
				SweepTimeService.stopThread();
				SweepMap.setTime(0);
				JOptionPane.showMessageDialog(null, "踩到雷了！游戏失败！");
			} else {
				jbButton[x][y].setBackground(Color.lightGray);
				jbButton[x][y].setText(String.valueOf(arr[x][y]));
			}
		}

	}

	/**
	 * 插旗帜
	 * 
	 * @param x
	 * @param y
	 */
	public void setFlag(int x, int y) {
		if (!b[x][y] && jbButton[x][y].getBackground() != Color.lightGray) {
			jbButton[x][y].setIcon(new ImageIcon(SweepMap.getFlag()));
			SweepMap.setSweepnum(SweepMap.getSweepnum() - 1);
			showSweepNum();
			b[x][y] = true;
		} else if (b[x][y]) {
			jbButton[x][y].setIcon(null);
			SweepMap.setSweepnum(SweepMap.getSweepnum() + 1);
			showSweepNum();
			b[x][y] = false;
		}
	}

	/**
	 * 鼠标单击按钮事件处理
	 * 
	 * @param e
	 */
	private void jbButtonActionPerformed(MouseEvent e) {
		for (int i = 0; i < jbButton.length; i++) {
			for (int j = 0; j < jbButton[i].length; j++) {
				if (e.getSource() == jbButton[i][j]) {
					if (!bo) {
						rule(i, j);
						win();
					} else {
						mainFrame.resStar();
					}
				}
			}
		}
	}

	/**
	 * 鼠标右击事件处理
	 * 
	 * @param e
	 */
	public void jbButtonMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			for (int i = 0; i < jbButton.length; i++) {
				for (int j = 0; j < jbButton[i].length; j++) {
					if (e.getSource() == jbButton[i][j]) {
						if (!bo) {
							setFlag(i, j);
						} else {
							mainFrame.resetStar();
						}
					}
				}
			}
		}
	}

	/**
	 * 设置地雷并且计算周围的地雷数
	 * 
	 * @param num
	 */
	public int[][] setSweep(int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = 0;
			}
		setSweepIn(arr);
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == -1) {
					for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, SweepMap.getSize1() - 1); x++)
						for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, SweepMap.getSize2() - 1); y++) {
							if (arr[x][y] != -1)
								arr[x][y]++;
						}
				}
			}

		return arr;
	}

	/**
	 * 设置地雷的随机位置
	 * 
	 * @param num
	 * @return
	 */
	public int[][] setSweepIn(int[][] num) {// 雷数
		int[] a = new int[SweepMap.getNum()];
		int[] b = new int[SweepMap.getNum()];
		String[] s = new String[SweepMap.getNum()];
		String[] ss = new String[SweepMap.getNum()];
		boolean pd = false;
		for (int i = 0; i < SweepMap.getNum(); i++) { // 随机不重复获得num个不同的位置标记为雷
			do {
				a[i] = (int) (Math.random() * (SweepMap.getSize1() - 1));
				b[i] = (int) (Math.random() * (SweepMap.getSize2() - 1));
				s[i] = String.valueOf(a[i]) + String.valueOf(b[i]);
				for (int j = 0; j < s.length; j++) {
					if (s[i].equals(ss[j])) {
						pd = true;
						break;
					} else {
						pd = false;
					}
				}
				ss[i] = s[i];
			} while (pd == true);
			num[a[i]][b[i]] = -1;// 值为-1，代表是雷
		}
		return num;
	}

}
