 

import java.util.ArrayList;

public class Stage {
	protected double shoot_life=1;
	protected boolean Move_S_Stage_lock=true;
	protected boolean Straight_Stage_lock=true;
	protected boolean Straight_s_Stage_lock=true;
	protected boolean Move_U_Stage_Stage_lock=true;
	protected boolean Enemy_top_lock=true;
	protected boolean Enemy_position_s_Stage_lock=true;


	protected double Move_S_Stage_count=0.0;
	protected double Move_S_Stage_dirchange=1.0;
	protected int    Move_S_Stage_enemy_num=8;
	protected int    Move_S_Stage_section=2;
	

	protected double Straight_Stage_count=0.0;
	protected double Straight_Stage_dirchange=1.0;
	protected int    Straight_Stage_enemy_num=8;
	
	protected double Straight_s_Stage_count=0.0;
	protected double Straight_s_Stage_dirchange=1.0;
	protected int    Straight_s_Stage_enemy_num=8;
	
	
	protected double Move_U_Stage_count=0.0;
	protected double Move_U_Stage_dirchange=1.0;
	protected int    Move_U_Stage_enemy_num=8;
	
	protected double Enemy_top_count=0.0;
	protected double Enemy_top_dirchange=1.0;
	protected int    Enemy_top_num=8;
	
	protected double Enemy_position_s_Stage_count=0.0;
	protected double Enemy_position_s_Stage_Stage_dirchange=1.0;
	protected int    Enemy_position_s_Stage_enemy_num=8;
	
	//敵人 (Enemy_Normal)
		public ArrayList<Enemy_normal> enemy_Normal_list = new ArrayList<Enemy_normal>();
		public int enemy_Normal_list_num;
		//敵人 (Enemy_Rocket)
		public ArrayList<Enemy_Rocket> enemy_Rocket_list = new ArrayList<Enemy_Rocket>();
		public int enemy_Rocket_list_num;
		//敵人 (Enemy_Rocket)
		public ArrayList<Enemy_smile_face> enemy_smile_list = new ArrayList<Enemy_smile_face>();
		public int enemy_smile_list_num;
		//大魔王
		public Boss Boss;
		public Boss2 Boss2;
		public ArrayList<Item> Item_list = new ArrayList<Item>();
		public int Item_list_Max;
		
		public Flying_type flying_type;
		public AImanage aimanage;
		public Player player;
	public Stage(AImanage ai,Flying_type ft,Player p,ArrayList<Enemy_normal> enl,ArrayList<Enemy_Rocket> enr,ArrayList<Enemy_smile_face> ens,Boss boss){
		flying_type=ft;
		enemy_Normal_list=enl;
		enemy_Rocket_list=enr;
		enemy_smile_list=ens;
		Boss=boss;
		enemy_Normal_list_num=enl.size();
		enemy_Rocket_list_num=enr.size();
		enemy_smile_list_num=ens.size();
		aimanage=ai;
		player=p;
	}
	public Stage(AImanage ai,Flying_type ft,Player p,ArrayList<Enemy_normal> enl,ArrayList<Enemy_Rocket> enr,ArrayList<Enemy_smile_face> ens,Boss2 boss){
		flying_type=ft;
		enemy_Normal_list=enl;
		enemy_Rocket_list=enr;
		enemy_smile_list=ens;
		Boss2=boss;
		enemy_Normal_list_num=enl.size();
		enemy_Rocket_list_num=enr.size();
		enemy_smile_list_num=ens.size();
		aimanage=ai;
		player=p;
		
	}
	public double Shoot_life(){
		switch(player.getItemState().getShootlevel()){
			case 1:shoot_life=1.0;break;
			case 2:shoot_life=1.5;break;
			case 3:shoot_life=1.8;break;
			case 4:shoot_life=2.3;break;
			case 5:shoot_life=2.5;break;
		}
		return shoot_life;
	}
	public double Boss_life_plus(){
		switch(player.getItemState().getShootlevel()){
			case 1:shoot_life=0.8;break;
			case 2:shoot_life=1.0;break;
			case 3:shoot_life=1.2;break;
			case 4:shoot_life=1.5;break;
			case 5:shoot_life=1.6;break;
		}
		return shoot_life;
	}
	public boolean Every_enemy_prepare(String tag){
		boolean check=false;
		switch(tag){
			case "Boss_2":
				Model m2=Boss2.getItemState();
				m2.set_current_state("Nothing");
				m2.set_move_offset(5);
				m2.set_shoot_speed(4);
				m2.setLife((int)(Boss2.BOSS2_LIFE*Boss_life_plus()));
				Boss2.BOSS2_LIFE=(int)(Boss2.BOSS2_LIFE*Boss_life_plus());

				m2.setArea_X(View.PAINT_WIDTH/2-Boss2.getItemState().get_W()/2);
				m2.setArea_Y(-260);
				check=true;
				for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
					for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
								Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(15);							
								Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().setAction_CD(0.0);						

					}
				}
				break;
			case "Boss_1":
				Model m1=Boss.getItemState();
				m1.set_current_state("Nothing");
				m1.set_move_offset(5);
				m1.set_shoot_speed(4);
				m1.setLife((int)(Boss.BOSS1_LIFE*Boss_life_plus()));
				Boss.BOSS1_LIFE=(int)(Boss.BOSS1_LIFE*Boss_life_plus());

