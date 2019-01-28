 

import java.util.ArrayList;

public class  Clip{
		protected int bullet_list_MAX;
		public int bullet_number;
		protected double bullet_speed_count=0;
		protected ArrayList<Bullet> bullet_list;
		public void reset_bullet(){
				bullet_number=bullet_list_MAX;
		}
		public void add_bullet(){
			
			if(bullet_number<=bullet_list_MAX){
				bullet_number++;
			}
		}
		public void get_bullet(){
			
			bullet_number--;
	}
		public boolean check_bullet(){
			if(bullet_number<=0){
				return false;
			}
				return true;
		}
		public void set_bullet_speed_count(double t){
			bullet_speed_count=t;
		}
		public double get_bullet_speed_count(){
			return bullet_speed_count;
		}
		public void set_bullet_list_MAX(int t){
			bullet_list_MAX=t;
		}
		public int get_bullet_list_MAX(){
			return bullet_list_MAX;
		}
		public ArrayList<Bullet> get_bullet_list(){
			return bullet_list;
		}
}
