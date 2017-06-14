package com.sweep.model;

import java.net.URL;

import com.sweep.view.StarFrame;

/**
 * 设置地图大小和地雷数
 * @author 墨迹
 *
 */

public class SweepMap {
	private static int size1=9;//地图的大小，默认大小9
	private static int size2=9;//地图的大小，默认大小9
	
	private static int num=10;//地雷的个数
	private static int sweepnum=10;//地雷剩余的个数
	private static boolean timeb=true;
	
	private static URL num0 = StarFrame.class.getResource("/images/0.png");
	private static URL num1 = StarFrame.class.getResource("/images/1.png");
	private static URL num2 = StarFrame.class.getResource("/images/2.png");
	private static URL num3 = StarFrame.class.getResource("/images/3.png");
	private static URL num4 = StarFrame.class.getResource("/images/4.png");
	private static URL num5 = StarFrame.class.getResource("/images/5.png");
	private static URL num6 = StarFrame.class.getResource("/images/6.png");
	private static URL num7 = StarFrame.class.getResource("/images/7.png");
	private static URL num8 = StarFrame.class.getResource("/images/8.png");
	private static URL num9 = StarFrame.class.getResource("/images/9.png");
	private static URL sweep=StarFrame.class.getResource("/images/ssl.png");
	private static URL flag=StarFrame.class.getResource("/images/qz.png");
	private static URL ssc=StarFrame.class.getResource("/images/ssc.png");
	private static int time=0;
	
	
	
	
	public static boolean isTimeb() {
		return timeb;
	}
	public static void setTimeb(boolean timeb) {
		SweepMap.timeb = timeb;
	}
	public static int getTime() {
		return time;
	}
	public static void setTime(int time) {
		SweepMap.time = time;
	}
	public static int getSweepnum() {
		return sweepnum;
	}
	public static void setSweepnum(int sweepnum) {
		SweepMap.sweepnum = sweepnum;
	}
	
	
	public static URL getNum0() {
		return num0;
	}
	public static void setNum0(URL num0) {
		SweepMap.num0 = num0;
	}
	public static URL getNum1() {
		return num1;
	}
	public static void setNum1(URL num1) {
		SweepMap.num1 = num1;
	}
	public static URL getNum2() {
		return num2;
	}
	public static void setNum2(URL num2) {
		SweepMap.num2 = num2;
	}
	public static URL getNum3() {
		return num3;
	}
	public static void setNum3(URL num3) {
		SweepMap.num3 = num3;
	}
	public static URL getNum4() {
		return num4;
	}
	public static void setNum4(URL num4) {
		SweepMap.num4 = num4;
	}
	public static URL getNum5() {
		return num5;
	}
	public static void setNum5(URL num5) {
		SweepMap.num5 = num5;
	}
	public static URL getNum6() {
		return num6;
	}
	public static void setNum6(URL num6) {
		SweepMap.num6 = num6;
	}
	public static URL getNum7() {
		return num7;
	}
	public static void setNum7(URL num7) {
		SweepMap.num7 = num7;
	}
	public static URL getNum8() {
		return num8;
	}
	public static void setNum8(URL num8) {
		SweepMap.num8 = num8;
	}
	public static URL getNum9() {
		return num9;
	}
	public static void setNum9(URL num9) {
		SweepMap.num9 = num9;
	}
	public static URL getSweep() {
		return sweep;
	}
	public static void setSweep(URL sweep) {
		SweepMap.sweep = sweep;
	}
	public static URL getFlag() {
		return flag;
	}
	public static void setFlag(URL flag) {
		SweepMap.flag = flag;
	}
	public static URL getSsc() {
		return ssc;
	}
	public static void setSsc(URL ssc) {
		SweepMap.ssc = ssc;
	}
	public static int getSize1() {
		return size1;
	}
	public static void setSize1(int size1) {
		SweepMap.size1 = size1;
	}
	public static int getSize2() {
		return size2;
	}
	public static void setSize2(int size2) {
		SweepMap.size2 = size2;
	}


	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		SweepMap.num = num;
	}
	
}
