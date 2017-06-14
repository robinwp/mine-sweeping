package com.sweep.service;

import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;

import com.sweep.model.SweepMap;
import com.sweep.view.MainFrame;

public class SweepTimeService implements Runnable {

	HashMap<Integer, URL> numMap = new HashMap<Integer, URL>();
	MainFrame mainFrame;
	static int time = 0;
	
	public SweepTimeService(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		time=SweepMap.getTime();
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
	}
	/**
	 * 启动线程
	 */
	public void startThread(){
		//time = SweepMap.getTime();
		SweepMap.setTimeb(true);
		Thread thread=new Thread(this);
		thread.start();
	}
	
	/**
	 * 恢复线程
	 */
	public void resThread(){
		//time=SweepMap.getTime();
		SweepMap.setTimeb(true);
		Thread thread=new Thread(this);
		thread.start();
	}
	/**
	 * 停止线程的方法
	 */
	public static void stopThread(){
		SweepMap.setTimeb(false);
		time=SweepMap.getTime();
	}
	/**
	 * 线程方法
	 */
	public void run() {
		while (SweepMap.isTimeb()) {
			try {
				showTime();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
	/**
	 * 显示游戏用时
	 */
	public void showTime() {
		SweepMap.setTime(time);
		if (time == 6039) {
			mainFrame.getT1().setIcon(new ImageIcon(numMap.get(9)));
			mainFrame.getT2().setIcon(new ImageIcon(numMap.get(9)));
			mainFrame.getT3().setIcon(new ImageIcon(numMap.get(9)));
			mainFrame.getT4().setIcon(new ImageIcon(numMap.get(9)));
		} else {
			int a=(time / 60)/10;
			int b = (time / 60)%10; 
			int c = (time-a*600-b*60)/10; 
			int d = (time-a*600-b*60)%10;
			mainFrame.getT1().setIcon(new ImageIcon(numMap.get(a)));
			mainFrame.getT2().setIcon(new ImageIcon(numMap.get(b)));
			mainFrame.getT3().setIcon(new ImageIcon(numMap.get(c)));
			mainFrame.getT4().setIcon(new ImageIcon(numMap.get(d)));
			time++;
		}
	}


	
}
