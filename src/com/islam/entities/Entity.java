package com.islam.entities;

import java.util.Random;

import com.islam.game.Screen;
import com.islam.levels.Level;

public  class Entity {

	
	
	
	public int x, y ;                                          // 51 creating entitis , abstract because it's a template 
	public boolean removed =false ;
	protected Level level ;
	protected final Random random = new Random();
	
	public  void update (){
		
	}
		
	
	
	public void render (Screen screen){
		
	}
	
	public void remove (){
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
		
	}
	
	public void init (Level level){
		this.level=level;
	}
	
}
