package com.islam.levels;


import com.islam.entities.Entity;
import com.islam.entities.projectile.Projectile;
import com.islam.game.Screen;
import com.islam.levels.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class Level {
	public static int[] tiles;                       // store level tiles " colors of the level.png"
	public static Level spawn = new SpawnLevel("/textures/spawn.png");
	// level class organize which tile need to be rendered
	protected int width , height;
	protected int tilesint[];
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();


	public Level() {           //44 load level from text file
		tiles = new int[550];
		loadLevel();
		
	}

	public Level(int width, int height) {
	}


	protected void loadLevel() {
		
		
	}


	protected void generateLevel (){                                                        // random levels
		
		
	}
	
	public void update(){                                                                // updating entties , positions ...etc
		
		for (int i=0; i<entities.size();i++){
			
		entities.get(i).update();
	}
		
		 for (int i=0; i<projectiles.size();i++){
				
				projectiles.get(i).update();
			}
		}
	
	public List <Projectile> getProjectiles(){
		return projectiles;
	}
	
	public void time (){
		
	}
	
	public boolean tileCollision(int x , int y ,int xa , int ya, int size){                      //x and y the position of the entity
		
		boolean solid=false;
		
		for (int c = 0 ; c<10 ; c++){
		    int xt = ((x+xa) + c %  2* size / 16 +10)/16 ;
			int yt = ((y+ya) + c % 2*  size /16 +10 )/16;
			if (getTile(xt,yt).solid()) solid = true;    // if the next place where we will be is solid make solid = true
		}
		
		return solid ;
	}
	
	
	public void render (int xScroll , int yScroll, Screen screen){
		screen.setOffset(xScroll,yScroll);                                                                           //48 detecting the corner ins , the surface that must be rendered in the screen
		int x0 = xScroll >> 4;
		int x1 = (xScroll +screen.width+ 16)>>4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll +screen.height + 16)>>4;
		
		for(int y= y0 ; y < y1;y++){
			for (int x = x0 ; x < x1;x++){
				
				getTile(x,y).render(x, y, screen);               //  get the tile and render it 
				
		}}
		
		for (int i=0; i<entities.size();i++){
			
			entities.get(i).render(screen);
		}
		
        for (int i=0; i<projectiles.size();i++){
			
			projectiles.get(i).render(screen);
		}
	}
	       
	public void add (Entity e ){
		entities.add(e);
		
	}
	
	public void addProjectile(Projectile p){
		p.init(this);
		projectiles.add(p);
		
	}
	
	// blackland = 000000 , brown land = 7F3300 , skull 0C00FF , black rock= 404040  , grassrock 007F46;
	
	
	public Tile getTile (int x , int y){


		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;  // fixing out of bound exception
		if (tiles [x+y * width]==Tile.col_spawn_blackland)  return Tile.spawn_blackland;                                  // 49 get a tile to be rendered
		if (tiles [x+y * width]==Tile.col_spawn_blackrock) return Tile.spawn_blackrock;
		if (tiles [x+y * width]==Tile.col_spawn_brownland) return Tile.spawn_brownland;
		if (tiles [x+y * width]==Tile.col_spawn_grassrock) return Tile.spawn_grassrock;
		if (tiles [x+y * width]==Tile.col_spawn_skull) return Tile.spawn_skull;
		return Tile.voidTile;
		
	}


}
