package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int speed = 5;
	private boolean moving = false;
	private TankFrame tf;
	
	public Tank() {
	}

	public Tank(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void paint(Graphics g) {
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL,x,y,null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU,x,y,null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR,x,y,null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD,x,y,null);
			break;

		default:
			break;
		}
		
		move();
	}
	

	private void move() {
		if (!moving) {
			return;
		}
		
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
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public static int getSpeed() {
		return speed;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank(TankFrame tf) {
		super();
		this.tf = tf;
	}

	public void fire() {
		tf.bullets.add(new Bullet(this.x, y, this.dir,tf));
	}
	
}
