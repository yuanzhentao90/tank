package com.mashibing.tank;
/**
 * 资源管理器,把图片内容都加载进内存
 * @author Administrator
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {

	public static BufferedImage tankL , tankU , tankR , tankD;
	
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
