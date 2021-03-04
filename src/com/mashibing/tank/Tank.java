package com.mashibing.tank;

import java.awt.Graphics;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Tank {

	private int x,y;
	private Dir dir = Dir.DOWN;
	private static final int speed = 10;
	private boolean moving = false;
	
	public Tank() {
	}

	public Tank(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
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
	
}
