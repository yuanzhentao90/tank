package com.mashibing.tank;

public class Main {

	public static void main(String[] args) {
		TankFrame t = new TankFrame();
		
//		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		
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
