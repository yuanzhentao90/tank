package com.mashibing.tank;

public class GameModel {

	private GameModel() {
		
	}
	private static GameModel INSTANCE = new GameModel();
	public static GameModel getInstance() {
		return INSTANCE;
	}
}
