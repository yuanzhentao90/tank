package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 炮弹
 * @author Administrator
 */
public class Bullet {

	private static final int speed = 10;
	public static int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();
	
	private int x,y;
	private Dir dir;
	
	boolean isLive = true;
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
		
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL,x,y,null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU,x,y,null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR,x,y,null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD,x,y,null);
			break;

		default:
			break;
		}
		
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

	//判断炮弹是否击中坦克
	public void collideWith(Tank tank) {
		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if (rect1.intersects(rect2)) {
			tank.die();
			this.die();
		}
	}

	private void die() {
		this.isLive = false;
	}
	
}
