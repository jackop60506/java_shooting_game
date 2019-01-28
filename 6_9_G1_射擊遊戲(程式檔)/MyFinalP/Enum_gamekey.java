 

import java.awt.event.KeyEvent;

public enum Enum_gamekey {

	START(KeyEvent.VK_ENTER),
	CLOSE(KeyEvent.VK_ESCAPE);
	private int key;
	private Enum_gamekey(int k){
		this.key=k;
	}
	public int getKey(){
		return key;
	}
}
