package com.startup.util;

import java.util.Random;

public class MyRandom {
	
	public static int createClassNo(int classId) {
		String str = "9" + Integer.toOctalString(classId);
		int length1 = str.length();
		if(length1 >= 8)
			return Integer.valueOf(str);
		else {
			int length2 = 8 - length1;
			int RandomNum = createRandom(length2);
			int classNo = RandomNum * ((int)Math.pow(10, length1)) + Integer.valueOf(str);
			return classNo;
		}
	}
	
	//产生num位的随机数,num >= 1
	public static int createRandom(int num) {
		if(num >= 1) {
			Random randomno = new Random(); 
			int result = randomno.nextInt((int)Math.pow(10, num - 1) * 9) + (int)Math.pow(10, num - 1);
			return result;
		} else 
			return 0;
	}
}
