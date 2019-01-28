 

import java.util.ArrayList;

public class Stage_1 extends Stage{
	public 	boolean stage_check=false;


	private double Boss1_Stage_count=0.0;
	private double Boss1_sep_bullet=1.0;
	private double Boss_speedup=0.0;
	private double Boss_sep_shoot=0.0;
	private int Boss_skill_pick=0;
	private double Boss_skill_time=0.0;
	
	private int Boss_skill1_bullet_check=0;
	private int Boss_skill1_bullet_random_put=0;
	private boolean Boss_skill2_bullet_check=true;
	private double Boss_skill3_shoot_speed=16.0;
	private double Boss_skill3_shoot_addspeed=0.0;
	private double Boss_skill3_bullet_offset=0.0;
	private double Boss_skill3_bullet_addspeed=0.0;
	
	public static String stage_progress= "-013423443555*";
	//public static String stage_progress= "-2*";
	public static String stage_progress2="-101100100";
	//private static String stage_progress2="-00111111111111111";
	public static int stage_progress_next=1;
	private static int stage_progress_next2=1;

	public static boolean stage_run=false;
	public static boolean stage_prepare=false;
	public static boolean add_mutex=false;

	private static boolean stage_run2=false;
	private static boolean stage_prepare2=false;
	private static boolean add_mutex2=false;
	
	private static boolean still_run=true;
	public Stage_1 (AImanage ai,Flying_type ft,Player p,ArrayList<Enemy_normal> enl,ArrayList<Enemy_Rocket> enr,ArrayList<Enemy_smile_face> ens,Boss boss){
		super(ai,ft,p,enl,enr,ens,boss);
	}
	
