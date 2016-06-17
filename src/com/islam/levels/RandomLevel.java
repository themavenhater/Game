package com.islam.levels;

import java.util.Random;

public class RandomLevel extends Level {
	
	public static final Random random = new Random();                    //46 setting the random method

	public RandomLevel() {
		super();
		
	}
	
	
	protected void generateLevel(){
		
		for (int y=0; y<height;y++){
			for (int x=0 ; x<width;x++){
				tilesint[x+y*width]=random.nextInt(4);
			}
		}
		
	}

}
