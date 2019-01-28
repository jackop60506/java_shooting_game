 

public class Shoot_type {
	Model bs,ps,ens,ers;
	Clip cl1,cl2,cl3,cl4,cl5,cl6;
	
	Clip_rocket_enemy clr1,clr2,clr3;	

	Clip_normal_enemy cne;
	
	Clip_rocket_enemy cre;
	int shoot_level;
	int type;
	Music_Manage music_manage;
	public Shoot_type(Music_Manage m){
		music_manage=m;
	}
	public void Shoot_normal(Model ps,int Level){
		Bullet b;
		Model bs;
		double bsetx=0.0,bsety=0.0;
		double bullet_angle=0.0;
		cl1 =ps.getClip_list().get(0);
		cl2 =ps.getClip_list().get(1);
		cl3 =ps.getClip_list().get(2);
		
		if(ps.getClip_list().size()==8){
			if(cl1.check_bullet()==false){
			}else if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
				music_manage.playshoot();
	
			}
		}
		
		if(Level==1){
			if(cl1.check_bullet()==false){
				System.out.println("outbullet");
			}else{
					if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
						//music_manage.playshoot();

						cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
						for(int i=0;i<cl1.get_bullet_list_MAX();i++){
							b=cl1.get_bullet_list().get(i);
							bs=b.getItemState();
							if(bs.get_current_state().equals("Nothing")){
								b.changeState("flying");
								
								
								
								bs.setAngle(ps.getAngle());
								if(b instanceof Bullet_Player){
									bsetx=ps.get_X()+(ps.get_W()/2);
									bsety=ps.get_Y();
									bs.setDirection_DY(-1.0);
								 	bs.setDirection_DX(0.0);
								}else if(b instanceof Bullet_Rocket_Enemy){
									bsetx=ps.get_X()+(ps.get_W()/2)-(bs.get_W()/1.3);
									bsety=ps.get_Y()+ps.get_H()-ps.get_H()/5;							
									bs.setDirection_DY(1.0);
								 	bs.setDirection_DX(0.0);
								}
								
								bs.setArea_X(bsetx);
								bs.setArea_Y(bsety);			
								cl1.get_bullet();
								break;
							}
						}
					}else{
						cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
					}
			}
		}else if(Level ==2){
			
			for(int q=0;q<2;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							
							
							bs.setAngle(ps.getAngle());
							if(b instanceof Bullet_Player){
								 
								switch(q){
									case 0:
										bsetx=ps.get_X()+ps.get_W()/4;
										break;
									case 1:
										bsetx=ps.get_X()+ps.get_W()/2+bs.get_W()/1.5;
										break;	
								}
								bs.setDirection_DY(-1.0);
							 	bs.setDirection_DX(0.0);
							 	bsety=ps.get_Y()+ps.get_H()/3;
							
							}else if(b instanceof Bullet_Rocket_Enemy){
								switch(q){
									case 0:
										bsetx=ps.get_X()+5;
										break;
									case 1:
										bsetx=ps.get_X()+ps.get_W()/2+5;
										break;	
								}
								bs.setDirection_DY(1.0);
							 	bs.setDirection_DX(0.0);
							 	bsety=ps.get_Y()+ps.get_H()/3;
							
							}else if(b instanceof Bullet_Boss){
									switch(q){
									case 0:
										bsetx=ps.get_X()+ps.get_W()/2-b.getItemState().get_W()/2;
										break;
									case 1:
										bsetx=ps.get_X()+ps.get_W()/2+b.getItemState().get_W()/4;
										break;	
								}
								bs.setDirection_DY(1.0);
							 	bs.setDirection_DX(0.0);
							 	bsety=ps.get_Y()+ps.get_H()-10;
						
							}
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}else if(Level ==3){
			for(int q=0;q<3;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							
							
							bs.setAngle(ps.getAngle());
						
							
							if(b instanceof Bullet_Player){	
								/*
								bs.setDirection_DY(-1.0);	
								bsety=ps.get_Y();
								bsetx=ps.get_X()+(ps.get_W()/2);
								switch(q){
								case 0:
								 	bs.setDirection_DX(0.0);
									break;
								case 1:
									bs.setDirection_DX(0.08);
									break;	
								case 2:
									bs.setDirection_DX(-0.08);
									break;
								}
								*/
								
								bs.setDirection_DY(-1.0);	
								bs.setDirection_DX(0.0);
								switch(q){
								case 0:
									bsety=ps.get_Y()+ps.get_H()/2;
									bsetx=ps.get_X()+(ps.get_W()/4.3);
									break;
								case 1:
									bsety=ps.get_Y();
									bsetx=ps.get_X()+(ps.get_W()/2.1);
									break;	
								case 2:
									bsety=ps.get_Y()+ps.get_H()/2;
									bsetx=ps.get_X()+(ps.get_W()/4)+(ps.get_W()/2.2);
									break;
								}
								
								
							}else if(b instanceof Bullet_Rocket_Enemy){
								bs.setDirection_DY(1.0);
								bsety=ps.get_Y()+ps.get_H()-ps.get_H()/5;							
								bsetx=ps.get_X()+(ps.get_W()/2)-(bs.get_W()/1.3);
								switch(q){
								case 0:
								 	bs.setDirection_DX(0.35);
									break;
								case 1:
									bs.setDirection_DX(0.0);
									break;	
								case 2:
									bs.setDirection_DX(-0.35);
									break;
								}
							
							}else if(b instanceof Bullet_Boss){
								switch(q){
									case 0:
										bsetx=ps.get_X()+10;
										break;
									case 1:
										bsetx=ps.get_X()+ps.get_W()-10;
										break;
									case 2:
										bsetx=-100;
										break;
									
								}
								bs.setDirection_DY(1.0);
							 	bs.setDirection_DX(0.0);
							 	bsety=ps.get_Y()+ps.get_H()*0.8;
							}
							
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}else if(Level ==4){
			for(int q=0;q<4;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							
							
							bs.setAngle(ps.getAngle());
						
							
							if(b instanceof Bullet_Player){	
								bs.setDirection_DY(-1.0);	
								switch(q){
								case 0:
									bsety=ps.get_Y()+ps.get_H()/2;
									bsetx=ps.get_X()+(ps.get_W()/4.3);
									bs.setDirection_DX(-0.1);
									break;
								case 1:
									bsety=ps.get_Y();
									bsetx=ps.get_X()+(ps.get_W()/2.1);
									bs.setDirection_DX(0.05);	
									break;	
								case 2:
									bsety=ps.get_Y();
									bsetx=ps.get_X()+(ps.get_W()/2.1);
									bs.setDirection_DX(-0.05);	
									break;
								case 3:
									bsety=ps.get_Y()+ps.get_H()/2;
									bsetx=ps.get_X()+(ps.get_W()/4)+(ps.get_W()/2.2);
									bs.setDirection_DX(0.1);
									break;
								}
								
								
							}else if(b instanceof Bullet_Rocket_Enemy){
								
							}else if(b instanceof Bullet_Boss){
								bsety=ps.get_Y()+ps.get_H()-100;
									switch(q){
									
									case 0:
										bsetx=ps.get_X()+ps.get_W()/2-7.5;
										
										bs.setDirection_DX(-0.4);
										bs.setDirection_DY(1.0);

										bs.setAngle(135);
										break;
										
									case 1:
										bsetx=-100;

										break;
										
									case 2:
										bsetx=ps.get_X()+ps.get_W()/2-7.5;
										bs.setDirection_DX(0.4);	
										bs.setDirection_DY(1.0);

										bs.setAngle(225);

										break;
									case 3:
										bsetx=-100;
										break;
								
								}
							}
					
							
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}else if(Level ==5){
			for(int q=0;q<5;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							
							
							bs.setAngle(ps.getAngle());
						
							
							if(b instanceof Bullet_Player){	
								bs.setDirection_DY(-1.0);	
								switch(q){
								case 0:
									bsety=ps.get_Y()+ps.get_H()/2;
									bsetx=ps.get_X()+(ps.get_W()/4.3);
									bs.setDirection_DX(-0.08);
									break;
								case 1:
									bsety=ps.get_Y();
									bsetx=ps.get_X()+(ps.get_W()/2.1);
									bs.setDirection_DX(0.05);	
									break;	
								case 2:
									bsety=ps.get_Y();
									bsetx=ps.get_X()+(ps.get_W()/2.1);
									bs.setDirection_DX(0);	
									break;
								case 3:
									bsety=ps.get_Y();
									bsetx=ps.get_X()+(ps.get_W()/2.1);
									bs.setDirection_DX(-0.05);	
									break;
								case 4:
									bsety=ps.get_Y()+ps.get_H()/2;
									bsetx=ps.get_X()+(ps.get_W()/4)+(ps.get_W()/2.2);
									bs.setDirection_DX(0.08);
									break;
								}
								
								
								
							}
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}
		else if(Level==8){
			for(int q=0;q<8;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							bsetx=ps.get_X()+(ps.get_W()/2);
							bsety=ps.get_Y()+(ps.get_H()/2);
							
								switch(q){						
									case 0:
									 	bs.setDirection_DX(0.0);
									 	bs.setDirection_DY(-1.0);
									 	bullet_angle=0.0;
										break;
									case 1:
										bs.setDirection_DX(0.0);
										bs.setDirection_DY(1.0);
										bullet_angle=180.0;
										break;	
									case 2:
										bs.setDirection_DX(1.0);
										bs.setDirection_DY(0.0);
										bullet_angle=270.0;
										break;
									case 3:
										bs.setDirection_DX(-1.0);
										bs.setDirection_DY(0.0);
										bullet_angle=90.0;
										break;	
									case 4:
										bs.setDirection_DX(0.5);
										bs.setDirection_DY(0.5);
										bullet_angle=225.0;
										break;
									case 5:
										bs.setDirection_DX(-0.5);
										bs.setDirection_DY(0.5);
										bullet_angle=135.0;
										break;	
									case 6:
										bs.setDirection_DX(0.5);
										bs.setDirection_DY(-0.5);
										bullet_angle=315.0;

										break;
									case 7:
										bs.setDirection_DX(-0.5);
										bs.setDirection_DY(-0.5);
										bullet_angle=45.0;

										break;
							}	
													 	   	 	   
							bs.setAngle(bullet_angle);
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}else if(Level==82){
			for(int q=0;q<8;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							bsetx=ps.get_X()+(ps.get_W()/2);
							bsety=ps.get_Y()+(ps.get_H()/2);
							
								switch(q){						
								case 0:
									bs.setDirection_DX(-0.25);
									bs.setDirection_DY(-0.75);
									bullet_angle=22.5;
									break;
								case 1:
									bs.setDirection_DX(-0.75);
									bs.setDirection_DY(-0.25);
									bullet_angle=67.5;
									break;
								case 2:
									bs.setDirection_DX(-0.75);
									bs.setDirection_DY(0.25);
									bullet_angle=112.5;
									break;
								case 3:
									bs.setDirection_DX(-0.25);
									bs.setDirection_DY(0.75);
									bullet_angle=157.5;
									break;
								case 4:
									bs.setDirection_DX(0.25);
									bs.setDirection_DY(0.75);
									bullet_angle=202.5;
									break;
								case 5:
									bs.setDirection_DX(0.75);
									bs.setDirection_DY(0.25);
									bullet_angle=247.5;
									break;
								case 6:
									bs.setDirection_DX(0.75);
									bs.setDirection_DY(-0.25);
									bullet_angle=292.5;
									break;
								case 7:
									bs.setDirection_DX(0.25);
									bs.setDirection_DY(-0.75);
									bullet_angle=337.5;
									break;				
								}		
													 	   	 	   
							bs.setAngle(bullet_angle);
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}else if(Level==16){
			for(int q=0;q<16;q++){
				cl1 =ps.getClip_list().get(q);
				if(cl1.get_bullet_speed_count()>ps.get_shoot_speed()){
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%ps.get_shoot_speed());
					for(int i=0;i<cl1.get_bullet_list_MAX();i++){
						b=cl1.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							b.changeState("flying");
							bsetx=ps.get_X()+(ps.get_W()/2);
							bsety=ps.get_Y()+(ps.get_H()/2);
							
								switch(q){						
								
									case 0:
									 	bs.setDirection_DX(0.0);
									 	bs.setDirection_DY(-1.0);
									 	bullet_angle=0.0;
										break;
									case 8:
										bs.setDirection_DX(-0.25);
										bs.setDirection_DY(-0.75);
										bullet_angle=22.5;
										break;
									case 9:
										bs.setDirection_DX(-0.75);
										bs.setDirection_DY(-0.25);
										bullet_angle=67.5;
										break;
									case 10:
										bs.setDirection_DX(-0.75);
										bs.setDirection_DY(0.25);
										bullet_angle=112.5;
										break;
									case 11:
										bs.setDirection_DX(-0.25);
										bs.setDirection_DY(0.75);
										bullet_angle=157.5;
										break;
									case 12:
										bs.setDirection_DX(0.25);
										bs.setDirection_DY(0.75);
										bullet_angle=202.5;
										break;
									case 13:
										bs.setDirection_DX(0.75);
										bs.setDirection_DY(0.25);
										bullet_angle=247.5;
										break;
									case 14:
										bs.setDirection_DX(0.75);
										bs.setDirection_DY(-0.25);
										bullet_angle=292.5;
										break;
									case 15:
										bs.setDirection_DX(0.25);
										bs.setDirection_DY(-0.75);
										bullet_angle=337.5;
										break;
									case 1:
										bs.setDirection_DX(0.0);
										bs.setDirection_DY(1.0);
										bullet_angle=180.0;
										break;	
									case 2:
										bs.setDirection_DX(1.0);
										bs.setDirection_DY(0.0);
										bullet_angle=270.0;
										break;
									case 3:
										bs.setDirection_DX(-1.0);
										bs.setDirection_DY(0.0);
										bullet_angle=90.0;
										break;	
									case 4:
										bs.setDirection_DX(0.5);
										bs.setDirection_DY(0.5);
										bullet_angle=225.0;
										break;
									case 5:
										bs.setDirection_DX(-0.5);
										bs.setDirection_DY(0.5);
										bullet_angle=135.0;
										break;	
									case 6:
										bs.setDirection_DX(0.5);
										bs.setDirection_DY(-0.5);
										bullet_angle=315.0;

										break;
									case 7:
										bs.setDirection_DX(-0.5);
										bs.setDirection_DY(-0.5);
										bullet_angle=45.0;
									
										break;
									
								}		
													 	   	 	   
							bs.setAngle(bullet_angle);
							bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);			
							cl1.get_bullet();
							break;
						}
					}
				}else{
					cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
				}
			}
		}
	}
	public void Shoot_tosomeone(Model ps,Model es){
		Model bs;
		Bullet b;
		Clip_player cl=(Clip_player)ps.getClip_list().get(0);
	
		double bullet_angle,Xoffset,Yoffset; 
		
			if(cl.check_bullet()==false){
				//System.out.println(cl.bullet_number);
				
			}else{

				if(cl.get_bullet_speed_count()>ps.get_shoot_speed()){
					
					cl.set_bullet_speed_count(0);
					for(int i=0;i<cl.get_bullet_list_MAX();i++){	
						b=cl.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							
									
							b.changeState("flying");	
							double bsetx,bsety;							
							 bsetx=ps.get_X()+(ps.get_W()/2);	 
							 bsety=ps.get_Y();

							 bullet_angle=get_Angle(bsetx,bsety,es.get_X()+es.get_W()/2-bs.get_W()/2,es.get_Y()+es.get_H()/2-bs.get_H()/2);
							bs.setAngle(bullet_angle);

							//只差方向設定
							
							Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	   	 	   
						 	bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
					 		bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);
							cl.get_bullet();
							break;
						}
					}
					
				}else{
					cl.set_bullet_speed_count(cl.get_bullet_speed_count()+1);

				}

			}
	}
	public void BossShoot_left_Y(Boss e,double shoot_angle){
		Model bs;
		Bullet b;
		Model ps = e.getItemState();
		double bullet_angle,Xoffset,Yoffset; 
		for(int q=0;q<3;q++){
			cl1 =e.getItemState().getClip_list().get(q);
			if(cl1.get_bullet_speed_count()>e.getItemState().get_shoot_speed()){
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%e.getItemState().get_shoot_speed());
				for(int i=0;i<cl1.get_bullet_list_MAX();i++){
					b=cl1.get_bullet_list().get(i);
					bs=b.getItemState();
					if(bs.get_current_state().equals("Nothing")){
						b.changeState("flying");
						
						
						double bsetx=0.0,bsety=0.0;
						
						
						 bullet_angle=shoot_angle;
						 
						 Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 
						bs.setAngle(bullet_angle);
					if(b instanceof Bullet_Boss){
								switch(q){
								/*
								case 0:
									bsetx=ps.get_X()+ps.get_W()/2-b.getItemState().get_W()/2;								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-10;
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-10;
									break;
								case 1:
									bsetx=ps.get_X()+10;
								 	bsety=ps.get_Y()+ps.get_H()*0.8;
									break;	
								case 2:
									bsetx=ps.get_X()+30;
								 	bsety=ps.get_Y()+ps.get_H()*0.8;
								 	break;
								*/
								case 0:
									bsetx=ps.get_X()+ps.get_W()/2-10;								 	
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-b.getItemState().get_H();
									break;
								case 1:
									bsetx=ps.get_X()+ps.get_W()/2-20;								 	
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-b.getItemState().get_H();
									break;	
								case 2:
									bsetx=ps.get_X()+ps.get_W()/2-30;							
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-b.getItemState().get_H();
									break;
							}
							bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
						}
						bs.setArea_X(bsetx);
						bs.setArea_Y(bsety);			
						cl1.get_bullet();
						break;
					}
				}
			}else{
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
			}
		}
	}
	public void BossShoot_right_Y(Boss e,double shoot_angle){
		Model bs;
		Bullet b;
		Model ps = e.getItemState();
		double bullet_angle,Xoffset,Yoffset; 
		for(int q=3;q<6;q++){
			cl1 =e.getItemState().getClip_list().get(q);
			if(cl1.get_bullet_speed_count()>e.getItemState().get_shoot_speed()){
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%e.getItemState().get_shoot_speed());
				for(int i=0;i<cl1.get_bullet_list_MAX();i++){
					b=cl1.get_bullet_list().get(i);
					bs=b.getItemState();
					if(bs.get_current_state().equals("Nothing")){
						b.changeState("flying");
						
						
						double bsetx=0.0,bsety=0.0;
						
						
						 bullet_angle=shoot_angle;
						 
						 Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 
						bs.setAngle(bullet_angle);
					if(b instanceof Bullet_Boss){
								switch(q){
								case 3:
									bsetx=ps.get_X()+ps.get_W()/2;								 	
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-b.getItemState().get_H();
									break;
								case 4:
									bsetx=ps.get_X()+ps.get_W()/2+10;								 	
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-b.getItemState().get_H();
									break;	
								case 5:
									bsetx=ps.get_X()+ps.get_W()/2+20;							
								 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-b.getItemState().get_H();
									break;
							}
							bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
						}
						bs.setArea_X(bsetx);
						bs.setArea_Y(bsety);			
						cl1.get_bullet();
						break;
					}
				}
			}else{
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
			}
		}
	}
	public void Shoot_tosomeone(Enemy_normal e,Player p){
		Model bs,es=p.getItemState(),ps=e.getItemState();
		Bullet b;
		Clip_normal_enemy cl=(Clip_normal_enemy)ps.getClip_list().get(0);
	
		double bullet_angle,Xoffset,Yoffset; 
		
			if(cl.check_bullet()==false){
				//System.out.println(cl.bullet_number);
				
			}else{

				if(cl.get_bullet_speed_count()>ps.get_shoot_speed()){
					
					cl.set_bullet_speed_count(0);
					for(int i=0;i<cl.get_bullet_list_MAX();i++){	
						b=cl.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							
									
							b.changeState("flying");	
							double bsetx,bsety;							
							 bsetx=ps.get_X()+(ps.get_W()/2)-bs.get_W()/2;	 
							 bsety=ps.get_Y()+(ps.get_H()/2)-bs.get_H()/2;

							 bullet_angle=get_Angle(bsetx,bsety,es.get_X()+es.get_W()/2-bs.get_W()/2,es.get_Y()+es.get_H()/2-bs.get_H()/2);
							bs.setAngle(bullet_angle);

							//只差方向設定
							
							Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	   	 	   
						 	bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
					 		bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);
							cl.get_bullet();
							break;
						}
					}
					
				}else{
					cl.set_bullet_speed_count(cl.get_bullet_speed_count()+1);

				}

			}
	}
	public void Shoot_tosomeone(Enemy_Rocket e,Player p){
		Model bs,es=p.getItemState(),ps=e.getItemState();
		Bullet b;
		Clip_rocket_enemy cl=(Clip_rocket_enemy)ps.getClip_list().get(0);
	
		double bullet_angle,Xoffset,Yoffset; 
		
			if(cl.check_bullet()==false){
				//System.out.println(cl.bullet_number);
				
			}else{

				if(cl.get_bullet_speed_count()>ps.get_shoot_speed()){
					
					cl.set_bullet_speed_count(0);
					for(int i=0;i<cl.get_bullet_list_MAX();i++){	
						b=cl.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							
									
							b.changeState("flying");	
							double bsetx,bsety;							
							 bsetx=ps.get_X()+(ps.get_W()/2)-bs.get_W()/2;	 
							 bsety=ps.get_Y()+(ps.get_H()/2)-bs.get_H()/2;

							 bullet_angle=get_Angle(bsetx,bsety,es.get_X()+es.get_W()/2-bs.get_W()/2,es.get_Y()+es.get_H()/2-bs.get_H()/2);
							bs.setAngle(bullet_angle);

							//只差方向設定
							
							Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	   	 	   
						 	bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
					 		bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);
							cl.get_bullet();
							break;
						}
					}
					
				}else{
					cl.set_bullet_speed_count(cl.get_bullet_speed_count()+1);

				}

			}
	}
	public void Shoot_tosomeone(Enemy_smile_face e,Player p){
		Model bs,es=p.getItemState(),ps=e.getItemState();
		Bullet b;
		Clip_normal_enemy cl=(Clip_normal_enemy)ps.getClip_list().get(0);
	
		double bullet_angle,Xoffset,Yoffset; 
		
			if(cl.check_bullet()==false){
				//System.out.println(cl.bullet_number);
				
			}else{
				if(cl.get_bullet_speed_count()>ps.get_shoot_speed()){
					
					cl.set_bullet_speed_count(0);
					for(int i=0;i<cl.get_bullet_list_MAX();i++){	
						b=cl.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							
									
							b.changeState("flying");	
							double bsetx,bsety;							
							 bsetx=ps.get_X()+(ps.get_W()/2)-bs.get_W()/2;	 
							 bsety=ps.get_Y()+(ps.get_H()/2)-bs.get_H()/2;

							 bullet_angle=get_Angle(bsetx,bsety,es.get_X()+es.get_W()/2-bs.get_W()/2,es.get_Y()+es.get_H()/2-bs.get_H()/2);
							bs.setAngle(bullet_angle);

							//只差方向設定
							
							Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	   	 	   
						 	bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
					 		bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);
							cl.get_bullet();
							break;
						}
					}
					
				}else{
					cl.set_bullet_speed_count(cl.get_bullet_speed_count()+1);

				}

			}
	}
	public void Shoot_tosomeone(Boss e,Player p){
		Model bs,es=p.getItemState(),ps=e.getItemState();
		Bullet b;
		Clip_normal_enemy cl=(Clip_normal_enemy)ps.getClip_list().get(5);
		
		double bullet_angle,Xoffset,Yoffset; 
		
			if(cl.check_bullet()==false){
				//System.out.println(cl.bullet_number);
				
			}else{
				if(cl.get_bullet_speed_count()>ps.get_shoot_speed()){

					cl.set_bullet_speed_count(0);
					for(int i=0;i<cl.get_bullet_list_MAX();i++){	
						b=cl.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							
									
							b.changeState("flying");	
							double bsetx,bsety;							
							 bsetx=ps.get_X()+(ps.get_W()/2)-bs.get_W()/2;	 
							 bsety=ps.get_Y()+(ps.get_H()/2)-bs.get_H()/2;

							 bullet_angle=get_Angle(bsetx,bsety,es.get_X()+es.get_W()/2-bs.get_W()/2,es.get_Y()+es.get_H()/2-bs.get_H()/2);
							bs.setAngle(bullet_angle);

							//只差方向設定
							
							Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	   	 	   
						 	bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
					 		bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);
							cl.get_bullet();
							break;
						}
					}
					
				}else{
					cl.set_bullet_speed_count(cl.get_bullet_speed_count()+1);

				}

			}
	}
	public void Shoot_tosomeone(Boss2 e,Player p){
		Model bs,es=p.getItemState(),ps=e.getItemState();
		Bullet b;
		Clip_normal_enemy cl=(Clip_normal_enemy)ps.getClip_list().get(5);
		
		double bullet_angle,Xoffset,Yoffset; 
		
			if(cl.check_bullet()==false){
				//System.out.println(cl.bullet_number);
				
			}else{
				if(cl.get_bullet_speed_count()>ps.get_shoot_speed()){

					cl.set_bullet_speed_count(0);
					for(int i=0;i<cl.get_bullet_list_MAX();i++){	
						b=cl.get_bullet_list().get(i);
						bs=b.getItemState();
						if(bs.get_current_state().equals("Nothing")){
							
									
							b.changeState("flying");	
							double bsetx,bsety;							
							 bsetx=ps.get_X()+(ps.get_W()/2)-bs.get_W()/2;	 
							 bsety=ps.get_Y()+(ps.get_H()/2)-bs.get_H()/2;

							 bullet_angle=get_Angle(bsetx,bsety,es.get_X()+es.get_W()/2-bs.get_W()/2,es.get_Y()+es.get_H()/2-bs.get_H()/2);
							bs.setAngle(bullet_angle);

							//只差方向設定
							
							Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	   	 	   
						 	bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
					 		bs.setArea_X(bsetx);
							bs.setArea_Y(bsety);
							cl.get_bullet();
							break;
						}
					}
					
				}else{
					cl.set_bullet_speed_count(cl.get_bullet_speed_count()+1);

				}

			}
	}
	public void Shoot_to_angle(Boss e,double shoot_angle){
		Model bs;
		Bullet b;
		double bullet_angle,Xoffset,Yoffset; 
		for(int q=0;q<2;q++){
			cl1 =e.getItemState().getClip_list().get(q);
			if(cl1.get_bullet_speed_count()>e.getItemState().get_shoot_speed()){
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%e.getItemState().get_shoot_speed());
				for(int i=0;i<cl1.get_bullet_list_MAX();i++){
					b=cl1.get_bullet_list().get(i);
					bs=b.getItemState();
					if(bs.get_current_state().equals("Nothing")){
						b.changeState("flying");
						
						
						double bsetx=0.0,bsety=0.0;				
						 bullet_angle=shoot_angle;
						 Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
							
							
					 	    Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    		));
					 	    
						bs.setAngle(bullet_angle);
						if(b instanceof Bullet_Boss){
								switch(q){
								case 0:
									bsetx=e.getItemState().get_X()+e.getItemState().get_W()/2;
									break;
								case 1:
									bsetx=e.getItemState().get_X()+e.getItemState().get_W()/2;
									break;	
							}
							bs.setDirection_DY(Yoffset);
						 	bs.setDirection_DX(Xoffset);
						 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()-10;
						}
						bs.setArea_X(bsetx);
						bs.setArea_Y(bsety);			
						cl1.get_bullet();
						break;
					}
				}
			}else{
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
			}
		}
		
			
	}
	public void Boss2_Shoot_to_angle(Boss2 e,double shoot_angle,int type){
		Model bs;
		Bullet b;
		double bullet_angle,bullet_angle2=0.0,bullet_angle3=0.0,bullet_angle4=0.0;
		double Xoffset,Xoffset2,Xoffset3,Xoffset4;
		double Yoffset,Yoffset2,Yoffset3,Yoffset4; 
		
		 bullet_angle=shoot_angle;
				 //22.5 67.5
		 		 //bullet_angle2=bullet_angle+72.5;
				 //bullet_angle3=shoot_angle+72.5;
		 switch(type){
			 case 41:bullet_angle2=bullet_angle+45;
			   		bullet_angle3=shoot_angle+45;
			   		break;
			 case 42:bullet_angle2=bullet_angle+60.5;
			 		bullet_angle3=shoot_angle+60.5;
			 		break;
			 case 43:bullet_angle2=bullet_angle+30.5;
		   		bullet_angle3=shoot_angle+30.5;
		   		break;
		 }
		 bullet_angle4=shoot_angle+90;

		for(int q=0;q<4;q++){
			cl1 =e.getItemState().getClip_list().get(q);
			if(cl1.get_bullet_speed_count()>e.getItemState().get_shoot_speed()){
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%e.getItemState().get_shoot_speed());
				for(int i=0;i<cl1.get_bullet_list_MAX();i++){
					b=cl1.get_bullet_list().get(i);
					bs=b.getItemState();
					if(bs.get_current_state().equals("Nothing")){
						b.changeState("flying");
						
						
						double bsetx=0.0,bsety=0.0;				
						 Xoffset=(Math.sin(
									Math.toRadians(bullet_angle+180)
									));
					 	 Yoffset=(Math.cos(
					 	    		Math.toRadians(bullet_angle+180)
					 	    	  ));
					 	 Xoffset2=(Math.sin(
									Math.toRadians(bullet_angle2+180)
									));
					 	 Yoffset2=(Math.cos(
					 	    		Math.toRadians(bullet_angle2+180)
					 	    	  ));
					 	 Xoffset3=(Math.sin(
									Math.toRadians(bullet_angle3+180)
									));
					 	 Yoffset3=(Math.cos(
					 	    		Math.toRadians(bullet_angle3+180)
					 	    	  ));
					 	 Xoffset4=(Math.sin(
									Math.toRadians(bullet_angle4+180)
									));
					 	 Yoffset4=(Math.cos(
					 	    		Math.toRadians(bullet_angle4+180)
					 	    	  ));
						bsetx=e.getItemState().get_X()+e.getItemState().get_W()/2;
					 	bsety=e.getItemState().get_Y()+e.getItemState().get_H()/2;

						if(b instanceof Bullet_Boss){
								switch(q){
								case 0:
									bs.setAngle(bullet_angle);
									bs.setDirection_DY(Yoffset);
								 	bs.setDirection_DX(Xoffset);
									break;
								case 1:
									bs.setAngle(bullet_angle2);
									bs.setDirection_DY(Yoffset2);
								 	bs.setDirection_DX(Xoffset2);
									break;
								case 2:
									bs.setAngle(bullet_angle3);
									bs.setDirection_DY(Yoffset3);
								 	bs.setDirection_DX(Xoffset3);
									break;
								case 3:
									bs.setAngle(bullet_angle4);
									bs.setDirection_DY(Yoffset4);
								 	bs.setDirection_DX(Xoffset4);
									break;	
							}
						
						}
						bs.setArea_X(bsetx);
						bs.setArea_Y(bsety);			
						cl1.get_bullet();
						break;
					}
				}
			}else{
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
			}
		}
		
			
	}
	public void Boss2_Shoot_to_normal(Boss2 e,double shoot_angle){
		Model bs,es=e.getItemState();
		Bullet b;
		double bullet_angle;
		double Xoffset;
		double Yoffset; 
		
		 bullet_angle=shoot_angle;
		 		 
		for(int q=0;q<8;q++){
			cl1 =e.getItemState().getClip_list().get(q);
			if(cl1.get_bullet_speed_count()>e.getItemState().get_shoot_speed()){
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()%e.getItemState().get_shoot_speed());
				for(int i=0;i<cl1.get_bullet_list_MAX();i++){
					b=cl1.get_bullet_list().get(i);
					bs=b.getItemState();
					if(bs.get_current_state().equals("Nothing")){
						b.changeState("flying");
						
						
						double bsetx=0.0,bsety=0.0;	
						/*
						Xoffset=(Math.sin(
								Math.toRadians(bullet_angle+(45*q+22.5)+180)
								));
						Yoffset=(Math.cos(
				 	    		Math.toRadians(bullet_angle+(45*q+22.5)+180)
				 	    	  ));
						bs.setAngle(bullet_angle+45*q+22.5);
						 */
						Xoffset=(Math.sin(
								Math.toRadians(bullet_angle+(30*q+180)+270)
								));
						Yoffset=(Math.cos(
				 	    		Math.toRadians(bullet_angle+(30*q+180)+270)
				 	    	  ));
						bs.setAngle(bullet_angle+30*q+270);
						 bsetx=es.get_X()+(es.get_W()/2);	 
						 bsety=es.get_Y()+(es.get_H()/2);	
						bs.setDirection_DX(Xoffset);
						bs.setDirection_DY(Yoffset);
						/*
						Xoffset=(Math.sin(
								Math.toRadians(bullet_angle+180)
								));
				 	 Yoffset=(Math.cos(
				 	    		Math.toRadians(bullet_angle+180)
				 	    	  ));
					 	
						if(b instanceof Bullet_Boss){
							switch(q){						
							case 0:
								bullet_angle=22.5;
								bs.setDirection_DX(-0.25);
								bs.setDirection_DY(-0.75);
								
								break;
							case 1:
								bs.setDirection_DX(-0.75);
								bs.setDirection_DY(-0.25);
								bullet_angle=67.5;
								break;
							case 2:
								bs.setDirection_DX(-0.75);
								bs.setDirection_DY(0.25);
								bullet_angle=112.5;
								break;
							case 3:
								bs.setDirection_DX(-0.25);
								bs.setDirection_DY(0.75);
								bullet_angle=157.5;
								break;
							case 4:
								bs.setDirection_DX(0.25);
								bs.setDirection_DY(0.75);
								bullet_angle=202.5;
								break;
							case 5:
								bs.setDirection_DX(0.75);
								bs.setDirection_DY(0.25);
								bullet_angle=247.5;
								break;
							case 6:
								bs.setDirection_DX(0.75);
								bs.setDirection_DY(-0.25);
								bullet_angle=292.5;
								break;
							case 7:
								bs.setDirection_DX(0.25);
								bs.setDirection_DY(-0.75);
								bullet_angle=337.5;
								break;				
							}												 	   	 								
						}
						*/
						bs.setArea_X(bsetx);
						bs.setArea_Y(bsety);			
						cl1.get_bullet();
						break;
					}
				}
			}else{
				cl1.set_bullet_speed_count(cl1.get_bullet_speed_count()+1);
			}
		}
		
			
	}
	public double get_Angle(double x,double y,double px,double py){
	    double nx=px,ny=py;
	    double DRoation = Math.atan2(x-nx,y-ny);
	    double WRotation = DRoation/Math.PI*180;
	    return WRotation;
	}
	
}
