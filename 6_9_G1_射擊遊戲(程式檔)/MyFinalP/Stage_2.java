 

import java.util.ArrayList;

public class Stage_2 extends Stage{
	public 	boolean stage_check=false;
	private boolean Boss_truefalse_bullet=true;

	private double Boss_Stage_count=0.0;
	private double Boss_sep_bullet=1.0;
	private double Boss_back_wait=0.0;
	private double Boss_speedup=0.0;
	private double Boss_sep_shoot=0.0;
	
	private int Boss_normal_pick=0;
	

	private double Boss_normalX1=100.0;
	private double Boss_normalX2=400.0;
	private double Boss_normalX3=100.0;
	private double Boss_normalX4=400.0;
	private double Boss_normalY1=100.0;
	private double Boss_normalY2=100.0;
	private double Boss_normalY3=300.0;
	private double Boss_normalY4=300.0;
	
	private int Boss_skill_pick=0;
	private double Boss_skill_time=0.0;
	private boolean Boss_skill_truefalse=true;

	
	private double Boss_skill1_reverse=1.0;
	private double Boss_skill1_bullet_speed=7.5;
	private double Boss_skill1_bullet_addspeed=0.1;
	private double Boss_skill1_bullet_angle_speed=0.0;
	private double Boss_skill1_bullet_angle_addspeed=0;
	private double Boss_skill1_turn_tf=0.0;

	
	private int Boss_skill1_bullet_random_put=0;
	
	private int Boss_skill2_turncount=2;
	private int Boss_skill2_LR=1;
	private double Boss_skill2_empty_pos=0.0;
	private boolean Boss_skill2_first_pos=true;
	private double Boss_skill2_turn_tf=0.0;

	private int Boss_skill3_random=41;
	private int Boss_skill3_bullet_count=0;
	private int Boss_skill3_bullet_pos_count=0;
	private double Boss_skill3_turn_tf=0.0;

	private double Boss_skill3_pos_X=0;
	private double Boss_skill3_pos_Y=0;
	private double Boss_skill3_angle=0.0;
	
	public static String stage_progress= "-03032454545!";
										  
	public static String stage_progress2="-44441111";
	//public static String stage_progress= "-!";
	//private static String stage_progress2="-000";
	public static int stage_progress_next=1;
	private static int stage_progress_next2=1;

	public boolean stage_run=false;
	public boolean stage_prepare=false;
	public boolean add_mutex=false;
	private static boolean stage_run2=false;
	private static boolean stage_prepare2=false;
	private static boolean add_mutex2=false;
	private static boolean still_run=true;

