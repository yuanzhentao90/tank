package com.mashibing.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 炮弹
 * @author Administrator
 */
public class Bullet extends GameObject{

	private static final int speed = 10;
	public static int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();
	
	private int x,y;
	private Dir dir;
	
	Rectangle rect = new Rectangle();
	
	private boolean isLive = true;
	GameModel gm = null;
	private Group group = Group.BAD;
	
	public Bullet(int x, int y, Dir dir,Group group ,GameModel gm) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		this.gm = gm;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
		gm.add(this);
		
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}


	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
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

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public static int getSpeed() {
		return speed;
	}

	public void paint(Graphics g) {
		if (!isLive) {
			gm.remove(this);
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
		
		//更新rect
		rect.x = this.x;
		rect.y = this.y;
		
		if (x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) 
			isLive=false;
	}

	//判断炮弹是否击中坦克
	public void collideWith(Tank tank) {
		
		if(this.group == tank.group) return;
		//TODO 优化使用一个rect来控制，避免内存溢出提高代码性能。
//		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		
		if (this.rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			int ex = tank.x+Tank.WIDTH/2 - Explode.WIDTH/2;
			int ey = tank.y+Tank.HEIGHT/2 -Explode.HEIGHT/2;
			gm.add(new Explode(ex,ey,gm));
		}
	}

	private void die() {
		this.isLive = false;
	}
	
}
