package com.mashibing.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

	private GameModel() {
		int tankCount = Integer.parseInt((String)PropertyMgr.getValue("initTankCount"));
		
		for (int i = 0; i < tankCount; i++) {
			tanks.add(new Tank(50+50*i, 200, Dir.DOWN,Group.BAD, this));
		}
	}
	private static GameModel INSTANCE = new GameModel();
	public static GameModel getInstance() {
		return INSTANCE;
	}
	
	Tank myTank = new Tank(375, 275, Dir.DOWN,Group.GOOD,this);
	List<Bullet> bullets = new ArrayList<>();
	List<Tank> tanks = new ArrayList<>();
	List<Explode> explodes = new ArrayList<>();
	
	public void paint(/*画笔*/Graphics g) {
		
		Color c = g.getColor();
		g.setColor(Color.white);
		g.drawString("子弹的数量"+bullets.size(), 10, 60);
		g.drawString("敌方坦克数量"+tanks.size(), 10, 80);
		g.drawString("爆炸效果数量"+explodes.size(), 10, 100);
		g.setColor(c);
		//己方坦克
		myTank.paint(g);
		//坦克子弹
//		for(Bullet bullet : bullets) //这种方法遍历时不能删除集合中的元素
		for (int i = 0; i < bullets.size(); i++) //这种方法遍历时可以删除集合中的元素不会发生异常 
			bullets.get(i).paint(g);
		
//		for (Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext();) {
//			Bullet bullet = iterator.next();
//			if (!bullet.isLive) iterator.remove();
//		}
		
		//敌方坦克
		for (int i = 0; i < tanks.size(); i++)
			tanks.get(i).paint(g);
		
		//爆炸效果图
				for(int i=0 ;i<explodes.size();i++)
					explodes.get(i).paint(g);
		
		//判断炮弹是否打到坦克上面
		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < tanks.size(); j++) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}
	}

	public Tank getMainTank() {
		return myTank;
	}
}
