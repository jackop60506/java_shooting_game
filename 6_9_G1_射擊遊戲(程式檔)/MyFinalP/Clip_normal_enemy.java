 

import java.util.ArrayList;

public class Clip_normal_enemy extends Clip {
	//private ArrayList<Bullet_Normal_Enemy> bullet_list = new ArrayList<Bullet_Normal_Enemy>();
	Clip_normal_enemy(){
		bullet_list = new ArrayList<Bullet>();

		bullet_list_MAX=30;
		bullet_number=bullet_list_MAX;
		for(int i=0;i<bullet_list_MAX;i++){
			
			bullet_list.add(new Bullet_Normal_Enemy());
			
			bullet_list.get(i).getItemState().setDirectionY(Direction.UP);
		}
		
		
	}
	/*
	public ArrayList<Bullet_Normal_Enemy> get_bullet_list(){
		return bullet_list;
	}
	*/
}
