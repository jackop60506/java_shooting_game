 

import java.awt.event.KeyEvent;

public enum Direction {
	UP(KeyEvent.VK_UP,0,-1),
	DOWN(KeyEvent.VK_DOWN,0,1),
	EAST(KeyEvent.VK_RIGHT,1,0),
	WEST(KeyEvent.VK_LEFT,-1,0);
	private int key;
	private int X;
	private int Y;
	
	private Direction(int k, int x,int y){
		this.key=k;
		this.X=x;
		this.Y=y;
	}
	public int getKey(){
		return key;
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	
}
