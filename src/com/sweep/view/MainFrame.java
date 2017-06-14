package com.sweep.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sweep.model.SweepMap;
import com.sweep.service.SweepService;
import com.sweep.service.SweepTimeService;


public class MainFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton exit;
	private JButton resetStar;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu menu1;
	private JMenuItem menuItem;
	private JMenuItem xcdf;
	private JMenuItem menuItem_1;
	private JLabel num1;
	private JLabel num2;
	private JLabel num3;
	private JLabel t1;
	private JLabel t2;
	private JLabel lblNewLabel_4;
	private JLabel t3;
	private JLabel t4;
	private JPanel jp;
	private JPanel jp1;
	private boolean tB=false;
	
	public boolean istB() {
		return tB;
	}


	public void settB(boolean tB) {
		this.tB = tB;
	}


	public JLabel getNum1() {
		return num1;
	}


	public void setNum1(JLabel num1) {
		this.num1 = num1;
	}


	public JLabel getNum2() {
		return num2;
	}


	public void setNum2(JLabel num2) {
		this.num2 = num2;
	}


	public JLabel getNum3() {
		return num3;
	}


	public void setNum3(JLabel num3) {
		this.num3 = num3;
	}


	public JLabel getT1() {
		return t1;
	}


	public void setT1(JLabel t1) {
		this.t1 = t1;
	}


	public JLabel getT2() {
		return t2;
	}


	public void setT2(JLabel t2) {
		this.t2 = t2;
	}


	public JLabel getT3() {
		return t3;
	}


	public void setT3(JLabel t3) {
		this.t3 = t3;
	}


	public JLabel getT4() {
		return t4;
	}


	public void setT4(JLabel t4) {
		this.t4 = t4;
	}


	/**
	 * 构造函数
	 */
	public MainFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SweepMap.getSweep()));
		setTitle("\u626B\u96F7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 514);
		
		jp1=new JPanel();
		JLabel jLabel=new JLabel("游戏暂停中...");
		jp1.add(jLabel);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("\u9009\u9879");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("\u6E38\u620F\u96BE\u5EA6");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelJDialogActionPerformed(arg0);			
			}
		});
		menu.add(menuItem);
		
		xcdf = new JMenuItem("\u9000\u51FA");
		xcdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "是否退出游戏！", "提示", JOptionPane.YES_NO_OPTION);
				if(n==0){
					System.exit(0);	
				}
			}
		});
		menu.add(xcdf);
		
		menu1 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu1);
		
		menuItem_1 = new JMenuItem("\u5173\u4E8E");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutJDialog().setVisible(true);
			}
		});
		menu1.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel1 = new JPanel();
		
		
		JPanel panel_1 = new JPanel();
		resetStar = new JButton("\u91CD\u65B0\u5F00\u59CB");
		resetStar.setFont(new Font("宋体", Font.BOLD, 15));
		resetStar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetStarActionPerformed(e);
			}
		});
		
		exit = new JButton("\u9000\u51FA");
		exit.setFont(new Font("宋体", Font.BOLD, 15));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitActionPerformed(e);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "是否退出游戏！", "提示", JOptionPane.YES_NO_OPTION);
				if(n==0){
					System.exit(0);
				}else{
					MainFrame.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
			
		});
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SweepMap.getSweep()));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 15));
	
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel_1, BorderLayout.NORTH);
		contentPane.add(panel1,BorderLayout.SOUTH);
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_1MouseClicked(e);
			}
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/time1.png")));
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/time.png")));
			}
		});
		lblNewLabel_1.setFont(new Font("华文行楷", Font.BOLD, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/time.png")));
		panel1.add(lblNewLabel_1);
		
		t1 = new JLabel("");
		t1.setHorizontalAlignment(SwingConstants.RIGHT);
		t1.setIcon(new ImageIcon(SweepMap.getNum0()));
		panel1.add(t1);
		
		t2 = new JLabel("");
		t2.setHorizontalAlignment(SwingConstants.LEFT);
		t2.setIcon(new ImageIcon(SweepMap.getNum0()));
		panel1.add(t2);
		
		lblNewLabel_4 = new JLabel(":");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(lblNewLabel_4);
		
		t3 = new JLabel("");
		t3.setIcon(new ImageIcon(SweepMap.getNum0()));
		t3.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(t3);
		
		t4 = new JLabel("");
		t4.setIcon(new ImageIcon(SweepMap.getNum0()));
		t4.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(t4);
		
		num1 = new JLabel("");
		num1.setIcon(new ImageIcon(SweepMap.getNum0()));
		num1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		num2 = new JLabel("");
		num2.setIcon(new ImageIcon(SweepMap.getNum0()));
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		
		num3 = new JLabel("");
		num3.setIcon(new ImageIcon(SweepMap.getNum0()));
		num3.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(resetStar);
		panel_1.add(exit);
		panel_1.add(lblNewLabel);
		panel_1.add(num1);
		panel_1.add(num2);
		panel_1.add(num3);
		this.setLocationRelativeTo(null);
		SweepService sweepDao=new SweepService(this);
		SweepTimeService sweepTime=new SweepTimeService(this);
		jp=new JPanel();
		contentPane.add(sweepDao.input(jp));
		sweepTime.startThread();
		
	}
	
	/**
	 * 暂停事件处理
	 * @param e
	 */
	private void lblNewLabel_1MouseClicked(MouseEvent e) {
		if(SweepMap.isTimeb()){
			tB=true;
			SweepMap.setTimeb(false);
			contentPane.remove(jp);
			contentPane.add(jp1);
			repaint();
			validate();
		}else{
			tB=false;
			SweepTimeService sweepTime=new SweepTimeService(this);
			sweepTime.resThread();
			contentPane.remove(jp1);
			contentPane.add(jp);
			repaint();
			validate();
			
		}
		
		
	}


	/**
	 * 游戏难度事件处理
	 * @param arg0
	 */
	private void modelJDialogActionPerformed(ActionEvent arg0) {
		new ModelJDialog(this);	
	}


	/**
	 * 退出游戏事件处理
	 * @param e
	 */
	private void exitActionPerformed(ActionEvent e) {
		int n=JOptionPane.showConfirmDialog(null, "是否退出游戏！", "提示", JOptionPane.YES_NO_OPTION);
		if(n==0){
			System.exit(0);	
		}
	}
	/**
	 * 重新开始代码处理
	 * @param sweepMap
	 */
	public void resetStar() {
		SweepMap.setTimeb(false);
		int n=JOptionPane.showConfirmDialog(null, "当前游戏还在继续是否开始新游戏！", "提示", JOptionPane.YES_NO_OPTION);
		if(n==0){
			SweepMap.setTime(0);
			Component com=contentPane.getComponent(2);
			contentPane.remove(com);
			SweepService sweepDao=new SweepService(this);
			jp=new JPanel();
			contentPane.add(sweepDao.input(jp));
			SweepTimeService sweepTime=new SweepTimeService(this);
			sweepTime.startThread();
			//contentPane.repaint(0);//重新绘制窗体
			validate();//刷新窗体,这个比较给力
		}else{
			SweepTimeService sweepTime=new SweepTimeService(this);
			sweepTime.resThread();
		}
	}
	
	public void resStar(){
		Component com=contentPane.getComponent(2);
		contentPane.remove(com);
		SweepService sweepDao=new SweepService(this);
		jp=new JPanel();
		contentPane.add(sweepDao.input(jp));
		SweepTimeService sweepTime=new SweepTimeService(this);
		sweepTime.startThread();
		//contentPane.repaint(0);//重新绘制窗体
		validate();
	}
	
	
	/**
	 * 重新开始事件处理
	 * @param e
	 */
	private void resetStarActionPerformed(ActionEvent e) {
		if(SweepMap.isTimeb()){
			resetStar();
		}else {
			if(tB==true){//游戏暂停中
				SweepMap.setTime(0);
			}
			resStar();
		}
		
	}

}
