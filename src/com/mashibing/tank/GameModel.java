package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.mashibing.tank.cof.ColliderChain;

public class GameModel {

	private static GameModel INSTANCE = new GameModel();
	
	static {
		INSTANCE.init();
	}
	
	Tank myTank;
	
	private GameModel() {
		
	}
	
	public static GameModel getInstance() {
		return INSTANCE;
	}
	private void init() {
		myTank = new Tank(375, 275, Dir.DOWN,Group.GOOD);
		int tankCount = Integer.parseInt((String)PropertyMgr.getValue("initTankCount"));
		
		for (int i = 0; i < tankCount; i++) {
			new Tank(50+100*i, 200, Dir.DOWN,Group.BAD);
		}
		
		add(new Wall(150,150,200,50));
		add(new Wall(550,150,200,50));
		add(new Wall(300,300,50,200));
		add(new Wall(550,300,50,200));
	}
	
//	List<Bullet> bullets = new ArrayList<>();
//	List<Tank> tanks = new ArrayList<>();
//	List<Explode> explodes = new ArrayList<>();
	
//	Collider collider = new BulletTankCollider();
//	Collider collider2 = new TankTankCollider();
	ColliderChain chain = new ColliderChain();
	
	private List<GameObject> objects = new ArrayList<>();
	
	public void add(GameObject go) {
		this.objects.add(go);
	}
	
	public void remove(GameObject go) {
		this.objects.remove(go);
	}
	
	public void paint(/*画笔*/Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.white);
//		g.drawString("子弹的数量"+bullets.size(), 10, 60);
//		g.drawString("敌方坦克数量"+tanks.size(), 10, 80);
//		g.drawString("爆炸效果数量"+explodes.size(), 10, 100);
		g.setColor(c);
		//己方坦克
		myTank.paint(g);
		//坦克子弹
		for (int i = 0; i < objects.size(); i++) //这种方法遍历时可以删除集合中的元素不会发生异常 
			objects.get(i).paint(g);
		
//		for (Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext();) {
//			Bullet bullet = iterator.next();
//			if (!bullet.isLive) iterator.remove();
//		}
		
		//判断炮弹是否打到坦克上面
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i+1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
//				collider.collide(o1, o2);
//				collider2.collide(o1, o2);
				chain.collide(o1, o2);
			}
		}
	}

	public Tank getMainTank() {
		return myTank;
	}
}
