package com.startup.util;

import java.util.Timer;

public class TimeTask {
	
	public static void dayWork() {
		Timer timer = new Timer();
		timer.schedule(new Task(), 60 * 1000);
	}
}
