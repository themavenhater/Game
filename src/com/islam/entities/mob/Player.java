package com.islam.entities.mob;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;
import com.islam.game.input.Keyboard;

public class Player extends Mob {                                         //53 creating our Player

	private Keyboard input;
	private Sprite sprite;
	public int anim= 0 ;
	public boolean walking = false ;
	
	
	public Player (Keyboard input){
		this.input=input;
	}
	
	
	public Player(int x , int y,Keyboard input ){                       // to spawn in specific location
    this.x=x;
    this.y=y;
    this.input=input;
	}
	
	public void update (){                                           // update inputs
		
		int xa =0 ; int ya =0;
		 if (anim <75000 ) anim++;
		 else anim =0;
		if (input.up)ya--;
		if (input.down)ya++;
		if (input.left)xa--;
		if (input.right)xa++;
		
		if ( xa !=0 || ya != 0){
			move(xa,ya);                                  //animate the player
			walking = true;
		}else walking = false;
		
		
			
		
	}
	
	boolean fired= true;                          // to fire only one time 
	
	public void renderp (Screen screen){
		
	  // if (px>!=x)fired=false;
	 
	   if (fired) {
	  
		int currentdir = 0;
		
		if (input.space){ 	
		if (dir == 0) currentdir=0;
		if (dir == 1) currentdir=1;
		if (dir == 2) currentdir=2;
		if (dir == 3) currentdir=3;
		shoot(x-8 , y , currentdir);
		fired=false;
		}
		
		
		}
	}
	
	
	

	public void render (Screen screen){
		
		if (dir == 0){
			sprite=sprite.player_forward;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.player_forward_1;
				} else sprite=sprite.player_forward_2;
			}
		}
		
		else if (dir == 1){                         //right
			sprite=sprite.player_right;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.player_right_1;
				} else sprite=sprite.player_right_2;  
			}
		}
		
		else if (dir == 2){                         //backward
			sprite=sprite.player_back;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.player_back_1;
				} else sprite=sprite.player_back_2;  
			}
		}
		
		else if (dir == 3){                          //left
			sprite=sprite.player_left;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.player_left_1;
				} else sprite=sprite.player_left_2;  
			}
		}
		
		screen.renderMob(x -16 , y -16, sprite);                              // - 16 to center our player
		
	}


	public void render2(Screen screen) {
	}
}
