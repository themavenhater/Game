package com.islam.entities.projectile;

import com.islam.entities.Entity;
import com.islam.game.Screen;
import com.islam.game.graphics.Sprite;

public  class Projectile extends Entity {

	
	
 
 public Sprite sprite;
	protected int speed = 2;
 protected int dir=100 ;
 
 
	public Projectile(int x , int y , int dir ){
		
		sprite=Sprite.projectile;
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	
	
	public void render(Screen screen){
		
		screen.renderProjectileTile(x, y, this);
	}
	
	
	public void update(){
		 if (level.tileCollision(x, y, 2,  2, 8) && speed==2 ){
		    	speed = - 2;
  	   }
		 else if (level.tileCollision(x, y, 2, 2, 8) && speed==-2 ){
		    	speed = 2;
	   }
		move();
		
		 
	}
	
	
	protected void move(){

		if (dir==0) { System.out.println(dir);
	    	y += -speed ;
	    }
	
		if (dir==1) {
			x += speed ;
		}
		
		if (dir==2) {
			y += speed ;
		}
		
		if (dir==3) {
			x += -speed ;
		}

		System.out.println(speed);
	}

}

