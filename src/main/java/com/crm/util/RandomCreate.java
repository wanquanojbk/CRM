package com.crm.util;

public class RandomCreate {
	public static int getRandom() {
		int min = 100000; // 定义随机数的最小值
		int max = 999999; // 定义随机数的最大值
		// 产生一个2~100的数
		int s = (int) min + (int) (Math.random() * (max - min));
		return s;
	}
}
