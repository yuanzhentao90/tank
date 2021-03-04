package com.mashibing.tank;

public class Main {

	public static void main(String[] args) {
		TankFrame t = new TankFrame();
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.repaint();
	}
	
}
