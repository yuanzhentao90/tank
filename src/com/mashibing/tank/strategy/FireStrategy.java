package com.mashibing.tank.strategy;

import java.io.Serializable;

import com.mashibing.tank.Tank;

/**
 * 坦克开火策略
 *
 */
public interface FireStrategy extends Serializable{

	void fire(Tank t);
	
}
