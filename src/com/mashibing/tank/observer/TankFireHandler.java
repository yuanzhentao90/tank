package com.mashibing.tank.observer;

import com.mashibing.tank.Tank;

public class TankFireHandler implements TankFireObserver{

	@Override
	public void actionOnFire(TankFireEvent event) {

		Tank tank = event.getTank();
		tank.fire();
		
	}

}
