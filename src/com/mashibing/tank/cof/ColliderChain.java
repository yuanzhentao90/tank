package com.mashibing.tank.cof;

import java.util.LinkedList;
import java.util.List;

import com.mashibing.tank.GameObject;

public class ColliderChain implements Collider {

	private List<Collider> colliders = new LinkedList<>();
	
	public ColliderChain() {
		add(new BulletTankCollider());
		add(new TankTankCollider());
	}
	
	public ColliderChain add(Collider c) {
		colliders.add(c);
		return this;
	}
	
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		for(int i=0;i<colliders.size();i++) {
			return !colliders.get(i).collide(o1, o2);
		}
		return true;

	}

}