	public Stage_2 (AImanage ai,Flying_type ft,Player p,ArrayList<Enemy_normal> enl,ArrayList<Enemy_Rocket> enr,ArrayList<Enemy_smile_face> ens,Boss2 boss){
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
	public boolean Boss2_Stage(){
		boolean check=true;
		Model model=Boss2.getItemState();
		if(Boss_Stage_count<80.0){
			
		}
		else if(Boss_Stage_count<160.0){
			aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),View.PAINT_WIDTH/2-Boss2.getItemState().get_W()/2,150,4,false);
			
			Boss2.CantAttack(false);
			Boss2.Boss_CANATTACK=false;

		}
		else if(Boss_Stage_count>=160.0 && Boss_Stage_count<170.0 ){
			Boss2.CantAttack(false);
			Boss2.Boss_CANATTACK=false;

		}
		else if(Boss_Stage_count>=170.0)
		{
			Boss2.Boss_CANATTACK=true;

			//410 turn-> skill  6/5 11 13 1000暫時
			if(Boss_Stage_count>=170.0 && Boss_Stage_count<350){
				
				
				
				
				
				if(Boss_Stage_count>=170 && Boss_Stage_count<200){
					//Boss2.shoot(player,0);
					Boss_speedup+=3.0;			

					if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),Boss_normalX1,Boss_normalY1,Boss_speedup,true)){
						Boss_speedup=0;
						Boss2.shoot(player,0);
					}
				}else if(Boss_Stage_count>=205 && Boss_Stage_count<235){
					Boss_speedup+=3.0;			

					if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),Boss_normalX2,Boss_normalY2,Boss_speedup,true)){
						Boss_speedup=0;
						Boss2.shoot(player,4);
					}
					
				}else if(Boss_Stage_count>=240 && Boss_Stage_count<270){
					Boss_speedup+=3.0;			

					if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),Boss_normalX3,Boss_normalY3,Boss_speedup,true)){
						Boss_speedup=0;
						Boss2.shoot(player,0);

						
					}
					
				}else if(Boss_Stage_count>=275 && Boss_Stage_count<320){
					Boss_speedup+=3.0;			

					if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),Boss_normalX4,Boss_normalY4,Boss_speedup,true)){
						Boss_speedup=0;	
						
						Boss2.shoot(player,4);

					}

					//Boss2.shoot(player,1);
				}else if(Boss_Stage_count>=320){
					Boss_speedup+=3.0;			

					if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),250,150,Boss_speedup,true)){
						for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
							for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
										Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().setAction_CD(0.0);						
	
							}
						}
						Boss_speedup=0;	
					}
				}
				
				int skill_random_pick=(int)(Math.random()*10);
				
				if(skill_random_pick%3==0){
					Boss_skill_pick=1;
				}else if(Boss_skill_pick%3==1){
					Boss_skill_pick=2;
				}else{
					Boss_skill_pick=3;
				}

			}
			// skill 410 start
			else if(Boss_Stage_count>=380.0 && Boss_skill_truefalse==true){
				//second skill attack
				 if(Boss_skill_pick==1){
					//skill1
						
					Boss_speedup+=1.3;
					if(
							aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),View.PAINT_WIDTH/2-Boss2.getItemState().get_W()/2,300,Boss_speedup,true)
						){
						if(Boss_skill1_turn_tf>1){
							Boss_speedup=0.0;
							Boss_skill_truefalse=false;
						}
						Boss_skill1_bullet_speed=10.0;
							if(Boss_skill1_bullet_angle_speed>360 || Boss_skill1_bullet_angle_speed<-360){
								Boss_skill1_reverse*=-1;
								Boss_skill1_bullet_angle_speed=0;
								Boss_skill1_bullet_angle_addspeed=0;
								Boss_skill1_turn_tf++;
							}
							if(Boss_skill1_bullet_angle_addspeed<4.5){
								Boss_skill1_bullet_angle_addspeed+=0.08;
							}
							Boss_skill1_bullet_angle_speed=Boss_skill1_bullet_angle_speed+Boss_skill1_bullet_angle_addspeed*Boss_skill1_reverse;
							
							Boss2.getItemState().set_shoot_speed(1.0);							
							for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
								for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
									Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(Boss_skill1_bullet_speed);							
	
								}
							}
							Boss2.shoot(20,Boss_skill1_bullet_angle_speed);
						 }
			
				}else if(Boss_skill_pick==2){
					Boss_speedup+=2.8;
					Boss_sep_shoot++;
					if(Boss_sep_shoot<35){
						if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),-150,50,Boss_speedup,true)){
							
							Boss_speedup=0;	
						}
					}else if(Boss_sep_shoot>=35 && Boss_sep_shoot<1000){
						//35到 112       1 次  77
						
						
						double X=0;
						if(Boss_skill2_turn_tf>2.0){
							
							Boss_skill_truefalse=false;
						}
						
						//-120 50 600 50
						switch(Boss_skill2_LR){
							case -1:X=-150;break;
							case 1:X=630;break;
						}
						
						if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),X,50,2,false)){												
							if(Boss_skill2_LR==-1){
								Boss_skill2_turncount+=2;
							}
							Boss_skill2_turn_tf++;
							Boss_skill2_LR*=-1;
							Boss_skill2_empty_pos=Math.random()*55;
							if(Boss_skill2_empty_pos==0){
								Boss_skill2_empty_pos=Boss_skill2_empty_pos-5;
							}
						}else{
							if(Boss_skill2_first_pos){
								
								Boss_skill2_empty_pos=Math.random()*55+5;
								if(Boss_skill2_empty_pos==0){
									Boss_skill2_empty_pos=Boss_skill2_empty_pos+5;
								}
								Boss_skill2_turn_tf++;
								Boss_skill2_first_pos=false;
							}
							//50 60 121 131

							if(Boss_sep_shoot>35+Boss_skill2_empty_pos+(Boss_skill2_turncount-2)*78 && Boss_sep_shoot<35+Boss_skill2_empty_pos+(Boss_skill2_turncount-2)*78+10){
								//System.out.println("RL"+" "+Boss2.getItemState().get_X());

							}else if(Boss_sep_shoot>35+(Boss_skill2_turncount-1)*78+Boss_skill2_empty_pos && Boss_sep_shoot<35+(Boss_skill2_turncount-1)*78+Boss_skill2_empty_pos+10){
								//System.out.println("LR"+" "+Boss2.getItemState().get_X());
							}else{
								for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
									//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
									for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
											Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(10);
									}		
								}
								Boss2.shoot(player,0);
							}
							
						}
					}					
				}else if(Boss_skill_pick==3){
					Boss_speedup+=2.8;
					//Boss_sep_shoot++;
					switch(Boss_skill3_bullet_pos_count){
						case 0:
							Boss_skill3_pos_Y=10;
							Boss_skill3_pos_X=0;
							Boss_skill3_angle=180.0;
							break;
						case 1:
							Boss_skill3_pos_Y=10;
							Boss_skill3_pos_X=View.PAINT_WIDTH-Boss2.getItemState().get_W();
							Boss_skill3_angle=90.0;
							
							break;
						case 2:
							Boss_skill3_pos_Y=View.PAINT_HEIGHT-Boss2.getItemState().get_H()-10;
							Boss_skill3_pos_X=View.PAINT_WIDTH-Boss2.getItemState().get_W();
							Boss_skill3_angle=0.0;
							break;
						case 3:
							Boss_skill3_pos_Y=View.PAINT_HEIGHT-Boss2.getItemState().get_H()-10;
							Boss_skill3_pos_X=0;
							Boss_skill3_angle=270.0;
							break;
						case 4:
							Boss_skill3_pos_Y=140.0;
							Boss_skill3_pos_X=View.PAINT_WIDTH/2-Boss2.getItemState().get_W()/2;
							break;
							
					}
					if(
						aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),Boss_skill3_pos_X,Boss_skill3_pos_Y,Boss_speedup,true)
							){
									Boss_speedup=0;
									Boss_sep_shoot++;
									if(Boss_skill3_bullet_pos_count==4){
										
										if(Boss_sep_shoot>180){
											Boss_skill3_bullet_pos_count=0;
											Boss_speedup=0;	
											Boss_sep_shoot=0;
											Boss_skill3_random=(int)(Math.random()*10);
											switch(Boss_skill3_random%3){
												case 0:Boss_skill3_random=41;break;
												case 1:Boss_skill3_random=42;break;
												case 2:Boss_skill3_random=43;break;
											}
											Boss_skill_truefalse=false;
										}else{
											if(Boss_sep_shoot>20){											
												for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
													//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
													for(int q=0;q<10;q++){		
														if(Boss_sep_shoot>20+q*5){															
															Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(0+q).getItemState().set_move_offset(10);
															Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(10+q).getItemState().set_move_offset(10);
															Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(20+q).getItemState().set_move_offset(10);
															Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(30+q).getItemState().set_move_offset(10);
																													}														
													}															
												}
											}
										}
										
										
									}else{
										if(Boss_sep_shoot>1){
											Boss_skill3_bullet_pos_count++;
											Boss_sep_shoot=0;
											Boss_skill3_bullet_count=0;
											Boss2.EnemyBulletCDClear();
										}else{
											for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
												//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
												for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
														Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(0);
												}		
											}
											Boss2.getItemState().set_shoot_speed(0.00001);
											for(int i=0;i<20;i++){
												Boss2.shoot(Boss_skill3_random, Boss_skill3_angle);
											}
												
										}
										
									}						
								}	
				}
				
			}
			else if(Boss_skill_truefalse==false){
				
				if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),View.PAINT_WIDTH/2-Boss2.getItemState().get_W()/2,140.0,8,true)){
					
					Boss_truefalse_bullet=true;
					
					for(int c=0;c<Boss2.getItemState().getClip_list().size();c++){
						Boss2.getItemState().getClip_list().get(c).set_bullet_speed_count(0.0);			
						for(int q=0;q<Boss2.getItemState().getClip_list().get(c).get_bullet_list().size();q++){
							if(Boss2.getItemState().getClip_list().get(c).get_bullet_list().get(q).getItemState().get_current_state().equals("flying")){
								 Boss_truefalse_bullet=false;
							}
						}
					}
					
					if(Boss_truefalse_bullet==true){
					
						if(Boss_back_wait>25){
							for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
								Boss2.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);			
								for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){
											Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(15.0);							
	
								}
							}
							Boss_skill1_turn_tf=0.0;
							Boss_skill2_turn_tf=0.0;
							Boss_back_wait=0.0;
							Boss_skill_truefalse=true;
							Boss_Stage_count=170.0;
							Boss_speedup=0.0;
							Boss2.getItemState().setDirection_DX(0.0);
							Boss2.getItemState().setDirection_DY(0.0);
							Boss2.getItemState().setAngle(180.0);
							Boss2.getItemState().setAddspeed(1.0);
							Boss2.getItemState().setAction_CD(0.0);
							Boss2.getItemState().set_shoot_speed(4);
							Boss_skill2_empty_pos=0.0;
							Boss_skill2_turncount=2;
							Boss_skill2_first_pos=true;
							Enemy_top_count=0;
							Boss_sep_shoot=0.0;
							
							int reverse_random=(int)(Math.random()*10);
							if(reverse_random%2==0){
								Boss_skill1_reverse=1.0;
							}else{
								Boss_skill1_reverse=-1.0;
							}
							Boss_normal_pick=((int)(Math.random()*10))%2==0?0:1;
							switch(Boss_normal_pick){
								case 0:
										Boss_normalX1=100.0;
										Boss_normalX2=400.0;
										Boss_normalX3=100.0;
										Boss_normalX4=400.0;
										Boss_normalY1=100.0;
										Boss_normalY2=100.0;
										Boss_normalY3=300.0;
										Boss_normalY4=300.0;
									break;
								case 1:
									 	Boss_normalX1=100.0;
									 	Boss_normalY1=300.0;
									 	
										Boss_normalX2=400.0;
										Boss_normalY2=300.0;
										
										Boss_normalX3=100.0;
										Boss_normalY3=100.0;
										
										Boss_normalX4=400.0;
										Boss_normalY4=100.0;
									break;
							}
							
							

							
							
							
							
							
							
						}else{
							Boss_back_wait++;
						}
					}
				}
				
			}
			
			
		}
		
		if(model.get_current_state()!="Died"){
			check=false;
		}
			
		Boss_Stage_count++;
	
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
				case '!':s1=Every_enemy_prepare("Boss_2");break;
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
			case '!':check=Boss2_Stage();
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
		if( stage_progress_next<=stage_progress.length()-1
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
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
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

/*
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

Boss_skill_pick=0;

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
		Boss_skill_time=600.0;
		break;
}
*/



//diag move
/*
if(Boss_sep_shoot<50){
	//Boss2.shoot(player,0);
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),View.PAINT_WIDTH+50-Boss2.getItemState().get_W(),View.PAINT_HEIGHT+100-Boss2.getItemState().get_H(),Boss_speedup)){
		Boss_speedup=0;
	}
}else if(Boss_sep_shoot>=50 && Boss_sep_shoot<100){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),0,10,Boss_speedup)){
		Boss_speedup=0;

	}
}else if(Boss_sep_shoot>=100 && Boss_sep_shoot<150){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),View.PAINT_WIDTH+50-Boss2.getItemState().get_W(),10,Boss_speedup)){

		Boss_speedup=0;
	}
	
	//Boss2.shoot(player,1);
}else if(Boss_sep_shoot>=150 && Boss_sep_shoot<200){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),0,View.PAINT_HEIGHT+100-Boss2.getItemState().get_H(),Boss_speedup)){

		Boss_speedup=0;	
	}

	//Boss2.shoot(player,1);
}else{
	
	Boss_sep_shoot=0;
}
*/





//skill3
/*
Boss_speedup+=2.8;
//Boss_sep_shoot++;
switch(Boss_skill3_bullet_pos_count){
	case 0:
		Boss_skill3_pos_Y=10;
		Boss_skill3_pos_X=0;
		Boss_skill3_angle=180.0;
		break;
	case 1:
		Boss_skill3_pos_Y=10;
		Boss_skill3_pos_X=View.PAINT_WIDTH-Boss2.getItemState().get_W();
		Boss_skill3_angle=90.0;
		
		break;
	case 2:
		Boss_skill3_pos_Y=View.PAINT_HEIGHT-Boss2.getItemState().get_H()-10;
		Boss_skill3_pos_X=View.PAINT_WIDTH-Boss2.getItemState().get_W();
		Boss_skill3_angle=0.0;
		break;
	case 3:
		Boss_skill3_pos_Y=View.PAINT_HEIGHT-Boss2.getItemState().get_H()-10;
		Boss_skill3_pos_X=0;
		Boss_skill3_angle=270.0;
		break;
	case 4:
		Boss_skill3_pos_Y=150;
		Boss_skill3_pos_X=250;
		break;
}
if(
	aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),Boss_skill3_pos_X,Boss_skill3_pos_Y,Boss_speedup,true)
		){
				Boss_speedup=0;
				Boss_sep_shoot++;
				if(Boss_skill3_bullet_pos_count==4){
					
					if(Boss_sep_shoot>180){
						Boss_skill3_bullet_pos_count=0;
						Boss_speedup=0;	
						Boss_sep_shoot=0;
						Boss_skill3_random=(int)(Math.random()*10);
						switch(Boss_skill3_random%3){
							case 0:Boss_skill3_random=41;break;
							case 1:Boss_skill3_random=42;break;
							case 2:Boss_skill3_random=43;break;
						}
						Boss2.getItemState().set_shoot_speed(4);
					}else{
						if(Boss_sep_shoot>20){											
							
							for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
								//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
								for(int q=0;q<10;q++){		
									if(Boss_sep_shoot>20+q*5){
										
										Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(0+q).getItemState().set_move_offset(10);
										Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(10+q).getItemState().set_move_offset(10);
										Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(20+q).getItemState().set_move_offset(10);
										Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(30+q).getItemState().set_move_offset(10);
										
									}
									
								}		
								
							}
							
							//Boss2.getItemState().getClip_list().get(0).get_bullet_list().get(0).getItemState().set_move_offset(10);
							//Boss2.getItemState().getClip_list().get(0).get_bullet_list().get(2).getItemState().set_move_offset(10);
							//Boss2.getItemState().getClip_list().get(0).get_bullet_list().get(9).getItemState().set_move_offset(10);

							//Boss2.getItemState().getClip_list().get(0).get_bullet_list().get(4).getItemState().set_move_offset(10);
							//Boss2.getItemState().getClip_list().get(0).get_bullet_list().get(6).getItemState().set_move_offset(10);

						}
					}
					
					
				}else{
					if(Boss_sep_shoot>1){
						Boss_skill3_bullet_pos_count++;
						Boss_sep_shoot=0;
						Boss_skill3_bullet_count=0;
						Boss2.EnemyBulletCDClear();
					}else{
						for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
							//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
							for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
									Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(0);
							}		
						}
						Boss2.getItemState().set_shoot_speed(0.00001);
						for(int i=0;i<20;i++){
							Boss2.shoot(Boss_skill3_random, Boss_skill3_angle);
						}
							
					}
					
				}						
			}		
*/
//left right check skill 2
/*
if(Boss_sep_shoot<35){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),-150,50,Boss_speedup,true)){
		
		Boss_speedup=0;	
	}
}else if(Boss_sep_shoot>=35 && Boss_sep_shoot<1000){
	//35到 112       1 次  77
	
	
	double X=0;
	
	//-120 50 600 50
	switch(Boss_skill2_LR){
		case -1:X=-150;break;
		case 1:X=630;break;
	}
	
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),X,50,2,false)){												
		if(Boss_skill2_LR==-1){
			Boss_skill2_turncount+=2;
		}
		Boss_skill2_LR*=-1;
		Boss_skill2_empty_pos=Math.random()*60;
		if(Boss_skill2_empty_pos==0){
			Boss_skill2_empty_pos=Boss_skill2_empty_pos+5;
		}
	}else{
		if(Boss_skill2_first_pos){
			
			Boss_skill2_empty_pos=Math.random()*60;
			if(Boss_skill2_empty_pos==0){
				Boss_skill2_empty_pos=Boss_skill2_empty_pos+5;
			}
			Boss_skill2_first_pos=false;
		}
		//50 60 121 131
		System.out.println(Boss_sep_shoot+" "+(35+Boss_skill2_empty_pos+Boss_skill2_turncount*78));

		if(Boss_sep_shoot>35+Boss_skill2_empty_pos+(Boss_skill2_turncount-2)*78 && Boss_sep_shoot<35+Boss_skill2_empty_pos+(Boss_skill2_turncount-2)*78+10){
			System.out.println("RL"+" "+Boss2.getItemState().get_X());

		}else if(Boss_sep_shoot>35+(Boss_skill2_turncount-1)*78+Boss_skill2_empty_pos && Boss_sep_shoot<35+(Boss_skill2_turncount-1)*78+Boss_skill2_empty_pos+10){
			System.out.println("LR"+" "+Boss2.getItemState().get_X());
		}else{
			for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
				//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
				for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
						Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(10);
				}		
			}
			Boss2.shoot(player,0);
		}
		
	}

	
}else if(Boss_sep_shoot>=70 && Boss_sep_shoot<105){
	
}else if(Boss_sep_shoot>=105 && Boss_sep_shoot<140){
					
	
}else{
	Boss_Stage_count=170;
	Boss_sep_shoot=0;
}
Boss_speedup+=2.8;
Boss_sep_shoot++;
*/
//normal_shoot
/*
if(Boss_sep_shoot<35){
	//Boss2.shoot(player,0);
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),100,100,Boss_speedup)){
		Boss_speedup=0;
		Boss2.getItemState().set_shoot_speed(5);
		for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
			//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
			for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
					Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(25);
			}		
		}
		Boss2.shoot(player,4);
	}
}else if(Boss_sep_shoot>=35 && Boss_sep_shoot<70){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),100,300,Boss_speedup)){
		Boss_speedup=0;
		Boss2.getItemState().set_shoot_speed(5);
		for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
			//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
			for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
					Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(25);
			}		
		}
		Boss2.shoot(player,0);
	}
}else if(Boss_sep_shoot>=70 && Boss_sep_shoot<105){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),400,100,Boss_speedup)){
		Boss_speedup=0;
		Boss2.getItemState().set_shoot_speed(5);
		for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
			//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
			for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
					Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(25);
			}		
		}
		Boss2.shoot(player,4);
	}
	//Boss2.shoot(player,1);
}else if(Boss_sep_shoot>=105 && Boss_sep_shoot<140){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),400,300,Boss_speedup)){
		Boss_speedup=0;	
		Boss2.getItemState().set_shoot_speed(5);
		for(int i=0;i<Boss2.getItemState().getClip_list().size();i++){
			//Boss.getItemState().getClip_list().get(i).set_bullet_speed_count(0.0);
			for(int q=0;q<Boss2.getItemState().getClip_list().get(i).get_bullet_list().size();q++){							
					Boss2.getItemState().getClip_list().get(i).get_bullet_list().get(q).getItemState().set_move_offset(25);
			}		
		}
		Boss2.shoot(player,0);
	}

	//Boss2.shoot(player,1);
}else if(Boss_sep_shoot>=140 && Boss_sep_shoot<180){
	if(aimanage.tosomewhere(Boss2,Boss2.getItemState().get_X(),Boss2.getItemState().get_Y(),250,150,Boss_speedup)){
		Boss_speedup=0;	
	}
}else{
	Boss_Stage_count=170;
	Boss_sep_shoot=0;
}
*/