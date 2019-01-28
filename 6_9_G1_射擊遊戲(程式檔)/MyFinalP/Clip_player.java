 

import java.util.ArrayList;

public class Clip_player extends Clip{
	//private ArrayList<Bullet_Player> bullet_list = new ArrayList<Bullet_Player>();
	Clip_player(){
		bullet_list = new ArrayList<Bullet>();
		bullet_list_MAX=100;
		bullet_number=bullet_list_MAX;
		for(int i=0;i<bullet_list_MAX;i++){
			
			bullet_list.add(new Bullet_Player());
			
			bullet_list.get(i).getItemState().setDirectionY(Direction.UP);
		}
		
		
	}
	/*
	public ArrayList<Bullet_Player> get_bullet_list(){
		return bullet_list;
	}
	*/
}
