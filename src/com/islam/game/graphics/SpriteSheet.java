package com.islam.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

	public static SpriteSheet tiles = new SpriteSheet("/textures/lo.png",256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/spawnlevel.png",48);
	public static SpriteSheet projectile = new SpriteSheet("/textures/projectile.png",48);
	public static SpriteSheet dummy = new SpriteSheet("/textures/dummy.png",256);
	public final int SIZE;
	public int pixels[];
	private String path;                                        // 41 loading images and  transform it to pixels and store it in array
	
	public SpriteSheet(String path , int size){
		
		this.path=path;
		SIZE=size;
		pixels=new int [SIZE  * SIZE];
		load();
	}
	
	private void load (){
		
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w=image.getWidth();
			int h=image.getHeight();
			image.getRGB(0, 0, w, h,pixels, 0, w);
		} catch (IOException e) {
			System.out.println("error");
		}
	}
	
}