				m1.setArea_X(220);
				m1.setArea_Y(-260);
				check=true;
				break;
			case "Enemy_top":
				if(Enemy_top_lock){
					Enemy_top_count=0;
					for(int q=0;q<Enemy_top_num;q++){
						if(enemy_smile_list.get(q).getItemState().getBoom().getItemState().getAction_CD()<Boom.BOOM_ACTION){
							
						}else{
							enemy_smile_list.get(q).getItemState().getBoom().getItemState().setAction_CD(0.0);
							enemy_smile_list.get(q).getItemState().getBoom().getItemState().setTresure_chance(0.0);
						
						}
						enemy_smile_list.get(q).getItemState().set_current_state("Nothing");
						enemy_smile_list.get(q).getItemState().setLife((int)(Enemy_smile_face.SMILE_LIFE*Shoot_life()));
						enemy_smile_list.get(q).getItemState().set_move_offset(5);
						enemy_smile_list.get(q).getItemState().set_shoot_speed(Math.random()*300+50);
						enemy_smile_list.get(q).getItemState().setAngle(180);
						enemy_smile_list.get(q).getItemState().setAction_CD(0.0);
						for(int i=0;i<enemy_smile_list.get(q).getItemState().getItemlist().size();i++){
							enemy_smile_list.get(q).getItemState().getItemlist().get(i).getItemState().setTresure_chance(0.0);
						}
						if(q%3==0){
							enemy_smile_list.get(q).getItemState().setArea_X(-60);
						}else if(q%3==1){
							enemy_smile_list.get(q).getItemState().setArea_X(View.CONTROL_WIDTH);
						}else if(q%3==2){
							enemy_smile_list.get(q).getItemState().setArea_X(250);

						}
						enemy_smile_list.get(q).getItemState().setArea_Y(-Math.random()*90-60);
					}
					double create_random=((int)(Math.random()*10))>4?0:1;
					if(create_random==0){
						double rand =Math.random();
						double item = Math.random();
						int item_ind=((int)(item*10))%2==0?1:0;
						
						int index_r=(int)(rand*Enemy_top_num);
						enemy_smile_list.get(index_r).getItemState().getItemlist().get(item_ind).getItemState().setTresure_chance(1.0);
					}
					check=true;
				}
				break;
			case "Enemy_pos_s":
				if(Enemy_position_s_Stage_lock){
					Enemy_position_s_Stage_count=0;
					for(int q=Enemy_top_num;q<Enemy_top_num+Enemy_position_s_Stage_enemy_num;q++){
						if(enemy_smile_list.get(q).getItemState().getBoom().getItemState().getAction_CD()<Boom.BOOM_ACTION){
						}else{
							enemy_smile_list.get(q).getItemState().getBoom().getItemState().setAction_CD(0.0);
							enemy_smile_list.get(q).getItemState().getBoom().getItemState().setTresure_chance(0.0);
						
						}
						enemy_smile_list.get(q).getItemState().set_current_state("Nothing");
						enemy_smile_list.get(q).getItemState().setLife((int)(Enemy_smile_face.SMILE_LIFE*Shoot_life()));
						enemy_smile_list.get(q).getItemState().set_move_offset(5);
						enemy_smile_list.get(q).getItemState().set_shoot_speed(15);
						for(int i=0;i<enemy_smile_list.get(q).getItemState().getItemlist().size();i++){
							enemy_smile_list.get(q).getItemState().getItemlist().get(i).getItemState().setTresure_chance(0.0);
						}
						if(q<Enemy_top_num+4){
							enemy_smile_list.get(q).getItemState().setArea_X(-(q-Enemy_top_num)*45+300-enemy_smile_list.get(q).getItemState().get_W()/2);
							enemy_smile_list.get(q).getItemState().setDirection_DX(1.0);
						}else{
							enemy_smile_list.get(q).getItemState().setArea_X(((q-Enemy_top_num)-4)*45+300-enemy_smile_list.get(q).getItemState().get_W()/2);
							enemy_smile_list.get(q).getItemState().setDirection_DX(-1.0);

						}
						if(q%2==0){
							enemy_smile_list.get(q).getItemState().setArea_Y(-150);

						}else{
							enemy_smile_list.get(q).getItemState().setArea_Y(-100);

						}
						enemy_smile_list.get(q).getItemState().setDirection_DY(1.0);
						enemy_smile_list.get(q).getItemState().setAngle(180);
						enemy_smile_list.get(q).getItemState().setAction_CD(0.0);
					}
					double create_random=((int)(Math.random()*10))>4?0:1;
					if(create_random==0){
					double rand =Math.random();
					double item = Math.random();
					int item_ind=((int)(item*10))%2==0?1:0;
					int index_r=(int)(rand*Enemy_top_num);
					enemy_smile_list.get(Enemy_top_num+index_r).getItemState().getItemlist().get(1).getItemState().setTresure_chance(1.0);
					}
					check=true;
				}
				break;
			case "Straight_s":
				if(Straight_s_Stage_lock){
					Straight_s_Stage_count=0;
					for(int q=0;q<Straight_s_Stage_enemy_num;q++){
						if(enemy_Rocket_list.get(q).getItemState().getBoom().getItemState().getAction_CD()<Boom.BOOM_ACTION){
							
						}else{
							enemy_Rocket_list.get(q).getItemState().getBoom().getItemState().setAction_CD(0.0);
							enemy_Rocket_list.get(q).getItemState().getBoom().getItemState().setTresure_chance(0.0);
						
						}
						enemy_Rocket_list.get(q).getItemState().set_current_state("Nothing");
						enemy_Rocket_list.get(q).getItemState().setLife((int)(Enemy_Rocket.ROCKET_LIFE*Shoot_life()));
						enemy_Rocket_list.get(q).getItemState().set_move_offset(1);
						enemy_Rocket_list.get(q).getItemState().set_shoot_speed(Math.random()*300+50);
						enemy_Rocket_list.get(q).getItemState().setAngle(180);
						enemy_Rocket_list.get(q).getItemState().setAction_CD(0.0);
						for(int i=0;i<enemy_Rocket_list.get(q).getItemState().getItemlist().size();i++){
							enemy_Rocket_list.get(q).getItemState().getItemlist().get(i).getItemState().setTresure_chance(0.0);
						}
						enemy_Rocket_list.get(q).getItemState().setArea_X(250);
						enemy_Rocket_list.get(q).getItemState().setArea_Y(-100);
					}
					double create_random=((int)(Math.random()*10))>4?0:1;
					if(create_random==0){
						double rand =Math.random();
						double item = Math.random();
						int item_ind=((int)(item*10))%2==0?1:0;
						
						int index_r=(int)(rand*Enemy_top_num);
						enemy_Rocket_list.get(index_r).getItemState().getItemlist().get(item_ind).getItemState().setTresure_chance(1.0);
					}
					check=true;
				}
				break;
			case "Straight":
				if(Straight_Stage_lock){
					Straight_Stage_count=0;
					for(int q=Straight_s_Stage_enemy_num;q<Straight_s_Stage_enemy_num+Straight_Stage_enemy_num;q++){
						if(enemy_Rocket_list.get(q).getItemState().getBoom().getItemState().getAction_CD()<Boom.BOOM_ACTION){
							
						}else{
							enemy_Rocket_list.get(q).getItemState().getBoom().getItemState().setAction_CD(0.0);
							enemy_Rocket_list.get(q).getItemState().getBoom().getItemState().setTresure_chance(0.0);
						
						}
						enemy_Rocket_list.get(q).getItemState().set_current_state("Nothing");
						enemy_Rocket_list.get(q).getItemState().setLife((int)(Enemy_Rocket.ROCKET_LIFE*Shoot_life()));
						enemy_Rocket_list.get(q).getItemState().set_move_offset(2);
						enemy_Rocket_list.get(q).getItemState().set_shoot_speed(200);
						enemy_Rocket_list.get(q).getItemState().setAngle(180);
						for(int i=0;i<enemy_Rocket_list.get(q).getItemState().getItemlist().size();i++){
							enemy_Rocket_list.get(q).getItemState().getItemlist().get(i).getItemState().setTresure_chance(0.0);
						}
						if(q%4==0){
							enemy_Rocket_list.get(q).getItemState().setArea_X(50);
						}else if(q%4==1){
							enemy_Rocket_list.get(q).getItemState().setArea_X(200);
						}else if(q%4==2){
							enemy_Rocket_list.get(q).getItemState().setArea_X(350);

						}else if(q%4==3){
							enemy_Rocket_list.get(q).getItemState().setArea_X(500);
						}
						
							enemy_Rocket_list.get(q).getItemState().setArea_Y(-160);
							//enemy_Rocket_list.get(q).getItemState().setArea_X(q*enemy_Rocket_list.get(q).getItemState().get_W()*0.75);
						//enemy_Rocket_list.get(q).getItemState().setArea_Y(-Math.random()*300-100);
					}
					double create_random=((int)(Math.random()*10))>4?0:1;
						if(create_random==0){
						double rand =Math.random();
						double item = Math.random();
						int item_ind=((int)(item*10))%2==0?1:0;
						
						int index_r=(int)(rand*Enemy_top_num);
						enemy_Rocket_list.get(Straight_s_Stage_enemy_num+index_r).getItemState().getItemlist().get(item_ind).getItemState().setTresure_chance(1.0);
					}
					check=true;
				}
				break;
			case "Move_S":
				if(Move_S_Stage_lock){
					Move_S_Stage_count=0.0;
					if(Math.random()<0.5){
						Move_S_Stage_dirchange=1.0;
					}else{
						Move_S_Stage_dirchange=-1.0;

					}
					
					for(int q=0;q<Move_S_Stage_enemy_num;q++){
						if(enemy_Normal_list.get(q).getItemState().getBoom().getItemState().getAction_CD()<Boom.BOOM_ACTION){
						
						}else{
							enemy_Normal_list.get(q).getItemState().getBoom().getItemState().setAction_CD(0.0);
							enemy_Normal_list.get(q).getItemState().getBoom().getItemState().setTresure_chance(0.0);
						
						}
				

						enemy_Normal_list.get(q).getItemState().set_current_state("Nothing");
						enemy_Normal_list.get(q).getItemState().setAction_CD(0.0);
						enemy_Normal_list.get(q).getItemState().setLife((int)(Enemy_normal.NORMAL_LIFE*Shoot_life()));
						enemy_Normal_list.get(q).getItemState().set_move_offset(5);
						enemy_Normal_list.get(q).getItemState().set_shoot_speed(Math.random()*600+100);
						for(int i=0;i<enemy_Normal_list.get(q).getItemState().getItemlist().size();i++){
							enemy_Normal_list.get(q).getItemState().getItemlist().get(i).getItemState().setTresure_chance(0.0);
						}
						if(Move_S_Stage_dirchange==1.0){
							enemy_Normal_list.get(q).getItemState().setAngle(45);
							enemy_Normal_list.get(q).getItemState().setArea_X(700);
							enemy_Normal_list.get(q).getItemState().setArea_Y(300);
						}else{
							enemy_Normal_list.get(q).getItemState().setAngle(315);
							enemy_Normal_list.get(q).getItemState().setArea_X(-100);
							enemy_Normal_list.get(q).getItemState().setArea_Y(300);
						}
						
					}
					double create_random=((int)(Math.random()*10))>4?0:1;
						if(create_random==0){
						double rand =Math.random();
						double item = Math.random();
						int item_ind=((int)(item*10))%2==0?1:0;
						
						int index_r=(int)(rand*Enemy_top_num);
						enemy_Normal_list.get(index_r).getItemState().getItemlist().get(item_ind).getItemState().setTresure_chance(1.0);
					}
					check=true;
				}
				break;
			case "Move_U":
				