	public Item Itemchoose(Enemy e,double tag){
		return null;
	}
	public void setProgress1(int a){
		 stage_progress_next=a;
		
	}
	public void setProgress2(int b){
		stage_progress_next2=b;
	}
	public boolean Boss1_Stage(){
		boolean check=true;
		Model model=Boss.getItemState();
		if(Boss1_Stage_count<80.0){
			
		}
		else if(Boss1_Stage_count<160.0){
			aimanage.Enemy_Move_down(Boss);
			Boss.CantAttack(false);
			Boss.Boss_CANATTACK=false;
		}
		else if(Boss1_Stage_count>=160.0 && Boss1_Stage_count<170.0 ){
			Boss.CantAttack(false);
			Boss.Boss_CANATTACK=false;
		}
		else if(Boss1_Stage_count>=170.0)
		{
			Boss.Boss_CANATTACK=true;
			//back to center if(aimanage.tosomewhere(Boss,Boss.getItemState().get_X(),Boss.getItemState().get_Y(),View.PAINT_WIDTH/2-Boss.getItemState().get_W()/2,View.PAINT_HEIGHT/2-Boss.getItemState().get_H()/2,8.0)){
			//back to front
			//move down speed      250.0 90.0
			/*60.0
			Boss_speedup+=0.055;
			aimanage.Enemy_Move_down(Boss);
			model.setAddspeed(Boss_speedup);
			*/
			// normal shooot 410

			if(Boss1_Stage_count>=170.0 && Boss1_Stage_count<410){
			
				
				//Boss.shoot(1, 180-(Boss1_Stage_count-170));
				//Boss.shoot(2, 180+(Boss1_Stage_count-170));
				
				/*
				Boss.getItemState().set_shoot_speed(1);
				if(Boss1_Stage_count<250.0){
				Boss.shoot(1, 180);
				Boss.shoot(2, 180);
				}else{
					Boss.shoot(1, 180-(Boss1_Stage_count-250)*2);
					Boss.shoot(2, 180+(Boss1_Stage_count-250)*2);
					
				}
				*/
				if(Boss_sep_shoot<21){
					Boss.shoot(player,0);

				}else if(Boss_sep_shoot>=21 && Boss_sep_shoot<60){
					
				}else if(Boss_sep_shoot>=60 && Boss_sep_shoot<81){
					Boss.shoot(player,1);
				}else if(Boss_sep_shoot>=81 && Boss_sep_shoot<120){
					
				}else{
					Boss_sep_shoot=0;
				}
				
				flying_type.Enemy_slow_LR_move(Boss);

				Boss_sep_shoot++;
				
				double skill_random_pick=Math.random();
				if(skill_random_pick<0.25){
					Boss_skill_pick=0;
				}else if(skill_random_pick>=0.25 && skill_random_pick<0.5){
					Boss_skill_pick=1;
				}else if(skill_random_pick>=0.5 && skill_random_pick<0.75){
					Boss_skill_pick=2;
				}else{
					Boss_skill_pick=3;
				}

				switch(Boss_skill_pick){
					case 0:
						Boss_skill_time=595.0;
						break;
					case 1:
						Boss_skill_time=550.0;
						break;
					case 2:
						Boss_skill_time=550.0;
						break;
					case 3:
						Boss_skill_time=653.33;
						break;
				}
			}// skill 410 start
			else if(Boss1_Stage_count>=410.0 && Boss1_Stage_count<Boss_skill_time){
				
				//second skill attack
				if(Boss_skill_pick==0){
					if(Boss1_Stage_count>=420 && Boss1_Stage_count<487.5){
						Boss.shoot(0,45+(Boss1_Stage_count-420)*4);
	
						Boss.getItemState().set_shoot_speed(4);
						/*
						Boss.shoot(player,2);
						Boss.getItemState().set_shoot_speed(3);
						aimanage.Dynamic_look(Boss, player);
						*/
					}
					if(Boss1_Stage_count>=507.5 && Boss1_Stage_count<575){
						Boss.shoot(0,315+(-(Boss1_Stage_count-507.5)*4));
						Boss.getItemState().set_shoot_speed(4);
					}
				}else if(Boss_skill_pick==1){
					
					if(Boss1_Stage_count>=410 && Boss1_Stage_count<420){
						int random=((int)(Math.random()*10));
						if(random%2==0){
							Boss_skill1_bullet_check=8;
						}else{
							Boss_skill1_bullet_check=82;
						}
					}else if(Boss1_Stage_count>=420 && Boss1_Stage_count<430){
						Boss.shoot(player,Boss_skill1_bullet_check);
						Boss.getItemState().set_shoot_speed(0.1);
						for(int i=0;i<Boss.getItemState().getClip_list().size();i++){
							for(int q=0;q<Boss.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
										Boss.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(0.5);							
							}
						}
					}
					if(Boss1_Stage_count>=430 && Boss1_Stage_count<480){
						Boss_speedup+=0.2;
						aimanage.Enemy_Move_down(Boss);
						model.setAddspeed(Boss_speedup);
					}
					else if(Boss1_Stage_count>=480 && Boss1_Stage_count<525){
							for(int i=0;i<Boss.getItemState().getClip_list().size();i++){
								for(int q=0;q<Boss.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
										if(Boss1_Stage_count>480+q*5){
											Boss.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(25);
										}
									
								}
							}
						model.setArea_X(220);
						model.setArea_Y(-250);
						Boss_speedup=0;
					}
				}else if(Boss_skill_pick==2){

					if(Boss1_Stage_count>=420 && Boss1_Stage_count<430){
						Boss.shoot(player,16);
						Boss.getItemState().set_shoot_speed(0.1);
						for(int i=0;i<Boss.getItemState().getClip_list().size();i++){
							for(int q=0;q<Boss.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
										Boss.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(0.5);							
							}
						}
					}
					if(Boss1_Stage_count>=430 && Boss1_Stage_count<500){
						Boss_speedup+=0.15;
						aimanage.Enemy_Move_down(Boss);
						model.setAddspeed(Boss_speedup);
					}
					else if(Boss1_Stage_count>=500 && Boss1_Stage_count<525){
							for(int i=0;i<Boss.getItemState().getClip_list().size();i++){
								for(int q=0;q<Boss.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
										if(Boss1_Stage_count>500+q*5){
											Boss.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(25);
										}
									
								}
							}
						model.setArea_X(220);
						model.setArea_Y(-250);
						Boss_speedup=0;
					}
				}else if(Boss_skill_pick==3){
					if(Boss.getItemState().get_shoot_speed()>0.5){
						//System.out.println(Boss.getItemState().get_shoot_speed());
						Boss.getItemState().set_shoot_speed(Boss_skill3_shoot_speed);
					}
					Boss_skill3_shoot_speed-=Boss_skill3_shoot_addspeed;
					Boss_skill3_shoot_addspeed+=0.005;
					
				
					Boss_skill3_bullet_offset+=Boss_skill3_bullet_addspeed;
					Boss_skill3_bullet_addspeed+=0.01;
					
					
					if(Boss1_Stage_count<500 && Boss1_Stage_count>=415){
						for(int i=0;i<Boss.getItemState().getClip_list().size();i++){
							//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
							for(int q=0;q<Boss.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
									Boss.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(Boss_skill3_bullet_offset);
							}		
						}
					}
					
					if(Boss1_Stage_count>=420 && Boss1_Stage_count<=520){
						Boss.shoot(1, 180);
						Boss.shoot(2, 180);
					}else if(Boss1_Stage_count>=520 && Boss1_Stage_count<633.3){
						Boss.shoot(1, 180-(Boss1_Stage_count-520)*1.5);
						Boss.shoot(2, 180+(Boss1_Stage_count-520)*1.5);
					}
				}
			}
			else if(Boss1_Stage_count>=Boss_skill_time){
				
				
				Boss_speedup+=0.4;
				if(aimanage.tosomewhere(Boss,Boss.getItemState().get_X(),Boss.getItemState().get_Y(),View.PAINT_WIDTH/2-Boss.getItemState().get_W()/2,140.0,Boss_speedup,true)){
					Boss1_Stage_count=170.0;
					Boss_speedup=0.0;
					Boss.getItemState().setDirection_DX(0.0);
					Boss.getItemState().setDirection_DY(0.0);
					Boss.getItemState().setAngle(180.0);
					Boss.getItemState().setAddspeed(1.0);
					Boss.getItemState().setAction_CD(0.0);
					Boss.getItemState().set_shoot_speed(4);
					Enemy_top_count=0;
					Boss_sep_shoot=0.0;
					Boss_skill3_shoot_speed=16.0;
					Boss_skill3_shoot_addspeed=0.0;
					Boss_skill3_bullet_offset=0.0;
					Boss_skill3_bullet_addspeed=0.0;
					for(int i=0;i<Boss.getItemState().getClip_list().size();i++){
						for(int q=0;q<Boss.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
									Boss.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(12);							
						}
					}
					
				}
				
			}
			
		}
		if(model.get_current_state()!="Died"){
			check=false;
		}
		Boss1_Stage_count++;
		return check;
	}

