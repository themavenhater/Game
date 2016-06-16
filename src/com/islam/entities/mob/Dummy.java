package com.islam.entities.mob;

import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;
import com.islam.levels.Level;



public class Dummy extends  Mob {
	

	private int time;
	private int xa =1 ; private int ya =0;
	public boolean walking = false ;
	 int anim=0;
		public Dummy (int x , int y , Level level){
		this.x = x<< 4;
		this.y = x<< 4;
       sprite=Sprite.dummy_left;
      
       init(level);
      
	}
	
	
	public void update() {
		time++;
		
		 if (time % 60 ==0 ){
	    	  xa=random.nextInt(3)-1;
	       }
		
		if (anim <75000 ) anim++;
	         
	      
		
		if ( xa !=0 || ya != 0){
			move(xa,ya);                                  //animate the player
			walking = true;
		}else walking = false;
		
	}

	
	public void render(Screen screen) {
		if (dir == 0){
			sprite=sprite.dummy_forward;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_forward_1;
				} else sprite=sprite.dummy_forward_2;
			}
		}
		
		else if (dir == 1){                         //right
			sprite=sprite.dummy_right;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_right_1;
				} else sprite=sprite.dummy_right_2;  
			}
		}
		
		else if (dir == 2){                         //backward
			sprite=sprite.dummy_back;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_back_1;
				} else sprite=sprite.dummy_back_2;  
			}
		}
		
		else if (dir == 3){                          //left
			sprite=sprite.dummy_left;
			if (walking ){
				if (anim % 20 >10){
					sprite=sprite.dummy_left_1;
				} else sprite=sprite.dummy_left_2;  
			}
		}
		
		screen.renderMob(x-16, y-16, sprite);
	}


}