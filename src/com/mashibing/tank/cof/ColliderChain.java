package com.mashibing.tank.cof;

import java.util.LinkedList;
import java.util.List;

import com.mashibing.tank.GameObject;
import com.mashibing.tank.PropertyMgr;

public class ColliderChain implements Collider {

	private List<Collider> colliders = new LinkedList<>();
	
	String colliderClasses = (String)PropertyMgr.getValue("colliders");
	String[] colldierNames = colliderClasses.split(",");
	
	
	public ColliderChain() {
		for(int i=0;i<colldierNames.length;i++) {
			Collider collider = null;
			try {
				collider = (Collider)Class.forName(colldierNames[i].trim()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			add(collider);
		}
	}
	
	public ColliderChain add(Collider c) {
		colliders.add(c);
		return this;
	}
	
	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		for(int i=0; i<colliders.size(); i++) {
			if(!colliders.get(i).collide(o1, o2))
				return false;
		}
		return true;

	}

}
