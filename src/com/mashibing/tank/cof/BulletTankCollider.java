package com.mashibing.tank.cof;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

public class BulletTankCollider implements Collider {

	@Override
	public void collide(GameObject o1, GameObject o2) {

		if(o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet b = (Bullet)o1;
			Tank t = (Tank) o2;
			b.collideWith(t);
		}else if(o1 instanceof Tank && o2 instanceof Bullet) {
			collide(o2,o1);
		}else {
			return;
		}
	}

}
