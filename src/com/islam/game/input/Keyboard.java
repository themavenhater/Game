package com.islam.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public boolean up, down, right, left, space;
	private   boolean keys[] = new boolean [120];
	private   boolean keysshoot[] = new boolean [120];
	
	public void update (){
		
		up= keys[KeyEvent.VK_UP];
		down= keys[KeyEvent.VK_DOWN];
		right= keys[KeyEvent.VK_RIGHT];
		left= keys[KeyEvent.VK_LEFT];
		space = keys[KeyEvent.VK_SPACE];
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()]=false;
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	
	
}
