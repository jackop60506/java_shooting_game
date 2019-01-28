 

import java.util.ArrayList;

public class Clip_boss extends Clip {
		Clip_boss(int tag){
			bullet_list = new ArrayList<Bullet>();

			bullet_list_MAX=40;
			bullet_number=bullet_list_MAX;
			for(int i=0;i<bullet_list_MAX;i++){
				
				bullet_list.add(new Bullet_Boss(tag));
				
				bullet_list.get(i).getItemState().setDirectionY(Direction.UP);
			}
			
			
		}
		
}
