package com.islam.levels.tile;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;

public class Flower extends Tile {

	public Flower(Sprite sprite) {
		super(sprite);
	 
	}
	
public void render (int x , int y , Screen screen){
		
		screen.renderTile(x<<4 , y<<4  , this);
		
	}

}
