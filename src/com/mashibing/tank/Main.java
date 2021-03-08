package com.mashibing.tank;

public class Main {

	public static void main(String[] args) {
		TankFrame t = new TankFrame();
		
		int tankCount = Integer.parseInt((String)PropertyMgr.getValue("initTankCount"));
		
		for (int i = 0; i < tankCount; i++) {
			t.tanks.add(new Tank(50+50*i, 200, Dir.DOWN,Group.BAD, t));
		}
		
		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		
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
