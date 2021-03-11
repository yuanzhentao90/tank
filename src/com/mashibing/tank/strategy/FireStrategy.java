package com.mashibing.tank.strategy;

import com.mashibing.tank.Tank;

/**
 * 坦克开火策略
 *
 */
public interface FireStrategy {

	void fire(Tank t);
	
}
