package com.mashibing.tank;

public class Main {

	public static void main(String[] args) {
		TankFrame t = new TankFrame();
		
		for (int i = 0; i < 5; i++) {
			t.tanks.add(new Tank(50+50*i, 200, Dir.DOWN, t));
		}
		
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.repaint();
		}
	}
	
}
