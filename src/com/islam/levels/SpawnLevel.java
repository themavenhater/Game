package com.islam.levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.islam.entities.mob.Dummy;
import com.islam.entities.mob.Player;
import com.islam.game.input.Keyboard;

public class SpawnLevel extends Level{

	
	                                     // Store tiles in an array
	
	public SpawnLevel(String path) {
		super(path);
		
	}

	
  protected void loadLevel(String path) {
		
	  
	  try {
		BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));         // making new image to recover data from it with colors
		int h= height =image.getHeight();
		int w= width=image.getWidth();                                                          //!!!!!!!!!!! to be changed with sql
		tiles = new int [w*h];
		image.getRGB(0, 0, w, h, tiles, 0, w); 
	} catch (IOException e) {
		System.out.println("Can not find Level");
		
	}
		
	}
  protected void generateLevel(){
	  for (int i = 0; i < tiles.length ; i++){
		 
	  }
  }
}
