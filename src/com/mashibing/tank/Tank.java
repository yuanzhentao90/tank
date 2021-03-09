package com.mashibing.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank {

	int x,y;
	Dir dir = Dir.DOWN;
	private static final int speed = 5;
	private boolean moving = true;
	TankFrame tf;
	
	Rectangle rect = new Rectangle();
	
	private boolean isLive = true;
	
	private Random random = new Random();
	
	Group group = Group.BAD;
	
	FireStrategy fs ;
	
	public static int WIDTH = ResourceMgr.goodTankU.getWidth(),HEIGHT = ResourceMgr.goodTankU.getHeight();
	
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank() {
	}

	public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.tf = tf;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
		if (group == Group.BAD) fs = new DefaultFireStrategy();
		else fs = new FourDirFireStrategy();
	}

	public void paint(Graphics g) {
		
		if (!isLive) tf.tanks.remove(this);
		
		switch (dir) {
		case LEFT:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL,x,y,null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU,x,y,null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR,x,y,null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD,x,y,null);
			break;

		default:
			break;
		}
		
		move();
	}
	

	private void move() {
		if (!moving) return;
		
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
		
		if(this.group == Group.BAD && random.nextInt(10)>8) this.fire();
		if(this.group == Group.BAD && random.nextInt(100)>95) randomDir();
		
		//边界检测
		boundsCheck();
		
		//更新rect
		rect.x = this.x;
		rect.y = this.y;
	}

	//边界检测
	private void boundsCheck() {
		if(this.x < 0) x = 0;
		if(this.y < 30) y =30;
		if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH) x = TankFrame.GAME_WIDTH - Tank.WIDTH;
		if(this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
	}

	private void randomDir() {
		this.dir = Dir.values()[random.nextInt(4)];
	}

	public Tank(TankFrame tf) {
		super();
		this.tf = tf;
	}

	public void fire() {
//		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
//		int bY = this.y + Tank.HEIGHT/2 - Bullet.WIDTH/2;
//		tf.bullets.add(new Bullet(bX, bY, this.dir,this.group,tf));
		fs.fire(this);
	}

	public void die() {
		this.isLive = false;
	}
	
}
