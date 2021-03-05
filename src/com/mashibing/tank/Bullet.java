package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹
 * @author Administrator
 */
public class Bullet {

	private static final int speed = 10;
	private static int WIDTH = 5,HEIGHT = 10;
	
	private int x,y;
	private Dir dir;
	
	private boolean isLive = true;
	TankFrame tf = null;
	
	public Bullet(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if (!isLive) {
			tf.bullets.remove(this);
		}
		
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
		move();
	}

	private void move() {
		switch (dir) {
		case LEFT:
			x -= speed;
			break;
		case UP:
			y -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		case DOWN:
			y += speed;
			break;

		default:
			break;
		}
		
		if (x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) 
			isLive=false;
	}
	
}