	public boolean Stage_Start() {
		if(!stage_check){
		if(stage_run==false && stage_prepare==false){

			boolean s1=true;
			switch(stage_progress.charAt(stage_progress_next)){
				case '2':s1=Every_enemy_prepare("Straight");
						if(s1){
							Straight_Stage_lock=false;
						}
						break;
				case '0':s1=Every_enemy_prepare("Move_U");
						if(s1){
						Move_U_Stage_Stage_lock=false;
						}
						break;
				case '1':s1=Every_enemy_prepare("Move_S");
						if(s1){
						Move_S_Stage_lock=false;
						}
						break;
				case '3':s1=Every_enemy_prepare("Straight_s");
						if(s1){
						Straight_s_Stage_lock=false;
						}
						break;
				case '4':s1=Every_enemy_prepare("Enemy_top");
						if(s1){
							Enemy_top_lock=false;
						}
						break;
				case '5':s1=Every_enemy_prepare("Enemy_pos_s");
						if(s1){
						Enemy_position_s_Stage_lock=false;
						}
						break;
				case '*':s1=Every_enemy_prepare("Boss_1");break;
			}
			if(s1==true){

				stage_prepare=true;
				stage_run=true;
				add_mutex=false;
				System.out.println(stage_progress_next+" 1111111111111111111111");
			}
		}else if(stage_run==true && stage_prepare==true){
			boolean check=true;
			switch(stage_progress.charAt(stage_progress_next)){
			case '2':check=Straight_Stage();
				if(check){
				Straight_Stage_lock=true;
				}
				break;
			case '0':check=Move_U_Stage(1);
				if(check){
				Move_U_Stage_Stage_lock=true;
				}
				break;
			case '1':check=Move_S_Stage();
				if(check){
				Move_S_Stage_lock=true;
				}
				break;
			case '3':check=Straight_s_Stage();
					if(check){
						Straight_s_Stage_lock=true;
					}
					break;
			case '4':check=Enemytoplayer_Stage();
					if(check){
							Enemy_top_lock=true;
					}
					break;
			case '5':check=Enemy_position_s_Stage();
					if(check){
							Enemy_position_s_Stage_lock=true;
					}
					break;
			case '*':check=Boss1_Stage();
				break;
			}
			if(check){
				if(add_mutex==false){
					add_mutex=true;
					stage_progress_next++;
					if(stage_progress_next==stage_progress.length()-1){
						Controller.music_tag_lock=true;
					}
					if(stage_progress_next==stage_progress.length()){
						stage_check=true;
						stage_progress_next=1;
					}
				
				}
				stage_prepare=false;
				stage_run=false;			
			}
		}		
		/*
		if( stage_progress_next<=stage_progress.length()-4 && stage_progress_next>=stage_progress.length()-8
				&& stage_run2==false
				&& stage_prepare2==false
				){
			*/
		if( stage_progress_next<=stage_progress.length()-1
				&& stage_progress_next>=stage_progress.length()-8
				&& still_run
			){
		if(stage_run2==false && stage_prepare2==false){
			boolean s2=true;
			switch(stage_progress2.charAt(stage_progress_next2)){
			case '2':s2=Every_enemy_prepare("Straight");
					if(s2){
						Straight_Stage_lock=false;
					}
					break;
			case '0':s2=Every_enemy_prepare("Move_U");
					if(s2){
					Move_U_Stage_Stage_lock=false;
					}
					break;
			case '1':s2=Every_enemy_prepare("Move_S");
					if(s2){
					Move_S_Stage_lock=false;
					}
					break;
			case '3':s2=Every_enemy_prepare("Straight_s");
					if(s2){
					Straight_s_Stage_lock=false;
					}
					break;
			case '4':s2=Every_enemy_prepare("Enemy_top");
					if(s2){
						Enemy_top_lock=false;
					}
					break;
			case '5':s2=Every_enemy_prepare("Enemy_pos_s");
					if(s2){
					Enemy_position_s_Stage_lock=false;
					}
					break;
			case '*':s2=Every_enemy_prepare("Boss_1");break;
		}
			if(s2==true){
				stage_prepare2=true;
				stage_run2=true;
				add_mutex2=false;
				System.out.println(stage_progress_next2+" 22222222222222222222222");
			}
		}else if(stage_run2==true && stage_prepare2==true){

			boolean check=true;
			switch(stage_progress2.charAt(stage_progress_next2)){
			case '2':check=Straight_Stage();
				if(check){
				Straight_Stage_lock=true;
				}
				break;
			case '0':check=Move_U_Stage(1);
				if(check){
				Move_U_Stage_Stage_lock=true;
				}
				break;
			case '1':check=Move_S_Stage();
				if(check){
				Move_S_Stage_lock=true;
				}
				break;
			case '3':check=Straight_s_Stage();
					if(check){
						Straight_s_Stage_lock=true;
					}
					break;
			case '4':check=Enemytoplayer_Stage();
					if(check){
							Enemy_top_lock=true;
					}
					break;
			case '5':check=Enemy_position_s_Stage();
					if(check){
							Enemy_position_s_Stage_lock=true;
					}
					break;
			case '*':check=Boss1_Stage();
				break;
			}
			
			if(check==true){
				if(add_mutex2==false){
					
					add_mutex2=true;
					stage_progress_next2++;
					if( stage_progress_next<stage_progress.length()-1){
							still_run=true;
					}else{
						still_run=false;
					}
					if(stage_progress_next2==stage_progress2.length()){
						stage_progress_next2=1;
					}
				
				}
				stage_prepare2=false;
				stage_run2=false;			
			}
		}
		
		}
		
		}
		return stage_check;
	}
	public void setStagecheck(boolean t){
		stage_check=t;
	}
	public void Stageclear(){
		stage_run=false;
		stage_prepare=false;
		add_mutex=false;
		Straight_Stage_lock=true;
		Move_U_Stage_Stage_lock=true;
		Move_S_Stage_lock=true;
		Straight_s_Stage_lock=true;
		Enemy_top_lock=true;
		Enemy_position_s_Stage_lock=true;
	}
}
