package com.mashibing.tank.strategy;

import com.mashibing.tank.Audio;
import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameModel;
import com.mashibing.tank.Group;
import com.mashibing.tank.Tank;
import com.mashibing.tank.decorator.RectDecorator;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bX = t.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = t.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		
		GameModel.getInstance().add(new RectDecorator(new Bullet(bX , bY , t.dir , t.group)));
		
		if(t.group == Group.GOOD)
			new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
	}

}
