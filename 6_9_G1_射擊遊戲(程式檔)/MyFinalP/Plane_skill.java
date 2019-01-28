 

import java.awt.event.KeyEvent;

public enum Plane_skill {

	SHOOT(KeyEvent.VK_Z);
	
	private int key;
	private Plane_skill(int k){
		this.key=k;
	}
	public int getKey(){
		return key;
	}
}
