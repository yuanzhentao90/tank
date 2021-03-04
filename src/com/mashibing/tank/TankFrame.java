package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{

	Tank myTank = new Tank(375, 275, Dir.DOWN);
	
	public TankFrame() {
		setSize(800, 600);
		setResizable(false);
		setTitle("Tank war");
		setVisible(true);
		
		//添加键盘监听
		addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//窗口重新绘制的时候会调用该方法
	@Override
	public void paint(/*画笔*/Graphics g) {
		myTank.paint(g);
		
	}
	
	//键盘监听处理类
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		//键被按下的时候调用
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;

			default:
				break;
			}
			setMainTankDir();
		}
		
		//键被抬起来的时候调用
		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;

			default:
				break;
			}
			setMainTankDir();
		}

		//设置主战坦克的方向
		private void setMainTankDir() {
			myTank.setMoving(true);
			if (bL) myTank.setDir(Dir.LEFT);
			if (bU) myTank.setDir(Dir.UP);
			if (bR) myTank.setDir(Dir.RIGHT);
			if (bD) myTank.setDir(Dir.DOWN);
			
			if (!bL && !bU && !bR && !bD) myTank.setMoving(false);
		}
		
	}
}
