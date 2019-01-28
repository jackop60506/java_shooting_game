 

public class Flying_type {
	
	public static final double TIMESEP_1=10.0;//FAST
	public static final double TIMESEP_2=5.0;//R_FAST

	public static final double TIMESEP_3=1.0;//RRRRR_FAST
	public int Boss_dirchange=0;
	AImanage aimanage;
	
	
	public Flying_type(AImanage a){
		aimanage=a;
	}
	public void Enemy_rect_move(Enemy e){
		Model es = e.getItemState();
		
		double enemya = es.getAction_CD();
		es.setAction_CD(enemya+1.0);
		if(enemya<TIMESEP_1){
			switch(Boss_dirchange){
				case 0:
					if(es.get_X()<View.CONTROL_HEIGHT){
					aimanage.Enemy_Move_down(e);
					}
					break;
				case 1:
					if(es.get_X()<View.CONTROL_WIDTH-es.get_W()*2 ){
						aimanage.Enemy_Move_right(e);
					}
					break;
				case 2:
					aimanage.Enemy_Move_up(e);
					break;
				case 3:
					if(es.get_X()>0 ){
					aimanage.Enemy_Move_left(e);
					}
					break;
			}
			aimanage.add_speed(e, 3.0);
		}
			if(enemya>=TIMESEP_1 && enemya<TIMESEP_1+2 ){
				aimanage.Enemy_action_stop(e);
				es.setAddspeed(Enemy.STATIC_ADDSPEED);
			}
			if(enemya==TIMESEP_1+2){aimanage.recover(e);}
			if(enemya>=TIMESEP_1+3){
				Boss_dirchange=(Boss_dirchange+1)%4;
				es.setAction_CD(0.0);
			}
	}
	public void Enemy_s_move_normal(Enemy e,double angle,double dir){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		es.setAction_CD(enemycd+1.0);
		
		
		//0~5 == 可加次數
		//位移 e =5 而  timesep=1 是移動9.0像素
		//timesep=1 == 加一次 位移一次 timesep*1 
		int a=20;
		
		if(enemycd<TIMESEP_3*a){
			aimanage.Current_rotate(e,0.0*dir);
		}else if(enemycd>=TIMESEP_3*a && enemycd<TIMESEP_3*a+45 ){
			aimanage.Current_rotate(e,4.0*dir);
		}else if(enemycd>=TIMESEP_3*a+45 && enemycd<TIMESEP_3*(a*2+45) ){
			aimanage.Current_rotate(e,0.0*(-dir));
		}else if(enemycd>=TIMESEP_3*(a*2+45) && enemycd<TIMESEP_3*(a*2+90) ){
			aimanage.Current_rotate(e,4.0*(-dir));
		}else{
			System.out.println(123455);
			es.setAction_CD(0.0);
		}
		
		aimanage.Enemy_Move_face(e);
		//e.moveX();
		//e.moveY();
	}
	public void enemy_enter(Enemy e,double angle,double dir){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		if(enemycd<TIMESEP_1*2){
			
		}else{
			
		}
	}
	public void Enemy_s_move_special(Enemy e,double angle,double dir){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		es.setAction_CD(enemycd+1.0);
		double angle_sep=angle/2;
		double angle_p=4/(angle/44.0);
		//基準 22-> 8.0 44->4.0 88->2.0 打正
		
		//0~5 == 可加次數
		//位移 e =5 而  timesep=1 是移動9.0像素
		//timesep=1 == 加一次 位移一次 timesep*1 
			
		if(enemycd<TIMESEP_2*TIMESEP_3*2){
			
			aimanage.Current_rotate(e,0.0);
		}else if(enemycd>=TIMESEP_2*TIMESEP_3*2 && enemycd<TIMESEP_2*TIMESEP_3*2+angle_sep ){
			aimanage.Current_rotate(e,angle_p*dir);
		}else if(enemycd>=TIMESEP_2*(TIMESEP_3*2)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*6)+angle_sep ){
			aimanage.Current_rotate(e,0.0);
		}else if(enemycd>=TIMESEP_2*(TIMESEP_3*6)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*6)+angle_sep*2  ){
			aimanage.Current_rotate(e,angle_p*(-dir));
		}else if(enemycd>=TIMESEP_2*(TIMESEP_3*6)+angle_sep*2 && enemycd<TIMESEP_2*(TIMESEP_3*8 )+angle_sep*2 ){
			aimanage.Current_rotate(e,0.0);
		}
		else{
			
			es.setAction_CD(0.0);
		}
		aimanage.Enemy_Move_face(e);
		//e.moveX();
		//e.moveY();
	}
	public void Enemy_ss_move_special(Enemy e,double angle,double dir){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		es.setAction_CD(enemycd+1.0);
		double angle_sep=angle/2;
		double angle_p=4/(angle/44.0);
		//基準 22-> 8.0 44->4.0 88->2.0 打正
		
		//0~5 == 可加次數
		//位移 e =5 而  timesep=1 是移動9.0像素
		//timesep=1 == 加一次 位移一次 timesep*1 
			
		if(enemycd<TIMESEP_2*TIMESEP_3*6){
			
			aimanage.Current_rotate(e,0.0);
		}else if(enemycd>=TIMESEP_2*TIMESEP_3*6 && enemycd<TIMESEP_2*TIMESEP_3*6+angle_sep ){
			aimanage.Current_rotate(e,angle_p*dir);
		}else if(enemycd>=TIMESEP_2*(TIMESEP_3*6)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*18)+angle_sep ){
			aimanage.Current_rotate(e,0.0);
		}else if(enemycd>=TIMESEP_2*(TIMESEP_3*18)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*18)+angle_sep*2  ){
			aimanage.Current_rotate(e,angle_p*(-dir));
		}else if(enemycd>=TIMESEP_2*(TIMESEP_3*18)+angle_sep*2 && enemycd<TIMESEP_2*(TIMESEP_3*1000 )+angle_sep*2 ){
			aimanage.Current_rotate(e,0.0);
		}
		else{
			
			es.setAction_CD(0.0);
		}

		aimanage.Enemy_Move_face(e);
		//e.moveX();
		//e.moveY();
	}
	
	
	
	
	
	
	
	public void Enemy_U_move(Enemy e,double angle,double dir,int circular){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		es.setAction_CD(enemycd+1.0);
		double angle_sep=angle;
		double angle_p=4/(angle/45.0);
		//基準 22-> 8.0 44->4.0 88->2.0 打正
		
		//0~5 == 可加次數
		//位移 e =5 而  timesep=1 是移動9.0像素
		//timesep=1 == 加一次 位移一次 timesep*1 
		if(circular==0){
			if(enemycd<TIMESEP_2*TIMESEP_3*18){
				
				aimanage.Current_rotate(e,0.0);
			}else if(enemycd>=TIMESEP_2*TIMESEP_3*18 && enemycd<TIMESEP_2*TIMESEP_3*18+angle_sep ){
				aimanage.Current_rotate(e,angle_p*dir);
			}else if(enemycd>=TIMESEP_2*(TIMESEP_3*18)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*36)+angle_sep ){
				aimanage.Current_rotate(e,0.0);
			}else if(enemycd>=TIMESEP_2*(TIMESEP_3*36)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*36)+angle_sep*2  ){
				aimanage.Current_rotate(e,angle_p*(-dir));
			}else{
				es.setAction_CD(0.0);
			}
			aimanage.Enemy_Move_face(e);
		}else if(circular==1){
			if(enemycd<TIMESEP_2*TIMESEP_3*27){
				
				aimanage.Current_rotate(e,0.0);
			}else if(enemycd>=TIMESEP_2*TIMESEP_3*27 && enemycd<TIMESEP_2*TIMESEP_3*27+angle_sep ){
				aimanage.Current_rotate(e,angle_p*dir);
			}else if(enemycd>=TIMESEP_2*(TIMESEP_3*27)+angle_sep && enemycd<TIMESEP_2*(TIMESEP_3*38)+angle_sep ){
				aimanage.Current_rotate(e,0.0);
			}else{
				
				es.setAction_CD(0.0);
			}
			aimanage.Enemy_Move_face(e);
		}
	}
	public void Enemy_slow_LR_move(Enemy e){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		es.setAction_CD(enemycd+1.0);

		if(enemycd<TIMESEP_2){
			es.setDirection_DX(0.2);
		}else if(enemycd>=TIMESEP_2 && enemycd<TIMESEP_2*3 ){
			es.setDirection_DX(0.1);
		}else if(enemycd>=TIMESEP_2*3 && enemycd<TIMESEP_2*6 ){
			es.setDirection_DX(0.0);
		}else if(enemycd>=TIMESEP_2*6 && enemycd<TIMESEP_2*8 ){
			es.setDirection_DX(-0.1);
		}else if(enemycd>=TIMESEP_2*8 && enemycd<TIMESEP_2*9 ){
			es.setDirection_DX(-0.2);
		}else if(enemycd>=TIMESEP_2*9 && enemycd<TIMESEP_2*11 ){
			es.setDirection_DX(-0.1);
		}else if(enemycd>=TIMESEP_2*11 && enemycd<TIMESEP_2*14 ){
			es.setDirection_DX(0.0);
		}else if(enemycd>=TIMESEP_2*14 && enemycd<TIMESEP_2*16 ){
			es.setDirection_DX(0.1);
		}else{
			es.setAction_CD(0.0);
		}
		//aimanage.Enemy_Move_face(e);
		e.moveX();
		
	}
	//x 230
	public void Enemy_fast_LR_move(Enemy e){
		Model es = e.getItemState();
		double enemycd = es.getAction_CD();
		es.setAction_CD(enemycd+1.0);
		if(enemycd<TIMESEP_2*4){
			es.setDirection_DX(10.0);
		}else if(enemycd>=TIMESEP_2*4 && enemycd<TIMESEP_2*6 ){
			es.setDirection_DX(7.0);
		}else if(enemycd>=TIMESEP_2*6 && enemycd<TIMESEP_2*7 ){
			es.setDirection_DX(2.0);
		}else if(enemycd>=TIMESEP_2*7 && enemycd<TIMESEP_2*9 ){
			es.setDirection_DX(-7.0);
		}else if(enemycd>=TIMESEP_2*9 && enemycd<TIMESEP_2*17 ){
			es.setDirection_DX(-10.0);
		}else if(enemycd>=TIMESEP_2*17 && enemycd<TIMESEP_2*19 ){
			es.setDirection_DX(-7.0);
		}else if(enemycd>=TIMESEP_2*19 && enemycd<TIMESEP_2*20 ){
			es.setDirection_DX(-2.0);
		}else if(enemycd>=TIMESEP_2*20 && enemycd<TIMESEP_2*22 ){
			es.setDirection_DX(7.0);
		}else if(enemycd>=TIMESEP_2*22 && enemycd<TIMESEP_2*26 ){
			es.setDirection_DX(10.0);
		}else{
			es.setAction_CD(0.0);
		}
		//aimanage.Enemy_Move_face(e);
		e.moveX();
		
	}
	public void Enemy_flytoplayer(Enemy e){
		
	}
}
