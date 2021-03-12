package com.mashibing.tank.cof;

import com.mashibing.tank.GameObject;

/**
 * 责任链模式
 * 碰撞器接口
 */
public interface Collider {

	boolean collide(GameObject o1,GameObject o2);
}