				if(Move_U_Stage_Stage_lock){
					Move_U_Stage_count=0.0;
					Move_U_Stage_dirchange=1.0;
					double randomX=Math.random()*100+220;
					for(int q=Move_S_Stage_enemy_num;q<Move_S_Stage_enemy_num+Move_U_Stage_enemy_num;q++){
						if(enemy_Normal_list.get(q).getItemState().getBoom().getItemState().getAction_CD()<Boom.BOOM_ACTION){
							
						}else{
							enemy_Normal_list.get(q).getItemState().getBoom().getItemState().setAction_CD(0.0);
							enemy_Normal_list.get(q).getItemState().getBoom().getItemState().setTresure_chance(0.0);
						
						}
						enemy_Normal_list.get(q).getItemState().set_current_state("Nothing");
						enemy_Normal_list.get(q).getItemState().setAction_CD(0.0);
						enemy_Normal_list.get(q).getItemState().setLife((int)(Enemy_normal.NORMAL_LIFE*Shoot_life()));
						enemy_Normal_list.get(q).getItemState().setAngle(180);
						enemy_Normal_list.get(q).getItemState().set_shoot_speed(Math.random()*600+100);
						for(int i=0;i<enemy_Normal_list.get(q).getItemState().getItemlist().size();i++){
							enemy_Normal_list.get(q).getItemState().getItemlist().get(i).getItemState().setTresure_chance(0.0);
						}
						enemy_Normal_list.get(q).getItemState().set_move_offset(5);
						enemy_Normal_list.get(q).getItemState().setArea_Y(-100);
						if(q%2==0){
							
							enemy_Normal_list.get(q).getItemState().setArea_X(randomX);
						}else{
							enemy_Normal_list.get(q).getItemState().setArea_X(randomX+100);
						}
					}
					double create_random=((int)(Math.random()*10))>4?0:1;
						if(create_random==0){
						double rand =Math.random();
						double item = Math.random();
						int item_ind=((int)(item*10))%2==0?1:0;
						
						int index_r=(int)(rand*Enemy_top_num);
						enemy_Normal_list.get(Move_S_Stage_enemy_num+index_r).getItemState().getItemlist().get(item_ind).getItemState().setTresure_chance(1.0);
					}
					check=true;
				}
				break;
			
		}
		return check;
}
	public boolean Enemytoplayer_Stage(){
		boolean check=true;
		
		for(int q=0;q<Enemy_top_num;q++){
			
			if(enemy_smile_list.get(q).getItemState().get_Y()<View.PAINT_HEIGHT
			   && enemy_smile_list.get(q).getItemState().get_Y()>-150	
			   && enemy_smile_list.get(q).getItemState().get_X()<View.PAINT_WIDTH
			   && enemy_smile_list.get(q).getItemState().get_X()>-150	
					){
				if(enemy_smile_list.get(q).getItemState().get_current_state()!="Died"){
					
					check=false;
				}
			}
					
				if(enemy_smile_list.get(q).getItemState().getAction_CD()<40.0+q*20.0){
					if(enemy_smile_list.get(q).getItemState().get_X()>player.getItemState().get_X()-20
						&&
						enemy_smile_list.get(q).getItemState().get_X()<player.getItemState().get_X()+player.getItemState().get_W()+20
						
							){
						
						enemy_smile_list.get(q).getItemState().setAction_CD(40.0+q*20.0);
					}else{
					aimanage.Dynamic_look(enemy_smile_list.get(q),player);
					enemy_smile_list.get(q).getItemState().setAction_CD(enemy_smile_list.get(q).getItemState().getAction_CD()+0.1);
					}
				}
			if(Enemy_top_count> q*20){
				aimanage.Enemy_Move_face(enemy_smile_list.get(q));
			}
		}
		Enemy_top_count++;
		return check;
	}
	
	public boolean Enemy_position_s_Stage(){
		boolean check=true;
		for(int q=Enemy_top_num;q<Enemy_top_num+Enemy_position_s_Stage_enemy_num;q++){
			if(enemy_smile_list.get(q).getItemState().get_Y()<View.PAINT_HEIGHT
					   && enemy_smile_list.get(q).getItemState().get_Y()>-150	
					   && enemy_smile_list.get(q).getItemState().get_X()<View.PAINT_WIDTH
					   && enemy_smile_list.get(q).getItemState().get_X()>-150	
							){
						if(enemy_smile_list.get(q).getItemState().get_current_state()!="Died"){
							
							check=false;
						}
					}
			
			if(q%2==0){
				if(Enemy_position_s_Stage_count<6.0){
					aimanage.Enemy_Move_down(enemy_smile_list.get(q));
					enemy_smile_list.get(q).getItemState().setAddspeed(3.0);
				}
				else if(Enemy_position_s_Stage_count>=6.0 && Enemy_position_s_Stage_count<21.0)
				{
					aimanage.Enemy_Move_down(enemy_smile_list.get(q));
					enemy_smile_list.get(q).getItemState().setAddspeed(1.5);
				}else if(Enemy_position_s_Stage_count>=21.0 && Enemy_position_s_Stage_count<=30.0){
					aimanage.Enemy_Move_down(enemy_smile_list.get(q));
					enemy_smile_list.get(q).getItemState().setAddspeed(1.2);
				
				}
				else
				{
					enemy_smile_list.get(q).getItemState().setAddspeed(1.0);
					aimanage.Enemy_action_pause_regular_shoot(enemy_smile_list.get(q), 135,player);
					aimanage.Enemy_Move_all(enemy_smile_list.get(q));
					//aimanage.Dynamic_look(enemy_smile_list.get(q), player);
				}
			}else{
				if(Enemy_position_s_Stage_count<15.0){
					aimanage.Enemy_Move_down(enemy_smile_list.get(q));
					enemy_smile_list.get(q).getItemState().setAddspeed(3.0);
				}
				else if(Enemy_position_s_Stage_count>=15.0 && Enemy_position_s_Stage_count<30.0)
				{
					aimanage.Enemy_Move_down(enemy_smile_list.get(q));
					enemy_smile_list.get(q).getItemState().setAddspeed(1.5);
				}else if(Enemy_position_s_Stage_count>=30.0 && Enemy_position_s_Stage_count<=40.0){
					aimanage.Enemy_Move_down(enemy_smile_list.get(q));
					enemy_smile_list.get(q).getItemState().setAddspeed(1.2);
				
				}
				else
				{
					enemy_smile_list.get(q).getItemState().setAddspeed(1.0);
					aimanage.Enemy_action_pause_regular_shoot(enemy_smile_list.get(q), 135,player);
					aimanage.Enemy_Move_all(enemy_smile_list.get(q));
					//aimanage.Dynamic_look(enemy_smile_list.get(q), player);
				}
			}
			
		}
		Enemy_position_s_Stage_count++;
		return check;
	}
	public boolean Straight_s_Stage(){
		boolean check=true;
		
		
		for(int q=0;q<Straight_s_Stage_enemy_num;q++){
			if(enemy_Rocket_list.get(q).getItemState().get_Y()<View.PAINT_HEIGHT){
				if(enemy_Rocket_list.get(q).getItemState().get_current_state()!="Died"){
					
					check=false;
				}
			}
			if(Straight_s_Stage_count> q*10){
			flying_type.Enemy_fast_LR_move(enemy_Rocket_list.get(q));
			aimanage.Enemy_Move_down(enemy_Rocket_list.get(q));
			}
		}
		
		Straight_s_Stage_count++;
		
		return check;
	}
	public boolean Straight_Stage(){
		
		boolean check=true;
		int back=0;
		
		for(int q=Straight_s_Stage_enemy_num;q<Straight_s_Stage_enemy_num+Straight_Stage_enemy_num;q++){
				if(enemy_Rocket_list.get(q).getItemState().get_Y()<View.PAINT_HEIGHT){
					if(enemy_Rocket_list.get(q).getItemState().get_current_state()!="Died"){
						
						check=false;
					}
				}
				
				if(q%4==0){
					back++;
				}
					if(q%4==0 || q%4==3){
						if(Straight_Stage_count> 50.0+(back-1)*40){
							aimanage.Enemy_Move_down(enemy_Rocket_list.get(q));
							flying_type.Enemy_slow_LR_move(enemy_Rocket_list.get(q));
						}
					}else{
						if(Straight_Stage_count> 10.0+(back-1)*40){
							aimanage.Enemy_Move_down(enemy_Rocket_list.get(q));
							flying_type.Enemy_slow_LR_move(enemy_Rocket_list.get(q));
						}
					}
					
				
				
				if(Straight_Stage_count<10.0){
					//aimanage.add_speed(enemy_Rocket_list.get(q), 0.5);
				}
			}
		Straight_Stage_count++;

		return check;
	}
	public boolean Move_S_Stage(){
		boolean check=true;
		for(int q=0;q<Move_S_Stage_enemy_num;q++){
			if(Move_S_Stage_dirchange==1.0){
				if(enemy_Normal_list.get(q).getItemState().get_X()>-150){
					if(enemy_Normal_list.get(q).getItemState().get_current_state()!="Died"){
						check=false;
					}
				}
			}else{
				if(enemy_Normal_list.get(q).getItemState().get_X()<700){
					if(enemy_Normal_list.get(q).getItemState().get_current_state()!="Died"){
						check=false;
					}
				}
				
			}
			if(Move_S_Stage_count>(q+1)*20){

				flying_type.Enemy_ss_move_special((enemy_Normal_list.get(q)),44.0,Move_S_Stage_dirchange);
			}
		}
		if(Move_S_Stage_count>480.0 && Move_S_Stage_count<482.0){
			if(Move_S_Stage_dirchange==1.0){
				Move_S_Stage_dirchange=-1.0;
			}else{
				Move_S_Stage_dirchange=1.0;
			}
			for(int c=0;c<Move_S_Stage_enemy_num;c++){
				if(Move_S_Stage_dirchange==-1.0){
					enemy_Normal_list.get(c).getItemState().setAngle(315);
					enemy_Normal_list.get(c).getItemState().setArea_X(-100);
				}else{
					enemy_Normal_list.get(c).getItemState().setAngle(45);
					enemy_Normal_list.get(c).getItemState().setArea_X(700);
				}
				aimanage.Enemy_state_clear(enemy_Normal_list.get(c));
				enemy_Normal_list.get(c).getItemState().setArea_Y(300);
			}
			Move_S_Stage_count=0.0;
			
		}
		
		Move_S_Stage_count++;
		return check;
	}
	public boolean Move_U_Stage(int circular){
		boolean check=true;

		for(int q=Move_S_Stage_enemy_num;q<Move_S_Stage_enemy_num+Move_U_Stage_enemy_num;q+=2){
			if(Move_U_Stage_count>q*10){
				flying_type.Enemy_U_move((enemy_Normal_list.get(q)),44.0,Move_U_Stage_dirchange,circular);
				flying_type.Enemy_U_move((enemy_Normal_list.get(q+1)),44.0,-1*Move_U_Stage_dirchange,circular);
			}
		}
		for(int q=Move_S_Stage_enemy_num;q<Move_S_Stage_enemy_num+Move_U_Stage_enemy_num;q++){
			if(enemy_Normal_list.get(q).getItemState().get_Y()>-200){
				if(enemy_Normal_list.get(q).getItemState().get_current_state()!="Died"){
					
					check=false;
				}
			}
		}
		Move_U_Stage_count++;
		return check;
	}
	
}
